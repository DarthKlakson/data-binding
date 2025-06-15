package pl.coderslab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.MovieDto;
import pl.coderslab.repository.MovieRepository;

@RestController
@RequestMapping("/api/movies/")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable long id) {
        return movieRepository.findById(id)
                .map(m -> {
                    MovieDto.MovieDtoBuilder builder = MovieDto.builder()
                            .id(m.getId())
                            .title(m.getTitle())
                            .releaseYear(m.getReleaseYear())
                            .rating(m.getRating());
                    m.getGenres().forEach(genre -> builder.genre(genre.getName()));
                    return builder.build();
                })
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
    }

}
