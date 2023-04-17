package com.example.movierental.persistence;

import com.example.movierental.entities.Movie;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class MoviesDAO {
    @Inject
    EntityManager em;

    public void persist(Movie movie){
        this.em.persist(movie);
    }

    public Movie findOne(Long id){
        return em.find(Movie.class, id);
    }

    public List<Movie> findAll() {
        return em.createNamedQuery("Movie.findAll", Movie.class).getResultList();
    }

    public Movie update(Movie movie){
        return em.merge(movie);
    }
}
