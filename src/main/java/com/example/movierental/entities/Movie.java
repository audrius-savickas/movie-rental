package com.example.movierental.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "select m from Movie as m")
})
@Getter @Setter
@EqualsAndHashCode
@Table(name="MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "name")
    private String title;

    @Basic
    private String director;

    @Basic
    private String description;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Genre> genres = new ArrayList<>();
}
