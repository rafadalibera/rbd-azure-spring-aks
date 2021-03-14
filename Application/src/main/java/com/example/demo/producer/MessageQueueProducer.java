package com.example.demo.producer;

import com.example.demo.model.SampleMessage;

public interface MessageQueueProducer {

    void sendMessage (SampleMessage message);
}
