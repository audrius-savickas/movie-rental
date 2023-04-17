package com.example.movierental.usecases;

import com.example.movierental.entities.Genre;
import com.example.movierental.persistence.GenresDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Genres {
    @Inject
    GenresDAO genresDAO;

    @Getter
    private List<Genre> allGenres;

    @Getter @Setter
    private Genre genreToCreate = new Genre();

    @PostConstruct
    public void init(){
        loadAllGenres();
    }

    private void loadAllGenres(){
        this.allGenres = genresDAO.findAll();
    }

    @Transactional
    public void createGenre() {
        this.genresDAO.persist(this.genreToCreate);
    }
}
