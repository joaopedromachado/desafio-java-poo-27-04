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

    public boolean isIndexListMovieValid(int index){
        return index >= 0 && index < movies.size();
    }

    public void changeMovieRatingByIndex(int index, double rating){
        movies.get(index).addRating(rating);
    }

    public void getAllMoviesInRepository(){
        int i = 0;
        for (Movie movie : movies){
            System.out.printf("%nCódigo do filme: %d | Título: %s | Ano: %d | Gênero: %s | Diretor: %s | Classificação: %.1f%n%n", i, movie.getTitle(), movie.getYear(), movie.getGenre(), movie.getDirector(), movie.getRating());
            i++;
        }
    }

}
