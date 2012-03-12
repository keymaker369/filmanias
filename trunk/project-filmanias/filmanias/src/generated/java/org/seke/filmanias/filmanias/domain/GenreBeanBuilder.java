package org.seke.filmanias.filmanias.domain;


/**
  * Builder for GenreBean class.
  */
public class GenreBeanBuilder {
    private Genre genre;
    private boolean assigned;
    private String name;

    public GenreBeanBuilder() {
    }

    public GenreBeanBuilder(Genre genre, boolean assigned, String name) {
        this.genre = genre;

        this.assigned = assigned;

        this.name = name;

    }

    /**
     * Static factor method for GenreBeanBuilder
     */
    public static GenreBeanBuilder genreBean() {
        return new GenreBeanBuilder();
    }

    public GenreBeanBuilder genre(Genre val) {
        this.genre = val;
        return this;
    }

    public GenreBeanBuilder assigned(boolean val) {
        this.assigned = val;
        return this;
    }

    public GenreBeanBuilder name(String val) {
        this.name = val;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public String getName() {
        return name;
    }

    /**
     * @return new GenreBean instance constructed based on the values that have been set into this builder
     */
    public GenreBean build() {
        GenreBean obj = new GenreBean(getGenre(), isAssigned(), getName());

        return obj;
    }
}
