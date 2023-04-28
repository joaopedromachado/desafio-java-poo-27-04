package br.com.agi.jucaflix;

import java.util.List;

public class MovieServices {
    MovieFilter movieFilter;
    MovieRepository repository = new MovieRepository();
    public MovieServices(MovieFilter filter){
        this.movieFilter = filter;
    }

    public List<Movie> recommendUser(){
        return repository.getAllMovies();
    }
}
