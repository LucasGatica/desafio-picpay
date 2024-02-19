package com.gatica.desafio.picpay.service;

import com.gatica.desafio.picpay.client.SendRequest;
import com.gatica.desafio.picpay.model.TranferDAO;
import com.gatica.desafio.picpay.model.TypeUser;
import com.gatica.desafio.picpay.model.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class TransferService {

    private SendRequest sendRequest;
    private UserService userService;

    public ResponseEntity<String> transfer(@RequestBody TranferDAO tranferDAO) {

        try {
            User sender = userService.findById(tranferDAO.getIdSender());
            User receiver = userService.findById(tranferDAO.getIdReceiver());

            if (validUser(sender) && validWallet(sender, tranferDAO.getAmount()) && isAuthorized()) {
                sender.setWallet(sender.getWallet().subtract(tranferDAO.getAmount()));
                receiver.setWallet(receiver.getWallet().add(tranferDAO.getAmount()));
                userService.addUser(sender);
                userService.addUser(receiver);
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar transferência: " + e.getMessage());
        }
           return ResponseEntity.status(HttpStatus.OK).body("Transferência realizada com sucesso");
    }

    private boolean validWallet(User user, BigDecimal amount){
        System.out.println("Validando carteira do usuário" +user.getWallet().compareTo(amount));
        if(!(user.getWallet().compareTo(amount) >=0))
            throw new IllegalArgumentException("Saldo insuficiente");
        return true;
    }
    private boolean validUser(User user){
        if (!user.getTypeUser().equals(TypeUser.COMMON))
            throw new IllegalArgumentException("Usuário logista não pode realizar transferência");
        return true;
    }

    private boolean isAuthorized() throws Exception {
        String response = String.valueOf(sendRequest.sendRequest("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc"));
        if(!response.contains("Autorizado"))
                throw new IllegalArgumentException("Transação não autorizada");
        return true;
    }

}
