package com.gatica.desafio.picpay.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class TranferDAO {

    private String idSender;
    private String idReceiver;
    private BigDecimal amount;
}
