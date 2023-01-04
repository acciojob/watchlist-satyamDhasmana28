package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie")String movieName,
                                                       @RequestParam("director")String directorName){
        String response = movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
        Movie search = movieService.getMovieByName(name);
        return new ResponseEntity<>(search,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String director){
        List<String> movieList = movieService.getMovieListByDirectorName(director);
        return new ResponseEntity<>(movieList,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movieList = movieService.findAllMovies();
        return new ResponseEntity<>(movieList,HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String directorName){
        String response = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String response = movieService.deleteAllDirectors();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/movies/get-director-by-movie/{movieName}")
    public ResponseEntity<String> getDirectorByMovie(@PathVariable("movieName") String movieName){
        String response =movieService.getDirectorByMovie(movieName);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

}
