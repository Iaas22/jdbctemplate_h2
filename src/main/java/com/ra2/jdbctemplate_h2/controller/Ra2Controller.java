package com.ra2.jdbctemplate_h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.



RestController;

import com.ra2.jdbctemplate_h2.model.Customer;
import com.ra2.jdbctemplate_h2.repository.CustomerRepository;
@RestController
@RequestMapping("/jdbctemplate")
public class Ra2Controller {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("hello")
    public String jdbtemp(){
        return "hello";

    }

    @PostMapping("/init-db")
    customerRepository.createTableCustomers();
    customerRepository.insertSampleData();
    return "Base de dades inizialitzada correctament";

    @GetMapping("/findAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
}

}
