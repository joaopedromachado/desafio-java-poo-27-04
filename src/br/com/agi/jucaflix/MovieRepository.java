package br.com.agi.jucaflix;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    List<Movie> movies;

    public MovieRepository(){
        movies = new ArrayList<>();

        movies.add(new Movie("IT: A Coisa!", 2017, Genre.HORROR, "Andy Muschietti", 9.0));
        movies.add(new Movie("A Origem", 2010, Genre.ACTION, "Christopher Nolan", 5.0));
        movies.add(new Movie("Clube da Luta", 1999, Genre.DRAMA, "David Fincher", 6.0));
        movies.add(new Movie("Pulp Fiction: Tempo de Violência", 1994, Genre.DRAMA, "Quentin Tarantino", 6.0));
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void removeMovie(int index){
        movies.remove(index);
    }

    public List<Movie> searchMovies(MovieFilter filter) {
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (filter.filter(movie)){
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }

    public void getAllMovies(){
        this.movies.forEach(movie -> {
            System.out.println(movie);
        });
    }

}
