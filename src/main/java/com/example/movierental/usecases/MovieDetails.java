package com.example.movierental.usecases;

import com.example.movierental.entities.Customer;
import com.example.movierental.entities.Genre;
import com.example.movierental.entities.Movie;
import com.example.movierental.persistence.CustomersDAO;
import com.example.movierental.persistence.GenresDAO;
import com.example.movierental.persistence.MoviesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Model
public class MovieDetails {
    @Inject
    MoviesDAO moviesDAO;

    @Inject
    CustomersDAO customersDAO;

    @Inject
    GenresDAO genresDAO;

    @Getter
    @Setter
    Movie movie;

    @Getter
    @Setter
    Long movieCustomerId;

    @Getter
    @Setter
    List<Long> genreIds;

    @Getter
    @Setter
    List<Genre> allGenres;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long movieId = Long.parseLong(requestParameters.get("movieId"));
        movie = moviesDAO.findOne(movieId);
        Customer movieCustomer = movie.getCustomer();
        if (movieCustomer != null) {
            movieCustomerId = movie.getCustomer().getId();
        }
        genreIds = movie.getGenres().stream().map(genre -> genre.getId()).collect(Collectors.toList());
        allGenres = genresDAO.findAll();
    }

    @Transactional
    public String updateMovie() {
        Customer customer = movieCustomerId == null ? null : customersDAO.findOne(movieCustomerId);
        movie.setCustomer(customer);

        List<Genre> newGenres = allGenres.stream().filter(genre -> genreIds.contains(genre.getId())).collect(Collectors.toList());
        movie.setGenres(newGenres);

        moviesDAO.persist(movie);
        return "movieDetails?movieId=" + movie.getId();
    }
}
