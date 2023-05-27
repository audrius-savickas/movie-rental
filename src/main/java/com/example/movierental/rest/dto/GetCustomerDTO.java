package com.example.movierental.rest.dto;

import com.example.movierental.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerDTO {
    private Long id;

    private String name;

    private String email;

    private List<Long> movieIds = new ArrayList<>();
}
