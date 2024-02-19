package com.gatica.desafio.picpay.service;

import com.gatica.desafio.picpay.client.SendRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private SendRequest sendRequest;
    public boolean sendNotification() {
        String response = String.valueOf(sendRequest.sendRequest("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6"));
        return response.contains("true");

    }
}
