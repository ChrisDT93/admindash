package com.admindash;

import com.admindash.customer.Customer;
import com.admindash.customer.CustomerRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRespository customerRespository) {

        return args -> {
            Customer alex = new Customer( "Alex", "alex@gmail.com", 20);
            Customer jamila = new Customer( "Jamila", "jamila@gmail.com", 25);

            List<Customer> customers = List.of(alex, jamila);
            customerRespository.saveAll(customers);
        };
    }

}
