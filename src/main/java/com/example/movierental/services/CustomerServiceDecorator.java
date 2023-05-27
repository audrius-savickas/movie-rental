package com.example.movierental.services;


import com.example.movierental.mybatis.model.Customer;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.regex.Pattern;

@Decorator
public class CustomerServiceDecorator implements CustomerService {
    @Inject @Delegate CustomerService delegate;

    private final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    @Override
    public String createCustomer(Customer customer) {
        if (!emailPattern.matcher(customer.getEmail()).matches()) {
            throw new IllegalArgumentException("Email is not valid");
        }
        return delegate.createCustomer(customer);
    }
}
