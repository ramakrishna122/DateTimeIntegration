package com.test.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface CustomGateway {
    @Gateway(requestChannel = "requestChannel")
    void start(String url);
}
