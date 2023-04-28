package br.com.agi.jucaflix;

import java.util.List;

public interface MovieFilter {
    List<Movie> filter(List<Movie> movies);
}
