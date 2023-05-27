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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ViewScoped
@Named
@Getter @Setter
public class MovieDetails implements Serializable {
    @Inject
    MoviesDAO moviesDAO;

    @Inject
    CustomersDAO customersDAO;

    @Inject
    GenresDAO genresDAO;

    Movie movie;

    Long movieCustomerId;

    List<Long> genreIds;

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

        try {
            moviesDAO.update(movie);
        } catch (OptimisticLockException e) {
            return "movieDetails?movieId=" + movie.getId() + "&error=optimistic-lock-exception&faces-redirect=true";
        }
        return "movieDetails?movieId=" + movie.getId() + "&faces-redirect=true";
    }
}
