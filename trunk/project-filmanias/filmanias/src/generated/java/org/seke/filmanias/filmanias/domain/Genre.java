package org.seke.filmanias.filmanias.domain;

import org.apache.commons.lang.Validate;

import org.fornax.cartridges.sculptor.framework.domain.AbstractDomainObject;
import org.fornax.cartridges.sculptor.framework.domain.Identifiable;

import org.hibernate.annotations.ForeignKey;
import org.seke.filmanias.filmanias.repositoryimpl.GenreDAORepositoryImpl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import javax.validation.constraints.NotNull;

/**
* Entity representing Genre.
*/
@NamedQueries({ @NamedQuery(name = Genre.GET_GENRE_BY_NAME, 
query = "Select g from Genre g where g.name= :name ")})
@Entity
@Table(name = "GENRE")
@EntityListeners({})
public class Genre extends AbstractDomainObject implements Identifiable {
    private static final long serialVersionUID = 1L;
    
    public static final String GET_GENRE_BY_NAME = "Genre.getGenreByName";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 100, unique = true)
    private String name;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "GENRE_MOVY", joinColumns = @JoinColumn(name = "GENRE")
    , inverseJoinColumns = @JoinColumn(name = "MOVY")
    )
    @ForeignKey(name = "FK_GENRE_MOVY_GENRE", inverseName = "FK_GENRE_MOVY_MOVY")
    @NotNull
    private Set<Movie> movies = new HashSet<Movie>();

    public Genre() {
    }

    public Genre(String name) {
        super();
        Validate.notNull(name, "Genre.name must not be null");
        this.name = name;
    }

    public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}
    
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    /**
     * Adds an object to the bidirectional many-to-many
     * association in both ends.
     * It is added the collection {@link #getMovies}
     * at this side and to the collection
     * {@link org.seke.filmanias.filmanias.domain.Movie#getGenres}
     * at the opposite side.
     */
    public void addMovy(Movie movyElement) {
        getMovies().add(movyElement);
        movyElement.getGenres().add((Genre) this);
    }

    /**
     * Removes an object from the bidirectional many-to-many
     * association in both ends.
     * It is removed from the collection {@link #getMovies}
     * at this side and from the collection
     * {@link org.seke.filmanias.filmanias.domain.Movie#getGenres}
     * at the opposite side.
     */
    public void removeMovy(Movie movyElement) {
        getMovies().remove(movyElement);
        movyElement.getGenres().remove((Genre) this);
    }

    /**
     * Removes all object from the bidirectional
     * many-to-many association in both ends.
     * All elements are removed from the collection {@link #getMovies}
     * at this side and from the collection
     * {@link org.seke.filmanias.filmanias.domain.Movie#getGenres}
     * at the opposite side.
     */
    public void removeAllMovies() {
        for (Movie d : getMovies()) {
            d.getGenres().remove((Genre) this);
        }
        getMovies().clear();

    }

    /**
     * This method is used by equals and hashCode.
     * @return {@link #getName}
     */
    public Object getKey() {
        return getName();
    }

    // This comment was generated from SpecialCases.xpt 
}
