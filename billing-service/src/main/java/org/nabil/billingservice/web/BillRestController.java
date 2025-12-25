package org.nabil.billingservice.web;

import org.nabil.billingservice.entities.Bill;
import org.nabil.billingservice.feign.CustomerRestClient;
import org.nabil.billingservice.feign.ProductRestClient;
import org.nabil.billingservice.repository.BillRepository;
import org.nabil.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getByCustomerId(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> productItem.setProduct(productRestClient.getByProductId(productItem.getProductId())));
        return bill;
    }
}
