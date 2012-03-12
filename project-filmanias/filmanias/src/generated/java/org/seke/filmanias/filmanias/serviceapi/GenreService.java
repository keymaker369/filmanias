package org.seke.filmanias.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Genre;
import org.seke.filmanias.filmanias.domain.GenreBean;

import java.util.List;

/**
 * Generated interface for the Service GenreService.
 */
public interface GenreService {
    public static final String BEAN_ID = "genreService";

    public Genre save(ServiceContext ctx, Genre entity);

    public List<Genre> getAllGenres(ServiceContext ctx);

    public List<GenreBean> getAllGenreBeans(ServiceContext ctx);

    public Genre retrieveGenre(ServiceContext ctx, String name);

    public Genre updateGenre(ServiceContext ctx, Genre genre);
}
