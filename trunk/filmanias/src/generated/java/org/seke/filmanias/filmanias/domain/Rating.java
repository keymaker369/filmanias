package org.seke.filmanias.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.AbstractDomainObject;
import org.fornax.cartridges.sculptor.framework.domain.Identifiable;
import org.fornax.cartridges.sculptor.framework.util.EqualsHelper;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.NotNull;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
* Entity representing Rating.
*/
@Entity
@Table(name = "RATING", uniqueConstraints = @UniqueConstraint(columnNames =  {
    "ID", "USER", "MOVIE"}
)
)
@EntityListeners({org.hibernate.validator.event.JPAValidateListener.class
})
public class Rating extends AbstractDomainObject implements Identifiable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MARK", nullable = false)
    private int mark;
    @Column(name = "INPUTDATE", nullable = false)
    @Type(type = "date")
    @NotNull
    private Date inputDate;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER")
    @ForeignKey(name = "FK_RATING_USER")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "MOVIE")
    @ForeignKey(name = "FK_RATING_MOVIE")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Movie movie;
    @Transient
    private transient RatingKey cachedRatingKey;

    protected Rating() {
    }

    public Rating(User user, Movie movie) {
        super();
        this.user = user;
        this.movie = movie;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
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

    /**
     * This reference can't be changed. Use constructor to assign value.
     * However, some tools need setter methods and sometimes the
     * referred object is not available at construction time. Therefore
     * this method is visible, but the actual reference can't be changed
     * once it is assigned.
     */
    public void setUser(User user) {

        // it must be possible to set null when deleting objects
        if ((user != null) && (this.user != null) && !this.user.equals(user)) {
            throw new IllegalArgumentException(
                "Not allowed to change the user reference.");
        }
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    /**
     * This reference can't be changed. Use constructor to assign value.
     * However, some tools need setter methods and sometimes the
     * referred object is not available at construction time. Therefore
     * this method is visible, but the actual reference can't be changed
     * once it is assigned.
     */
    public void setMovie(Movie movie) {

        // it must be possible to set null when deleting objects
        if ((movie != null) && (this.movie != null) &&
              !this.movie.equals(movie)) {
            throw new IllegalArgumentException(
                "Not allowed to change the movie reference.");
        }
        this.movie = movie;
    }

    /**
     * This method is used by equals and hashCode.
     * @return {@link #getRatingKey}
     */
    public Object getKey() {
        return getRatingKey();
    }

    /**
     * The natural key for the domain object is
     * a composite key consisting of several attributes.
     */
    public RatingKey getRatingKey() {
        if (cachedRatingKey == null) {
            cachedRatingKey = new RatingKey(getId(), getUser(), getMovie());
        }
        return cachedRatingKey;
    }

    /**
     * This is the natural key for the domain object.
     * It is a composite key consisting of several
     * attributes.
     */
    public static class RatingKey {
        private Long id;
        private User user;
        private Movie movie;

        public RatingKey(Long id, User user, Movie movie) {
            this.id = id;
            this.user = user;
            this.movie = movie;

        }

        public Long getId() {
            return id;
        }

        public User getUser() {
            return user;
        }

        public Movie getMovie() {
            return movie;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RatingKey)) {
                return false;
            }

            RatingKey other = (RatingKey) obj;

            if (!EqualsHelper.equals(getId(), other.getId())) {
                return false;
            }
            if (!EqualsHelper.equals(getUser(), other.getUser())) {
                return false;
            }
            if (!EqualsHelper.equals(getMovie(), other.getMovie())) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 37 * result + EqualsHelper.computeHashCode(getId());
            result = 37 * result + EqualsHelper.computeHashCode(getUser());
            result = 37 * result + EqualsHelper.computeHashCode(getMovie());
            return result;
        }
    }

    // This comment was generated from SpecialCases.xpt 
}
