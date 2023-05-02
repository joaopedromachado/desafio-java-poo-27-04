import br.com.agi.jucaflix.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidGenreException {
        MenuInteractionService application = new MenuInteractionService();

//        MovieRepository repository = new MovieRepository();

//        repository.searchMovies(movie -> movie.getGenre() == Genre.DRAMA);

//        System.out.println(repository.searchMovies(movie -> movie.getGenre() == Genre.DRAMA));

//        MovieRecommendationService recommendationService = new MovieRecommendationService(Genre.ROMANCE, 4.0);

//        recommendationService.recommendMovies(repository);
//        System.out.println(recommendationService.recommendMovies(repository));

        application.runApplication();
    }
}
