package persistence;

import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import static info.movito.themoviedbapi.TmdbMovies.MovieMethod.*;

public class MovieDB {
	public static void main(String[] args) {
		TmdbMovies movies = new TmdbApi("5068d8984fbaa6b5680cda25bd89f90c").getMovies();
		
		List<MovieDb> allMovies = new ArrayList<>();
		
		// Retrieving most popular movies (20 each)
		List<MovieDb> popularMovies1 = movies.getPopularMovies("en", 1).getResults();
		List<MovieDb> popularMovies2 = movies.getPopularMovies("en", 2).getResults();
		List<MovieDb> popularMovies3 = movies.getPopularMovies("en", 3).getResults();
		List<MovieDb> popularMovies4 = movies.getPopularMovies("en", 4).getResults();
		List<MovieDb> popularMovies5 = movies.getPopularMovies("en", 5).getResults();
		
		// Adding all movies to a single list 
		allMovies.addAll(popularMovies1);
		allMovies.addAll(popularMovies2);
		allMovies.addAll(popularMovies3);
		allMovies.addAll(popularMovies4);
		allMovies.addAll(popularMovies5);
		
		System.out.println("INSERT INTO allmovies(id,title,releaseDate,overview,posterPath,genre,runtime) VALUES");
		for (int i = 0; i < allMovies.size(); i++) {
			int id = allMovies.get(i).getId();
			MovieDb movie = movies.getMovie(id, "en", similar);
			String title = movie.getTitle();
			String releaseDate = movie.getReleaseDate();
			String overview = movie.getOverview();
			String posterPath = "http://image.tmdb.org/t/p/w500" + movie.getPosterPath();
			String genre = movie.getGenres().get(0).getName();
			int runtime = movie.getRuntime();
			System.out.println("('" + id + "','" + title + "','" + releaseDate + "','" + overview + "','" + posterPath + "','" + genre + "','" + runtime + "'),");
		}
	}
}
