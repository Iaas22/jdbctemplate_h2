package com.ra2.jdbctemplate_h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra2.jdbctemplate_h2.model.Customer;
import com.ra2.jdbctemplate_h2.repository.CustomerRepository;

@RestController
@RequestMapping("/jdbctemplate")
public class Ra2Controller {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/hello")
    public String jdbtemp() {
        return "Hola desde JDBC Template";
    }

    @PostMapping("/init-db")
    public String initDatabase() {
        customerRepository.createTableCustomers();
        customerRepository.insertSampleData();
        return "Base de datos inicializada correctamente";
    }

    @GetMapping("/findAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        customerRepository.createCustomer(customer);
        return "customer creadooooo";
    }
}
