package br.com.agi.jucaflix;

import java.util.List;

public class MovieRecommendationService implements MovieFilter {

    public Genre userPreferences;

    private double ratingThreshold;

    public MovieRecommendationService(Genre userPreferences, double ratingThreshold) {
        this.userPreferences = userPreferences;
        this.ratingThreshold = ratingThreshold;
    }

    public List<Movie> recommendMovies(MovieRepository repository) {
        return repository.searchMovies(this);
    }

    @Override
    public boolean filter(Movie movie) {
        return movie.getGenre() == this.userPreferences && movie.getRating() >= this.ratingThreshold;
    }
}
