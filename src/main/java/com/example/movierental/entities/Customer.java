package com.example.movierental.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer as c")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Movie> movies = new ArrayList<>();
}
