package com.example.demo.consumer;

import com.example.demo.model.SampleMessage;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public interface MessageQueueListener {

    void receiveMessage(@Payload SampleMessage sampleMessage, @Header("header") String header);
}
