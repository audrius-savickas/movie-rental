package com.example.movierental.usecases;

import com.example.movierental.mybatis.dao.CustomerMapper;
import com.example.movierental.mybatis.dao.MovieMapper;
import com.example.movierental.mybatis.model.Customer;
import com.example.movierental.mybatis.model.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class CustomerDetailsMyBatis {
    @Inject
    CustomerMapper customerMapper;

    @Inject
    MovieMapper movieMapper;

    @Getter
    @Setter
    Customer customer;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long customerId = Long.parseLong(requestParameters.get("customerId"));
        this.customer = customerMapper.selectByPrimaryKey(customerId);
    }

    @Transactional
    public String returnMovie(Long id) {
        Movie movie = movieMapper.selectByPrimaryKey(id);
        movie.setCustomerId(null);
        movieMapper.updateByPrimaryKey(movie);
        return "customerDetails.xhtml?faces-redirect=true&customerId=" + customer.getId();
    }
}
