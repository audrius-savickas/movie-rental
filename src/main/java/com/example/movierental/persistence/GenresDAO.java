package com.example.movierental.persistence;

import com.example.movierental.entities.Genre;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GenresDAO {
    @Inject
    EntityManager em;

    public void persist(Genre genre){
        this.em.persist(genre);
    }

    public Genre findOne(Long id){
        return em.find(Genre.class, id);
    }

    public List<Genre> findAll() {
        return em.createNamedQuery("Genre.findAll", Genre.class).getResultList();
    }

    public Genre update(Genre genre){
        return em.merge(genre);
    }
}
