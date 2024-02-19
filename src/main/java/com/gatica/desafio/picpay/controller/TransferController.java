package com.gatica.desafio.picpay.controller;

import com.gatica.desafio.picpay.model.TranferDAO;

import com.gatica.desafio.picpay.service.NotificationService;
import com.gatica.desafio.picpay.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
@AllArgsConstructor
public class TransferController {

    private TransferService transferService;
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<String> transfer(@RequestBody TranferDAO tranferDAO){
        ResponseEntity<String> response = transferService.transfer(tranferDAO);

        if(response.getStatusCode().equals(HttpStatus.OK))
            System.out.println("notificação enviada "+ notificationService.sendNotification());

        return response;
    }


}
