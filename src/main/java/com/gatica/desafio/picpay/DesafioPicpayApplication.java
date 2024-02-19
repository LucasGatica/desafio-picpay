package com.gatica.desafio.picpay;

import com.gatica.desafio.picpay.client.SendRequest;
import com.gatica.desafio.picpay.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DesafioPicpayApplication {

	public static void main(String[] args) {

		SpringApplication.run(DesafioPicpayApplication.class, args);

	}

}
