package com.example.movierental.usecases;

import com.example.movierental.entities.Genre;
import com.example.movierental.entities.Movie;
import com.example.movierental.persistence.GenresDAO;
import com.example.movierental.persistence.MoviesDAO;
import com.example.movierental.services.MovieDownloadService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Model
public class Movies {
    @Inject
    MoviesDAO moviesDAO;

    @Inject
    GenresDAO genresDAO;

    @Inject
    MovieDownloadService movieDownloadService;

    @Getter
    private List<Movie> allMovies;

    @Getter
    private List<Genre> allGenres;

    @Getter @Setter
    private Movie movieToCreate = new Movie();

    @Getter @Setter
    private List<Long> genreIds = new ArrayList<>();

    @PostConstruct
    public void init(){
        loadAllMovies();
        loadAllGenres();
    }

    private void loadAllMovies(){
        this.allMovies = moviesDAO.findAll();
    }

    private void loadAllGenres(){
        this.allGenres = genresDAO.findAll();
    }

    @Transactional
    public String createNewMovie() {
        List<Genre> newGenres = allGenres.stream().filter(genre -> genreIds.contains(genre.getId())).collect(Collectors.toList());
        movieToCreate.setGenres(newGenres);

        moviesDAO.persist(movieToCreate);
        return "/movies?faces-redirect=true";
    }
}
