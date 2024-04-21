package com.stackroute.adminservice.controller;
///his class for the sending the data of the batch to queue then consumer will consume it

import com.stackroute.adminservice.model.Batch;
import com.stackroute.adminservice.services.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/admin")
@CrossOrigin(value="*")
public class AdminController
{
        private RabbitMqSender rabbitMqSender;

        @Autowired
        public AdminController(RabbitMqSender rabbitMqSender) {
                this.rabbitMqSender = rabbitMqSender;
        }

        @Value("${app.message}")
        private String message;


        @PostMapping("/batch")
        public String publishBatchDetails(@RequestBody Batch batch) {
                rabbitMqSender.send(batch);
                return message;
        }

}
