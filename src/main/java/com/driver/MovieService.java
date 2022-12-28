package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie getMovieByName(String name) {
        Movie movie = movieRepository.getMovieByName(name);
        return movie;
    }

    public String addMovie(Movie movie){
        String result=movieRepository.addMovieToDb(movie);
        return result;
    }

    public String addDirector(Director director){
        String result = movieRepository.addDirector(director);
        return result;
    }

    public Director getDirectorByName(String name) {
        Director director = movieRepository.getDirectorByName(name);
        return director;
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        String result = movieRepository.addMovieDirectorPairInDb(movieName,directorName);
        return result;
    }

    public List<String> getMovieListByDirectorName(String director) {
          List<String> result = movieRepository.getMovieListByDirectorName(director);
          return result;
    }

    public String deleteDirectorByName(String directorName) {
        String result = movieRepository.deleteDirectorByNameFromDb(directorName);
        return result;
    }

    public List<String> findAllMovies() {
        List<String> movieList = movieRepository.findAllMoviesInDb();
        return movieList;
    }

    public String deleteAllDirectors() {
        String result = movieRepository.deleteAllDirectors();
        return result;
    }
}
