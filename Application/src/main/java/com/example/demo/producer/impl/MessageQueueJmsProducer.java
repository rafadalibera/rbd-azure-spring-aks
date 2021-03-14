package com.example.demo.producer.impl;

import com.example.demo.model.SampleMessage;
import com.example.demo.producer.MessageQueueProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessageQueueJmsProducer implements MessageQueueProducer {

    @Value("${spring.jms.servicebus.queues.queue-1}")
    private String queueName;

    private final JmsTemplate jmsTemplate;

    public void sendMessage(SampleMessage sampleMessage) {

        jmsTemplate.convertAndSend(queueName, sampleMessage, m -> {
            m.setStringProperty("header", "test");
            return m;
        });
    }
}
