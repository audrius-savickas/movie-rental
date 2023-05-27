package com.example.movierental.services;

import javax.enterprise.inject.Specializes;
import javax.faces.view.ViewScoped;

@Specializes
@ViewScoped
public class SpecializedMovieDownloadService extends MovieDownloadService {
    @Override
    public void downloadMovie(String movieId) {
        System.out.println("Movie " + movieId + " downloaded!");
    }
}
