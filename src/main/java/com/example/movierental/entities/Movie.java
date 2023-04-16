package com.example.movierental.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Movie {

    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "name")
    private String title;

    @Basic
    private String director;

    @Basic
    private String releaseDate;

    @Basic
    private String description;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Genre> genres;
}
