package org.seke.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.AbstractDomainObject;
import org.fornax.cartridges.sculptor.framework.domain.Identifiable;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.NotNull;

import java.util.Date;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
* Entity representing Movie.
*/
@Entity
@Table(name = "MOVIE")
@EntityListeners({org.hibernate.validator.event.JPAValidateListener.class
})
public class Movie extends AbstractDomainObject implements Identifiable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 100)
    @NotNull
    private String name;
    @Column(name = "INPUTDATE", nullable = false)
    @Type(type = "date")
    @NotNull
    private Date inputDate;
    @Column(name = "RANK", nullable = false)
    @NotNull
    private Double rank;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;
    @ManyToOne()
    @JoinColumn(name = "USER")
    @ForeignKey(name = "FK_MOVIE_USER")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    @NotNull
    private Set<Comment> comments = new HashSet<Comment>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    @ForeignKey(name = "FK_MOVIE_RATING_MOVIE", inverseName = "FK_MOVIE_RATING_RATING")
    @NotNull
    private Set<Rating> ratings = new HashSet<Rating>();
    @ManyToMany(mappedBy = "movies")
    @NotNull
    private Set<Genre> genres = new HashSet<Genre>();

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    /**
     * The id is not intended to be changed or assigned manually, but
     * for test purpose it is allowed to assign the id.
     */
    protected void setId(Long id) {
        if ((this.id != null) && !this.id.equals(id)) {
            throw new IllegalArgumentException(
                "Not allowed to change the id property.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Adds an object to the bidirectional many-to-one
     * association in both ends.
     * It is added the collection {@link #getComments}
     * at this side and the association
     * {@link org.seke.filmanias.domain.Comment#setMovie}
     * at the opposite side is set.
     */
    public void addComment(Comment commentElement) {
        getComments().add(commentElement);
        commentElement.setMovie((Movie) this);
    }

    /**
     * Removes an object from the bidirectional many-to-one
     * association in both ends.
     * It is removed from the collection {@link #getComments}
     * at this side and the association
     * {@link org.seke.filmanias.domain.Comment#setMovie}
     * at the opposite side is cleared (nulled).
     */
    public void removeComment(Comment commentElement) {
        getComments().remove(commentElement);

        commentElement.setMovie(null);

    }

    /**
     * Removes all object from the bidirectional
     * many-to-one association in both ends.
     * All elements are removed from the collection {@link #getComments}
     * at this side and the association
     * {@link org.seke.filmanias.domain.Comment#setMovie}
     * at the opposite side is cleared (nulled).
     */
    public void removeAllComments() {
        for (Comment d : getComments()) {
            d.setMovie(null);
        }

        getComments().clear();

    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    /**
     * Adds an object to the bidirectional many-to-one
     * association in both ends.
     * It is added the collection {@link #getRatings}
     * at this side and the association
     * {@link org.seke.filmanias.domain.Rating#setMovie}
     * at the opposite side is set.
     */
    public void addRating(Rating ratingElement) {
        getRatings().add(ratingElement);
        ratingElement.setMovie((Movie) this);
    }

    /**
     * Removes an object from the bidirectional many-to-one
     * association in both ends.
     * It is removed from the collection {@link #getRatings}
     * at this side and the association
     * {@link org.seke.filmanias.domain.Rating#setMovie}
     * at the opposite side is cleared (nulled).
     */
    public void removeRating(Rating ratingElement) {
        getRatings().remove(ratingElement);

        ratingElement.setMovie(null);

    }

    /**
     * Removes all object from the bidirectional
     * many-to-one association in both ends.
     * All elements are removed from the collection {@link #getRatings}
     * at this side and the association
     * {@link org.seke.filmanias.domain.Rating#setMovie}
     * at the opposite side is cleared (nulled).
     */
    public void removeAllRatings() {
        for (Rating d : getRatings()) {
            d.setMovie(null);
        }

        getRatings().clear();

    }

    public Set<Genre> getGenres() {
        return genres;
    }

    /**
     * Adds an object to the bidirectional many-to-many
     * association in both ends.
     * It is added the collection {@link #getGenres}
     * at this side and to the collection
     * {@link org.seke.filmanias.domain.Genre#getMovies}
     * at the opposite side.
     */
    public void addGenre(Genre genreElement) {
        getGenres().add(genreElement);
        genreElement.getMovies().add((Movie) this);
    }

    /**
     * Removes an object from the bidirectional many-to-many
     * association in both ends.
     * It is removed from the collection {@link #getGenres}
     * at this side and from the collection
     * {@link org.seke.filmanias.domain.Genre#getMovies}
     * at the opposite side.
     */
    public void removeGenre(Genre genreElement) {
        getGenres().remove(genreElement);
        genreElement.getMovies().remove((Movie) this);
    }

    /**
     * Removes all object from the bidirectional
     * many-to-many association in both ends.
     * All elements are removed from the collection {@link #getGenres}
     * at this side and from the collection
     * {@link org.seke.filmanias.domain.Genre#getMovies}
     * at the opposite side.
     */
    public void removeAllGenres() {
        for (Genre d : getGenres()) {
            d.getMovies().remove((Movie) this);
        }
        getGenres().clear();

    }

    /**
     * This method is used by equals and hashCode.
     * @return {@link #getId}
     */
    public Object getKey() {
        return getId();
    }

    // This comment was generated from SpecialCases.xpt 
}
