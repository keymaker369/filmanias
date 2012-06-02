package org.seke.filmanias.filmanias.serviceimplg;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Genre;
import org.seke.filmanias.filmanias.domain.GenreDAORepository;
import org.seke.filmanias.filmanias.serviceapi.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Generated base class for implementation of GenreService.
 * <p>Make sure that subclass defines the following annotations:
 * <pre>

@org.springframework.stereotype.Service("genreService")

 * </pre>
 *
 */
public abstract class GenreServiceImplBase implements GenreService {
    @Autowired
    private GenreDAORepository genreDAORepository;

    public GenreServiceImplBase() {
    }

    protected GenreDAORepository getGenreDAORepository() {
        return genreDAORepository;
    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.GenreDAORepository#save}
     */
    @Transactional
    public Genre save(ServiceContext ctx, Genre entity) {
        return genreDAORepository.save(entity);

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.GenreDAORepository#findAll}
     */
    public List<Genre> getAllGenres(ServiceContext ctx) {
        return genreDAORepository.findAll();

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.GenreDAORepository#findGenreByName}
     */
    public Genre retrieveGenre(ServiceContext ctx, String name) {
        return genreDAORepository.findGenreByName(name);

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.GenreDAORepository#save}
     */
    @Transactional
    public Genre updateGenre(ServiceContext ctx, Genre genre) {
    	List<Genre> genres = genreDAORepository.findAll();
    	Genre genreToUpdate = null;
    	for (Genre g : genres) {
			if(g.getId().equals(genre.getId()))
				genreToUpdate = g;
				
		}
    	
    	genreToUpdate.setName(genre.getName());
    	
    	return genreDAORepository.save(genreToUpdate);

    }
}
