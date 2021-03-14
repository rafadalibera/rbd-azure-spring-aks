package com.example.demo.service.impl;

import com.example.demo.model.SampleMessage;
import com.example.demo.producer.MessageQueueProducer;
import com.example.demo.service.SampleMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class SampleMessageServiceImpl implements SampleMessageService {

    private final MessageQueueProducer producer;

    @Override
    public void processAndSendToQueue(String message) {

        SampleMessage sampleMessage = buildSampleMessage(message);
        producer.sendMessage(sampleMessage);
    }

    @Override
    public void processAndSendToTopic(String message) {

    }

    private SampleMessage buildSampleMessage(String message){
        return SampleMessage.builder()
                .message(message)
                .date(getCurrentDate())
                .time(getCurrentTime())
                .build();
    }

    private String getCurrentDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    private String getCurrentTime(){
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }
}
