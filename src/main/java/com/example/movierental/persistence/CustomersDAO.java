package com.example.movierental.persistence;

import com.example.movierental.entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CustomersDAO {
    @Inject
    EntityManager em;

    public void persist(Customer customer){
        this.em.persist(customer);
    }

    public Customer findOne(Integer id){
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public Customer update(Customer customer){
        return em.merge(customer);
    }
}
