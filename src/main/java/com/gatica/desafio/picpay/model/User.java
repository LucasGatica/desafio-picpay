package com.gatica.desafio.picpay.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    String id;
    String name;
    @Indexed(unique = true)
    String cpf;
    @Indexed(unique = true)
    String email;
    String password;
    BigDecimal wallet;
    TypeUser typeUser;

}
