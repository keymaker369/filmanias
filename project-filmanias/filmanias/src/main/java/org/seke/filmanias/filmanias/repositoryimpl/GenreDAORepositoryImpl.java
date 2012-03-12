package org.seke.filmanias.filmanias.repositoryimpl;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.seke.filmanias.filmanias.domain.Genre;

import org.springframework.stereotype.Repository;

/**
 * Repository implementation for GenreDAO
 */
@NamedQueries({ @NamedQuery(name = GenreDAORepositoryImpl.GET_GENRE_BY_NAME, 
							query = "Select g from Genre g where g.name= :name ")})

@Repository("genreDAORepository")
public class GenreDAORepositoryImpl extends GenreDAORepositoryBase {
    
	public static final String GET_GENRE_BY_NAME = "GenreDAORepositoryImpl.getGenreByName";
	
	public GenreDAORepositoryImpl() {
    }

    public Genre findGenreByName(String name) {

    	return (Genre) getEntityManager().createNamedQuery(GenreDAORepositoryImpl.GET_GENRE_BY_NAME).setParameter("name", name).getSingleResult();
    }
}
