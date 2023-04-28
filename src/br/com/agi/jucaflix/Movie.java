package br.com.agi.jucaflix;

public class Movie {
    private String title;
    private int year;
    private Genre genre;
    private String director;
    private double rating;

    public Movie(String title, int year, Genre genre, String director, double rating){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void addRating(double rating){
        this.rating = rating;
    }

    // title, year, genre, director
    @Override
    public String toString() {
        return String.format("Titulo do filme: %s%nAno de lançamento: %d%nGênero: %s%nDiretor do filme: %s%n", this.title, this.year, this.genre, this.director);
    }

}
