package org.seke.filmanias.repositoryimpl;

import org.seke.filmanias.domain.Genre;

import org.springframework.stereotype.Repository;

/**
 * Repository implementation for GenreDAO
 */
@Repository("genreDAORepository")
public class GenreDAORepositoryImpl extends GenreDAORepositoryBase {
    public GenreDAORepositoryImpl() {
    }

    public Genre findGenreByName(String name) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "findGenreByName not implemented");

    }
}
