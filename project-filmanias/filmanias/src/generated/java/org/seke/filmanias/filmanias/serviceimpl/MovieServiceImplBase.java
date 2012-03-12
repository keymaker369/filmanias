package org.seke.filmanias.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.domain.MovieDAORepository;
import org.seke.filmanias.filmanias.exception.MovieNotFoundException;
import org.seke.filmanias.filmanias.serviceapi.MovieService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Generated base class for implementation of MovieService.
 * <p>Make sure that subclass defines the following annotations:
 * <pre>

@org.springframework.stereotype.Service("movieService")

 * </pre>
 *
 */
public abstract class MovieServiceImplBase implements MovieService {
    @Autowired
    private MovieDAORepository movieDAORepository;

    public MovieServiceImplBase() {
    }

    protected MovieDAORepository getMovieDAORepository() {
        return movieDAORepository;
    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.MovieDAORepository#save}
     */
    public Movie saveMovie(ServiceContext ctx, Movie movie) {
        return movieDAORepository.save(movie);

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.MovieDAORepository#findAll}
     */
    public List<Movie> retriveAllMovies(ServiceContext ctx) {
        return movieDAORepository.findAll();

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.MovieDAORepository#findById}
     */
    public Movie retrieveMovie(ServiceContext ctx, long id)
        throws MovieNotFoundException {
        return movieDAORepository.findById(id);

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.MovieDAORepository#retrieveMoviesStartingWith}
     */
    public List<Movie> retrieveMoviesStartingWith(ServiceContext ctx,
        String movieName) {
        return movieDAORepository.retrieveMoviesStartingWith(movieName);

    }
}
