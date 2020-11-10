package org.sid.DeliveryService.Controller;

import org.sid.DeliveryService.model.DelieveryDetails;
import org.sid.DeliveryService.repository.BillRepository;
import org.sid.DeliveryService.repository.DeliveryDetailsRepository;
import org.sid.DeliveryService.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeliveryDetailsRestController {
    @Autowired
    private BillingService billingService;
    @Autowired
    private DeliveryDetailsRepository DeliveryDetailsRepository;


    @GetMapping("/deliverydetails")
    public List<DelieveryDetails> getDeliveryDetails() {

         List<DelieveryDetails> DeliveryDetails =DeliveryDetailsRepository.findAll();
      DeliveryDetails.forEach(d->{
            d.setBill(billingService.findBillById(d.getBill().getId()));
        });
        return DeliveryDetails;

    }}