package org.sid.billingservice.controller;


import org.sid.billingservice.model.Bill;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.sid.billingservice.service.CustomerService;
import org.sid.billingservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BillRestController {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(pi ->{
            pi.setProduct(inventoryService.findProductById(pi.getProductID()));
        });
        return bill;
    }

    @GetMapping("/bills")
    public List<Bill> getBills() {

        List<Bill> bills = billRepository.findAll();
        bills.forEach(b->{
            b.setCustomer(customerService.findCustomerById(b.getId()));
        });

        return bills;
    }
}


