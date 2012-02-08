package org.seke.filmanias.domain;

import java.util.List;

/**
 * Generated interface for Repository for MovieDAO
 */
public interface MovieDAORepository {
    public static final String BEAN_ID = "movieDAORepository";

    public List<Movie> retrieveMoviesStartingWith(String movieName);

    public Movie save(Movie entity);

    public List<Movie> findAll();

    public Movie findById(Long id)
        throws org.seke.filmanias.exception.MovieNotFoundException;
}
