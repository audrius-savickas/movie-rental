package com.example.movierental.usecases;

import com.example.movierental.mybatis.dao.CustomerMapper;
import com.example.movierental.mybatis.model.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class CustomersMyBatis {
    @Inject
    private CustomerMapper customerMapper;

    @Getter @Setter
    private Customer customerToCreate = new Customer();

    @Transactional
    public String createCustomer() {
        customerMapper.insert(customerToCreate);
        return "/index?faces-redirect=true";
    }
}
