package com.cognizant.rabbitmqamqptutorials;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!show_usage_message")
@Component
public class RabbitCommandLineRunner implements CommandLineRunner {

    private final ConfigurableApplicationContext context;

    private final int duration;

    RabbitCommandLineRunner(final ConfigurableApplicationContext context, @Value("${tutorial.client.duration}") final int duration) {
        this.context = context;
        this.duration = duration;
    }

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Ready ... running for " + duration + "ms");
        Thread.sleep(duration);
        context.close();
    }
}
