package org.sid.billingservice;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingservice.model.Bill;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.model.ProductItem;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.sid.billingservice.service.CustomerService;
import org.sid.billingservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;


import org.springframework.hateoas.PagedModel;

import java.util.Date;


@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication implements CommandLineRunner {

    @Autowired
    BillRepository billRepository;
    @Autowired
    ProductItemRepository productItemRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    InventoryService inventoryService;

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class,args);
    }

   @Override
   public void run(String... args)  {
        {
            Customer c1 = customerService.findCustomerById(1L);
            System.out.println("********************************");
            System.out.println("ID" + c1.getId());
            System.out.println("Name" + c1.getName());
            System.out.println("E-mail" + c1.getEmail());
            System.out.println("********************************");
            Bill bill1 = billRepository.save(new Bill(null, new Date(), c1.getId(),c1, null));

            PagedModel<Product> products = inventoryService.findAllProduct();
            products.getContent().forEach(p -> {
                productItemRepository.save((new ProductItem(null,p.getId(),p,p.getPrice(),13.0,bill1)));

            });


        }}}






