package com.example.movierental.usecases;

import com.example.movierental.entities.Genre;
import com.example.movierental.entities.Movie;
import com.example.movierental.persistence.GenresDAO;
import com.example.movierental.persistence.MoviesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Movies {
    @Inject
    MoviesDAO moviesDAO;

    @Getter
    private List<Movie> allMovies;

    @Getter @Setter
    private Movie movieToCreate = new Movie();

    @PostConstruct
    public void init(){
        loadAllMovies();
    }

    private void loadAllMovies(){
        this.allMovies = moviesDAO.findAll();
    }

    @Transactional
    public String createNewMovie() {

        moviesDAO.persist(movieToCreate);
        return "/movies?faces-redirect=true";
    }
}
