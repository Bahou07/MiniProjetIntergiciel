package org.sid.DeliveryService.service;

import org.sid.DeliveryService.model.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "billing-service")
public interface BillingService {

    @GetMapping("/fullBill/{id}")
     Bill findBillById(@PathVariable(name="id") Long id);
}
