package org.seke.filmanias.filmanias.domain;

import java.util.HashSet;
import java.util.Set;

/**
  * Builder for Genre class.
  */
public class GenreBuilder {
    private String name;
    private Set<Movie> movies = new HashSet<Movie>();

    public GenreBuilder() {
    }

    public GenreBuilder(String name) {
        this.name = name;

    }

    /**
     * Static factor method for GenreBuilder
     */
    public static GenreBuilder genre() {
        return new GenreBuilder();
    }

    public GenreBuilder name(String val) {
        this.name = val;
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getMovies}.
     */
    public GenreBuilder addMovy(Movie movyElement) {
        getMovies().add(movyElement);
        return this;
    }

    public String getName() {
        return name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    /**
     * @return new Genre instance constructed based on the values that have been set into this builder
     */
    public Genre build() {
        Genre obj = new Genre(getName());

        obj.getMovies().addAll(movies);

        return obj;
    }
}
