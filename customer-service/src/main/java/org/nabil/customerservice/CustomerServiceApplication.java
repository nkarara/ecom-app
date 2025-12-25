package org.nabil.customerservice;

import org.nabil.customerservice.config.CustomerConfigParams;
import org.nabil.customerservice.entities.Customer;
import org.nabil.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("Nabil")
                            .email("nabil@gmail.com")
                    .build());

            customerRepository.save(Customer.builder()
                            .name("Nabil2")
                            .email("nabil2@gmail.com")
                    .build());

            customerRepository.save(Customer.builder()
                            .name("Nabil3")
                            .email("nabil3@gmail.com")
                    .build());

            customerRepository.findAll().forEach(c->{
                System.out.println("===========================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("===========================");
            });
        };
    }

}
