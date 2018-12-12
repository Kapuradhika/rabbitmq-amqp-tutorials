package com.cognizant.rabbitmqamqptutorials.one;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("one-receiver")
@RabbitListener(queues = "hello")
final class OneReceiver {

    @RabbitHandler
    public void receive(final String in){
        System.out.println(" [x] Received '" + in + "'");
    }
}
