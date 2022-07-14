package com.test.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class DateFlow {

    @Bean
    public IntegrationFlow urlHandler() {
        return IntegrationFlows.from("requestChannel")
                .handle(print())
                .get();
    }



    public MessageHandler print() {
        ObjectMapper mapper = new ObjectMapper();
        return message -> {
            try {
                Date date = mapper.readValue(new URL(message.getPayload().toString()), Date.class);
                System.out.println(date.getDatetime());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}

