package org.seke.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.domain.Genre;
import org.seke.filmanias.domain.GenreDAORepository;
import org.seke.filmanias.serviceapi.GenreService;

import org.springframework.beans.factory.annotation.Autowired;

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
     * Delegates to {@link org.seke.filmanias.domain.GenreDAORepository#save}
     */
    public Genre save(ServiceContext ctx, Genre entity) {
        return genreDAORepository.save(entity);

    }

    /**
     * Delegates to {@link org.seke.filmanias.domain.GenreDAORepository#findAll}
     */
    public List<Genre> getAllGenres(ServiceContext ctx) {
        return genreDAORepository.findAll();

    }

    /**
     * Delegates to {@link org.seke.filmanias.domain.GenreDAORepository#findGenreByName}
     */
    public Genre retrieveGenre(ServiceContext ctx, String name) {
        return genreDAORepository.findGenreByName(name);

    }

    /**
     * Delegates to {@link org.seke.filmanias.domain.GenreDAORepository#save}
     */
    public Genre updateGenre(ServiceContext ctx, Genre genre) {
        return genreDAORepository.save(genre);

    }
}
