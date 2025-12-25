package org.nabil.billingservice;

import org.nabil.billingservice.entities.Bill;
import org.nabil.billingservice.entities.ProductItem;
import org.nabil.billingservice.feign.CustomerRestClient;
import org.nabil.billingservice.feign.ProductRestClient;
import org.nabil.billingservice.model.Customer;
import org.nabil.billingservice.model.Product;
import org.nabil.billingservice.repository.BillRepository;
import org.nabil.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient
                                        ){
        Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
        Collection<Product> products = productRestClient.getAllProducts().getContent();

        return args -> {
            customers.forEach( customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();

                billRepository.save(bill);


                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .quantity(1+new Random().nextInt(10))
                            .unitPrice(product.getPrice())
                            .build();

                    productItemRepository.save(productItem);


                });
            });
        };
    }

}
