package com.basanta.chat.room.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class Config implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*to connect with server*/
        registry.addEndpoint("/server").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

            /*to subscribe so that we can receive messages*/
            registry.enableSimpleBroker("/topic");

            /*to send the message*/
            registry.setApplicationDestinationPrefixes("/app");
    }
}
