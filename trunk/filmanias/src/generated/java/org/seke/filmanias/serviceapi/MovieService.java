package org.seke.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.domain.Comment;
import org.seke.filmanias.domain.Movie;

import java.util.List;

/**
 * Generated interface for the Service MovieService.
 */
public interface MovieService {
    public static final String BEAN_ID = "movieService";

    public void saveMovie(ServiceContext ctx, MovieBeanDto movieBean);

    public Movie saveMovie(ServiceContext ctx, Movie movie);

    public List<Movie> retriveAllMovies(ServiceContext ctx);

    public Movie retrieveMovie(ServiceContext ctx, long id)
        throws org.seke.filmanias.exception.MovieNotFoundException;

    public List<Movie> retrieveMoviesStartingWith(ServiceContext ctx,
        String movieName);

    public void addMovieComment(ServiceContext ctx, long movieId,
        Comment comment, String username);
}
