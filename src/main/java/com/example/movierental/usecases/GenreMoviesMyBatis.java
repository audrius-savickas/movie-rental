package com.example.movierental.usecases;

import com.example.movierental.mybatis.dao.GenreMapper;
import com.example.movierental.mybatis.model.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class GenreMoviesMyBatis {
    @Inject
    GenreMapper genreMapper;

    @Getter @Setter
    Genre genre;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long genreId = Long.parseLong(requestParameters.get("genreId"));
        this.genre = genreMapper.selectByPrimaryKey(genreId);
    }
}
