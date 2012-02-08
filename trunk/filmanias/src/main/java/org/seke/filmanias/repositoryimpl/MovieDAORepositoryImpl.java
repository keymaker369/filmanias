package org.seke.filmanias.repositoryimpl;

import org.seke.filmanias.domain.Movie;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository implementation for MovieDAO
 */
@Repository("movieDAORepository")
public class MovieDAORepositoryImpl extends MovieDAORepositoryBase {
    public MovieDAORepositoryImpl() {
    }

    public List<Movie> retrieveMoviesStartingWith(String movieName) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "retrieveMoviesStartingWith not implemented");

    }
}
