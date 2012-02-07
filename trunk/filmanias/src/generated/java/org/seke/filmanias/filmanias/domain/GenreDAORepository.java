package org.seke.filmanias.filmanias.domain;

import java.util.List;

/**
 * Generated interface for Repository for GenreDAO
 */
public interface GenreDAORepository {
    public static final String BEAN_ID = "genreDAORepository";

    public Genre findGenreByName(String name);

    public Genre save(Genre entity);

    public List<Genre> findAll();
}
