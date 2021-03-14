package com.example.demo.consumer.impl;

import com.example.demo.consumer.MessageQueueListener;
import com.example.demo.model.SampleMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageQueueJmsListener implements MessageQueueListener {

    @JmsListener(destination = "${spring.jms.servicebus.queues.queue-1}", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(@Payload SampleMessage sampleMessage, @Header("header") String header) {

        log.info(MessageFormat.format("Received message from queue: {0}, sent at: {1}:{2}",
                sampleMessage.getMessage(), sampleMessage.getDate(), sampleMessage.getTime()));
        log.info(MessageFormat.format("Header: header : {0}", header));
    }
}

