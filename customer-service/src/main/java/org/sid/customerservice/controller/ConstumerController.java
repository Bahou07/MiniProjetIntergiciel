package org.sid.customerservice.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.sid.customerservice.command.CreateCustomerCommand;
import org.sid.customerservice.controller.request.CustomerRequest;
import org.sid.customerservice.domain.Customer;
import org.sid.customerservice.entry.CustomerEntry;
import org.sid.customerservice.repository.CustomerEntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ConstumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConstumerController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    CustomerEntryRepository customerEntryRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CustomerEntry createCustomer(@RequestBody @Valid CustomerRequest request) {
        LOGGER.info("request creat new costomer {}", request);

        CustomerEntry customerEntry=customerEntryRepository.save(new CustomerEntry(request.getName(),request.getEmail()));
        commandGateway.send(
                new CreateCustomerCommand(request.getCustomerId(),
                        request.getName(),
                        request.getEmail()));

        return customerEntry;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity greetingHello() {

        LOGGER.info("retrive all consumers");

        return ResponseEntity.ok()
                .body(customerEntryRepository.findAll());
    }

    @GetMapping("/all/{id}")
    public ResponseEntity greetingHello(@PathVariable Long id) {

        LOGGER.info("retrive all consumers");
        CustomerEntry customerEntry = customerEntryRepository.findById(id).get();

        return ResponseEntity.ok()
                .body(customerEntry);
    }
}
