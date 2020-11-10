package org.sid.billingservice.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class Product {

    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private Double price;
}
