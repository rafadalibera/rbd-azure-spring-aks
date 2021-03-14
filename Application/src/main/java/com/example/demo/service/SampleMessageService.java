package com.example.demo.service;

public interface SampleMessageService {

    void processAndSendToQueue(String message);
    void processAndSendToTopic (String message);
}
