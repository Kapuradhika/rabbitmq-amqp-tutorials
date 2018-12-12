package com.cognizant.rabbitmqamqptutorials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class DefaultConfiguration {

    @Profile("show_usage_message")
    @Bean
    public CommandLineRunner createUsageMessage() {
        return args -> {
            System.out.println("\nThis app uses Spring Profiles to control its behavior.\n");
            System.out.println("Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
        };
    }
}