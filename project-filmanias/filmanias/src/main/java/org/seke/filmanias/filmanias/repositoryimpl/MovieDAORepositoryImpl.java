package org.seke.filmanias.filmanias.repositoryimpl;

import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.repositoryimplg.MovieDAORepositoryBase;

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
    	
    	return getEntityManager().createQuery("SELECT m FROM Movie m WHERE m.name LIKE '" + movieName + "%'").getResultList();

    }
}
