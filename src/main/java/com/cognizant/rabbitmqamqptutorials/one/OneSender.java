package com.cognizant.rabbitmqamqptutorials.one;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Profile("one-sender")
final class OneSender {

    private final AtomicInteger  count = new AtomicInteger(0);
    private final Queue queue;
    private final RabbitTemplate template;

    OneSender(@Value("q2") final Queue queue, final RabbitTemplate template) {
        this.queue = queue;
        this.template = template;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        final String message = "Hello World! " + count.incrementAndGet();
        template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}