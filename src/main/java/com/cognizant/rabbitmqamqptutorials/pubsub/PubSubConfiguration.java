package com.cognizant.rabbitmqamqptutorials.pubsub;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile("pubsub")
@Configuration
class PubSubConfiguration {

    @Bean
    public FanoutExchange fanout() {
        return new FanoutExchange("pubsub.fanout");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Queue autoDeleteQueue1() {
            System.out.println("In Anonymous 1: ----> ");
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2() {
            System.out.println("In Anonymous 2: ----> ");
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1) {
            System.out.println("================>>"+autoDeleteQueue1.getActualName());
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2) {
            System.out.println("================>>"+autoDeleteQueue2.getActualName());
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

        @Bean
        public PubSubReceiver receiver() {
            return new PubSubReceiver();
        }
    }

    @Profile("sender")
    @Bean
    public PubSubSender sender() {
        return new PubSubSender();
    }
}