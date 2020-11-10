package org.sid.DeliveryService;

import org.sid.DeliveryService.model.Bill;
import org.sid.DeliveryService.model.DelieveryDetails;
import org.sid.DeliveryService.repository.BillRepository;
import org.sid.DeliveryService.repository.DeliveryDetailsRepository;
import org.sid.DeliveryService.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;


@SpringBootApplication
@EnableFeignClients


public class DeliveryServiceApplication implements CommandLineRunner {

	@Autowired
	BillRepository billRepository;
	@Autowired
	DeliveryDetailsRepository DeliveryDetailsRepository;
	@Autowired
	BillingService billingService;
	@Autowired
	DeliveryDetailsRepository deliveryDetailsRepository;
	@Autowired
	RepositoryRestConfiguration restConfiguration;


	public static void main(String[] args) {SpringApplication.run(DeliveryServiceApplication.class,args);
	}

	@Override
	@PostConstruct
	public void run(String... args)  {
		{
			Bill b1 = billingService.findBillById(1L);
			System.out.println("********************************");
			System.out.println("ID Bill" + b1.getId());
			System.out.println("********************************");
			DeliveryDetailsRepository.save(new DelieveryDetails(1,"shipped","EMS",b1));
		}
		}}

