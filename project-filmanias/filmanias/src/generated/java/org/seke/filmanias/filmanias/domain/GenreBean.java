package org.seke.filmanias.filmanias.domain;

import org.apache.commons.lang.Validate;

import org.fornax.cartridges.sculptor.framework.domain.AbstractDomainObject;
import org.fornax.cartridges.sculptor.framework.util.EqualsHelper;

import javax.validation.constraints.NotNull;

/**
* ValueObject representing GenreBean.
*/
public class GenreBean extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Genre genre;
    private boolean assigned;
    @NotNull
    private String name;

    public GenreBean() {
    }

    public GenreBean(Genre genre, boolean assigned, String name) {
        super();
        Validate.notNull(genre, "GenreBean.genre must not be null");
        this.genre = genre;
        this.assigned = assigned;
        Validate.notNull(name, "GenreBean.name must not be null");
        this.name = name;
    }

    /**
     * Creates a new GenreBean. Typically used with static import to
     * achieve fluent interface.
     */
    public static GenreBean genreBean(Genre genre, boolean assigned, String name) {
        return new GenreBean(genre, assigned, name);
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
    
    public void setGenre(Genre genre) {
		this.genre = genre;
	}
    
    public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}
    
    public void setName(String name) {
		this.name = name;
	}

    /**
     * Creates a copy of this instance, but with another genre.
     */
    public GenreBean withGenre(Genre genre) {
        if (EqualsHelper.equals(genre, getGenre())) {
            return this;
        }
        return new GenreBean(genre, isAssigned(), getName());
    }

    /**
     * Creates a copy of this instance, but with another assigned.
     */
    public GenreBean withAssigned(boolean assigned) {
        if (EqualsHelper.equals(assigned, isAssigned())) {
            return this;
        }
        return new GenreBean(getGenre(), assigned, getName());
    }

    /**
     * Creates a copy of this instance, but with another name.
     */
    public GenreBean withName(String name) {
        if (EqualsHelper.equals(name, getName())) {
            return this;
        }
        return new GenreBean(getGenre(), isAssigned(), name);
    }

    // This comment was generated from SpecialCases.xpt 
}
