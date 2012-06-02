package org.seke.filmanias.filmanias.repositoryimpl;

import org.seke.filmanias.filmanias.domain.Genre;
import org.seke.filmanias.filmanias.repositoryimplg.GenreDAORepositoryBase;
import org.springframework.stereotype.Repository;

/**
 * Repository implementation for GenreDAO
 */
@Repository("genreDAORepository")
public class GenreDAORepositoryImpl extends GenreDAORepositoryBase {
    
	public GenreDAORepositoryImpl() {
    }

    public Genre findGenreByName(String name) {

    	return (Genre) getEntityManager().createNamedQuery(Genre.GET_GENRE_BY_NAME).setParameter("name", name).getSingleResult();
    }
}
