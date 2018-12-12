package com.cognizant.rabbitmqamqptutorials.two;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"two","work-queues"})
@Configuration
class TwoConfiguration {
    @Bean
    public Queue hello(@Value("${tutorial.queue}") final String queueName) {
        System.out.println("\n"+queueName+"\n");
        return new Queue(queueName);
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public TwoReceiver receiver1() {
            System.out.println("========-------> receiver 1");
            return new TwoReceiver(1);
        }

        @Bean
        public TwoReceiver receiver2() {
            System.out.println("========-------> receiver 2");
            return new TwoReceiver(2);
        }
    }

    @Profile("sender")
    @Bean
    public TwoSender sender() {
        return new TwoSender();
    }
}
