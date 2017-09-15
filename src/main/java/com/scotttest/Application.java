package com.scotttest;

import com.scotttest.model.Customer;
import com.scotttest.repository.CustomersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomersRepository repository) {
        return (args) -> {
            repository.save(new Customer("Peter", "peter@test.com", "8(888)1111111", 10L));
            repository.save(new Customer("Nicole", "nicole@test.com", "8(888)11111112", 0L));
            repository.save(new Customer("Justin", "justin@test.com", "8(888)1111113", 2L));
            repository.save(new Customer("Kurt", "kurt@test.com", "8(888)1111114", 8L));
            repository.save(new Customer("Richard", "richard@test.com", "8(888)1111115", 14L));
        };
    }

}