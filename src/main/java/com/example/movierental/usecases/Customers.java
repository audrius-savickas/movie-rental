package com.example.movierental.usecases;

import com.example.movierental.entities.Customer;
import com.example.movierental.persistence.CustomersDAO;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Customers {
    @Inject
    CustomersDAO customersDAO;

    @Getter
    private List<Customer> allCustomers;

    @PostConstruct
    public void init(){
        loadAllCustomers();
    }

    private void loadAllCustomers(){
        this.allCustomers = customersDAO.findAll();
    }
}
