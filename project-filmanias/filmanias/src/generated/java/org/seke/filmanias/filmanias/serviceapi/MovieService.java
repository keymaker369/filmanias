package org.seke.filmanias.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Comment;
import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.domain.MovieBean;

import java.util.List;

/**
 * Generated interface for the Service MovieService.
 */
public interface MovieService {
    public static final String BEAN_ID = "movieService";

    public void saveMovie(ServiceContext ctx, MovieBean movieBean);

    public Movie saveMovie(ServiceContext ctx, Movie movie);

    public List<Movie> retriveAllMovies(ServiceContext ctx);

    public Movie retrieveMovie(ServiceContext ctx, long id)
        throws org.seke.filmanias.filmanias.exception.MovieNotFoundException;

    public List<Movie> retrieveMoviesStartingWith(ServiceContext ctx,
        String movieName);

    public void addMovieComment(ServiceContext ctx, long movieId,
        Comment comment, String username);
}
