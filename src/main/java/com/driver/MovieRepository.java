package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();
    HashMap<String, List<String>> directorMovieDb = new HashMap<>();

    public String addMovieToDb(Movie movie){
        movieDb.put(movie.getName(),movie);
        return "success";
    }

    public String addDirector(Director director){
        directorDb.put(director.getName(),director);
        return "success";
    }

    public Movie getMovieByName(String name) {
        for(String key : movieDb.keySet()){
            Movie movie = movieDb.get(key);
            if(Objects.equals(movie.getName(), name)){
                return movie;
            }
        }
        return null;
    }

    public Director getDirectorByName(String name) {
     for(String key : directorDb.keySet()){
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
        List<String> movieList = directorMovieDb.get(directorName);
        for(String movie : movieList){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
        directorMovieDb.remove(directorName);
        return "success";
    }

    public List<String> findAllMoviesInDb() {
        List<String> result = new ArrayList<>();
        for(String movieName : movieDb.keySet()){
            result.add(movieName);
        }
        return result;
    }

    public String deleteAllDirectors() {
        for(String director : directorMovieDb.keySet()){
//            getting movie list from directorMovieDb
            List<String> movieList = directorMovieDb.get(director);
            for(String movie : movieList){
                if(movieDb.containsKey(movie)){
                    movieDb.remove(movie);
                }
            }
        }
        directorMovieDb.clear();
        return "success";
    }
}
