package org.sid.DeliveryService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelieveryDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdDeliveryDetails;
    private String statues;
    private String ShippingMethod ;
    @OneToOne
    private Bill bill;
}
