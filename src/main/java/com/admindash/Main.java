package com.admindash;

import com.admindash.customer.Customer;
import com.admindash.customer.CustomerRespository;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRespository customerRespository) {

        return args -> {
            var faker = new Faker();
            Name name  = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            Random random = new Random();

            Customer customer = new Customer(
                    firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com",
                    random.nextInt(16, 99));

            customerRespository.save(customer);
        };
    }

}
