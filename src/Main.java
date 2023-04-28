import br.com.agi.jucaflix.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int opMenu;

        MovieRepository repository = new MovieRepository();
        MovieServices services = new MovieServices(new MovieRecommendationFilter(Genre.COMEDY, 9.0));
        services.recommendUser();

//        repository.removeMovie(0);
//        repository.getAllMovies();


    }
}
