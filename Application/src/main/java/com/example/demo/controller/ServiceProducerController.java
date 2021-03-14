package com.example.demo.controller;

import com.example.demo.producer.MessageQueueProducer;
import com.example.demo.producer.impl.MessageQueueJmsProducer;
import com.example.demo.service.SampleMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ServiceProducerController {

    private final SampleMessageService sampleMessageService;

    @PostMapping("/messages")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        log.info("Going to add message {} to emitter", message);

        sampleMessageService.processAndSendToQueue(message);

        return ResponseEntity.ok("Sent!");
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
}