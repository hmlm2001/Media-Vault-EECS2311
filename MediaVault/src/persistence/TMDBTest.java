package persistence;

import info.movito.themoviedbapi.*;
import info.movito.themoviedbapi.model.*;

import java.util.ArrayList;
import java.util.List;

import static info.movito.themoviedbapi.TmdbMovies.MovieMethod.*;

public class TMDBTest {
    public static void main(String[] args) {
        // URL FOR IMAGES: http://image.tmdb.org/t/p/w500/<image_url>

        TmdbMovies movies = new TmdbApi("5068d8984fbaa6b5680cda25bd89f90c").getMovies();

        // Getting a list of popular movies
        List<MovieDb> popularMovies = movies.getPopularMovies("en", 0).getResults();
//        List<MovieDb> popularMovies2 = movies.getPop;
//        popularMovies.forEach(System.out::println);

        // Testing Black Panther
        MovieDb blackPanther = movies.getMovie(505642, "en", images, similar, reviews);
        String blackPantherTitle = blackPanther.getTitle();
        String blackPantherReleaseDate = blackPanther.getReleaseDate();
        
        // Retrieving poster path as a string
        String blackPantherPosterPath = blackPanther.getImages().get(0).getFilePath();
        
        // Retrieving genres as a list of strings
        List<String> blackPantherGenresStrings = new ArrayList<>();
        List<Genre> blackPantherGenres = blackPanther.getGenres();
        for (Genre blackPantherGenre : blackPantherGenres) {
            blackPantherGenresStrings.add(blackPantherGenre.getName());
        }
        
        // Printing Black Panther movie details
        System.out.println(blackPanther.getPosterPath());
        System.out.println(blackPantherTitle);
        System.out.println("Poster: http://image.tmdb.org/t/p/w500" + blackPantherPosterPath);
        System.out.println("Release Date: " + blackPantherReleaseDate);
        System.out.println("Genres:");
        blackPantherGenresStrings.forEach(System.out::println);
        
        // Retrieving reviews as strings
        List<Reviews> blackPantherReviews = blackPanther.getReviews();
        String blackPantherReview1 = blackPanther.getReviews().get(0).getContent();
        String blackPantherReview2 = blackPanther.getReviews().get(1).getContent();
//        System.out.p/rintln(blackPantherReview1);
//        System.out.println(blackPantherReview2);
        System.out.println("");
        
        // Testing Deadpool
        MovieDb deadpool = movies.getMovie(293660, "en", images, similar, reviews);
        String deadpoolTitle = deadpool.getTitle();
        String deadpoolReleaseDate = deadpool.getReleaseDate();
        
        // Retrieving poster path as a string
        String deadpoolPosterPath = deadpool.getImages().get(0).getFilePath();
        
        // Retrieving genres as a list of strings
        List<String> deadpoolGenresStrings = new ArrayList<>();
        List<Genre> deadpoolGenres = deadpool.getGenres();
        for (Genre deadpoolGenre : deadpoolGenres) {
            deadpoolGenresStrings.add(deadpoolGenre.getName());
        }
        
        // Printing Deadpool movie details
        System.out.println(deadpoolTitle);
        System.out.println("Poster: http://image.tmdb.org/t/p/w500" + deadpoolPosterPath);
        System.out.println("Release Date: " + deadpoolReleaseDate);
        System.out.println("Genres:");
        deadpoolGenresStrings.forEach(System.out::println);
        
        // Retrieving reviews as strings
        List<Reviews> deadpoolReviews = deadpool.getReviews();
        String deadpoolReview1 = deadpool.getReviews().get(0).getContent();
        String deadpoolReview2 = deadpool.getReviews().get(1).getContent();
//        System.out.println(deadpoolReview1);
//        System.out.println(deadpoolReview2);
    }
}
