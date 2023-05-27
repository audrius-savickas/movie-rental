package com.example.movierental.services;

import com.example.movierental.mybatis.dao.CustomerMapper;
import com.example.movierental.mybatis.model.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerServiceImplementation implements CustomerService {
    @Inject
    private CustomerMapper customerMapper;

    @Override
    public String createCustomer(Customer customer) {
        customerMapper.insert(customer);
        return "/index?faces-redirect=true";
    }
}
