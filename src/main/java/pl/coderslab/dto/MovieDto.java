package pl.coderslab.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import pl.coderslab.domain.Genre;
import pl.coderslab.domain.Movie;

import java.util.List;
import java.util.Optional;

@Builder
@Data
public class MovieDto {

    private Long id;
    private String title;
    private int releaseYear;
    @Singular
    private List<String> genres;
    private double rating;



}
