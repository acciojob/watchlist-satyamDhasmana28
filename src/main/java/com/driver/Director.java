package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Director {
//    private List<Movie> moviesList;
    private String name;
    private int numberOfMovies;
    private double imdbRating;

//    No-args constructor
    public Director() {
//        moviesList = new ArrayList<>();
    }

//    All-args Constructor
    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
//        moviesList = new ArrayList<>();
    }

//    Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
