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
//        List<MovieDb> popularMovies = movies.getPopularMovies("en", 0).getResults();
//        popularMovies.forEach(System.out::println);

        // Testing Black Panther
        MovieDb blackPanther = movies.getMovie(505642, "en", images, similar, reviews);
        String blackPantherTitle = blackPanther.getTitle();
        String blackPantherReleaseDate = blackPanther.getReleaseDate();
        
        // Retriving overview and runtime
        String blackPantherOverview = blackPanther.getOverview();
        int blackPantherRuntime = blackPanther.getRuntime();
        
        // Retrieving reviews as strings
//        List<Reviews> blackPantherReviews = blackPanther.getReviews();
//        String blackPantherReview1 = blackPanther.getReviews().get(0).getContent();
//        String blackPantherReview1 = blackPanther.getReviews().get(1).getContent();
        
        // Retrieving poster path
        String blackPantherPosterPath = blackPanther.getPosterPath();
        
        // Retrieving genres as a list of strings
        List<String> blackPantherGenresStrings = new ArrayList<>();
        List<Genre> blackPantherGenres = blackPanther.getGenres();
        for (Genre blackPantherGenre : blackPantherGenres) {
            blackPantherGenresStrings.add(blackPantherGenre.getName());
        }
        
        // Printing Black Panther movie details
        System.out.println("Title: " + blackPantherTitle);
        System.out.println("Overview: " + blackPantherOverview);
        System.out.println("Runtime: " + blackPantherRuntime);
        System.out.println("Poster: http://image.tmdb.org/t/p/w500" + blackPantherPosterPath);
        System.out.println("Release Date: " + blackPantherReleaseDate);
        System.out.println("Genres: ");
        blackPantherGenresStrings.forEach(System.out::println);        
    }
}
