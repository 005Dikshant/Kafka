package com.producer.controller;

import com.producer.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);


    @GetMapping("/publish/common")
    public String sendMessageToCommonTopic(@RequestParam("message") String message){
        producerService.sendMessageToCommonTopics(message);

        return "Message sent to common topic: " + message;
    }

    @GetMapping("/publish/number")
    public String sendMessageToOddOrEven(@RequestParam("message") String message) {
        try {
            int number = Integer.parseInt(message);
            if(number % 2 == 0){
                producerService.sendMessageToEvenTopic(message);
                return "Message sent to even topic: " + message;
            } else {
                producerService.sendMessageToOddTopic(message);
                return "Message sent to odd topic: " + message;
            }

        }catch(Exception e){
            logger.info("Invalid input: {}", e.getMessage());
            return "Invalid input: please provide a valid integer";
        }

    }
}
