package com.example.movierental.rest;

import com.example.movierental.entities.Customer;
import com.example.movierental.interceptors.LoggedInvocation;
import com.example.movierental.persistence.CustomersDAO;
import com.example.movierental.rest.dto.CreateCustomerDTO;
import com.example.movierental.rest.dto.GetCustomerDTO;
import com.example.movierental.rest.dto.UpdateCustomerDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/customers")
@LoggedInvocation
public class CustomerController {
    @Inject
    private CustomersDAO customersDAO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Customer customer = customersDAO.findOne(id);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<Long> movieIds = customer.getMovies().stream().map(movie -> movie.getId()).collect(Collectors.toList());
        GetCustomerDTO customerDTO = new GetCustomerDTO(customer.getId(), customer.getName(), customer.getEmail(),
                movieIds);
        return Response.ok(customerDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(CreateCustomerDTO createCustomerDTO) {
        Customer customer = new Customer();
        customer.setName(createCustomerDTO.getName());
        customer.setEmail(createCustomerDTO.getEmail());
        customersDAO.persist(customer);

        URI customerUri = UriBuilder.fromPath("customers/{id}")
                .resolveTemplate("id", customer.getId())
                .build();
        return Response.created(customerUri).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long customerId, UpdateCustomerDTO updateCustomerDTO) {
        Customer customer = customersDAO.findOne(customerId);

        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        customer.setName(updateCustomerDTO.getName());
        customer.setEmail(updateCustomerDTO.getEmail());
        customersDAO.persist(customer);

        GetCustomerDTO getCustomerDTO = new GetCustomerDTO(customer.getId(), customer.getName(), customer.getEmail(),
                customer.getMovies().stream().map(movie -> movie.getId()).collect(Collectors.toList()));

        return Response.ok(getCustomerDTO).build();
    }

}
