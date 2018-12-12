package com.cognizant.rabbitmqamqptutorials.one;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.amqp.core.Queue;

@Configuration
@Profile("one")
class OneConfiguration {

    @Bean
    Queue createQueue(@Value("${tutorial.queue:hello}") final String queueName) {
        return new Queue(queueName);
    }

    //Creating two beans and using @Value to pick a bean
    @Bean ("q2")
    Queue createAnotherQueue(@Value("${tutorial.queue:hello}") final String queueName) {
        System.out.println("\nQueue 2 \n");
        return new Queue("Q2");
    }
}
