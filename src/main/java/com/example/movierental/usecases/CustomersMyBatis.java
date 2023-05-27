package com.example.movierental.usecases;

import com.example.movierental.mybatis.dao.CustomerMapper;
import com.example.movierental.mybatis.model.Customer;
import com.example.movierental.services.CustomerNameGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class CustomersMyBatis implements Serializable {
    @Inject
    private CustomerMapper customerMapper;

    @Inject
    private CustomerNameGenerator customerNameGenerator;

    @Getter @Setter
    private Customer customerToCreate = new Customer();

    private CompletableFuture<String> customerNameGenerationTask = null;

    @Transactional
    public String createCustomer() {
        customerMapper.insert(customerToCreate);
        return "/index?faces-redirect=true";
    }

    public String generateCustomerName() {
        customerNameGenerationTask = CompletableFuture.supplyAsync(() -> customerNameGenerator.generateCustomerName());
        customerNameGenerationTask.thenAccept(name -> customerToCreate.setName(name));
        return "/index?faces-redirect=true";
    }

    public String getCustomerNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (customerNameGenerationTask == null) {
            return null;
        } else if (customerNameGenerationTask != null && !customerNameGenerationTask.isDone()) {
            return "Name generation in progress";
        }
        return "Generated name: " + customerNameGenerationTask.get();
    }
}
