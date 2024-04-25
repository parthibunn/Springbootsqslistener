package com.learning.springbootsqslistener.controller;

import com.learning.springbootsqslistener.service.SQSListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSListenerController {

    @Autowired
    SQSListenerService sqsListenerService;

    @GetMapping("pollMessage")
    public String pollMessage() {
        return sqsListenerService.pollMessage();
    }
}
