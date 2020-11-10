package org.sid.billingservice.service;

import org.sid.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerService {

    @GetMapping("/all/{id}")
    Customer findCustomerById(@PathVariable(name="id") Long id);
}
