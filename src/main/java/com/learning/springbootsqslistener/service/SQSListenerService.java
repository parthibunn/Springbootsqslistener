package com.learning.springbootsqslistener.service;

import com.learning.springbootsqslistener.config.AwsSQSConfig;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SQSListenerService {

    @Autowired
    AwsSQSConfig awsSQSConfig;

    public String pollMessage(){
        Optional<Message<?>> message = awsSQSConfig.sqsTemplate(awsSQSConfig.sqsAsyncClient()).receive(
                from -> from.queue("EmployeeQueue")
        );
        return message.get().getPayload().toString();
    }

   @SqsListener("EmployeeQueue" )
    public void listen(Message<?> message) {

        System.out.println("listen - " + message.getPayload().toString());
    }
}
