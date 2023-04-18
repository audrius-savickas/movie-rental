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
        @NamedQuery(name = "Genre.findAll", query = "select g from Genre as g")
})public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies = new ArrayList<>();
}
