package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public class MovieRepository {
    static int movieNumber=0;
    static  int directorNumber=0;
    HashMap<Integer,Movie> movieDb = new HashMap<>();
    HashMap<Integer,Director> directorDb = new HashMap<>();
    HashMap<String, List<String>> directorMovieDb = new HashMap<>();

    public String addMovieToDb(Movie movie){
        movieDb.put(MovieRepository.movieNumber++,movie);
        return "success";
    }

    public String addDirector(Director director){
        directorDb.put(MovieRepository.directorNumber++,director);
        return "success";
    }

    public Movie getMovieByName(String name) {
        for(int key : movieDb.keySet()){
            Movie movie = movieDb.get(key);
            if(Objects.equals(movie.getName(), name)){
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorByName(String name) {
     for(int key : directorDb.keySet()){
         Director director = directorDb.get(key);
         if(Objects.equals(director.getName(), name)){
             return  director;
         }
     }
     return null;
    }

    public String addMovieDirectorPairInDb(String movieName, String directorName) {
//        directorMovieDb.put(directorName,directorMovieDb.getOrDefault(directorName,new ArrayList<>()).add(movieName));
        List<String> movieList = directorMovieDb.getOrDefault(directorName,new ArrayList<>());
        movieList.add(movieName);
        directorMovieDb.put(directorName,movieList);
        return "Success";
    }

    public List<String> getMovieListByDirectorName(String director) {
        List<String> movieList = directorMovieDb.getOrDefault(director,new ArrayList<>());
        return movieList;
    }

    public String deleteDirectorByNameFromDb(String directorName) {
        directorMovieDb.remove(directorName);
        return "success";
    }

    public List<String> findAllMoviesInDb() {
        List<String> result = new ArrayList<>();
        for(int key : movieDb.keySet()){
            String movieName = movieDb.get(key).getName();
            result.add(movieName);
        }
        return result;
    }
}
