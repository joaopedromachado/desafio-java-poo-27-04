package br.com.agi.jucaflix;

import java.util.List;
import java.util.stream.Collectors;

public class MovieRecommendationFilter implements MovieFilter {

    public Genre userPreferences;

    private double ratingThreshold;

    public MovieRecommendationFilter(Genre userPreferences, double ratingThreshold) {
        this.userPreferences = userPreferences;
        this.ratingThreshold = ratingThreshold;
    }

    @Override
    public List<Movie> filter(List<Movie> movies) {
//        return movie.getGenre() == this.userPreferences && movie.getRating() >= this.ratingThreshold;
        return movies.stream()
                .filter(movie -> movie.getGenre() == this.userPreferences)
                .map(Movie::new).toList();
    }

}
