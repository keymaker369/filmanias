package org.seke.filmanias.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.AbstractDomainObject;
import org.fornax.cartridges.sculptor.framework.domain.Identifiable;

import java.lang.reflect.Field;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import javax.validation.constraints.NotNull;

/**
* Entity representing User.
*/

@NamedQueries({ @NamedQuery(name = User.GET_USER_BY_USERNAME, 
query = "Select u " +
		"from User u " +
		"where u.username = :username")})

@Entity
@Table(name = "USER")
@EntityListeners({})
public class User extends AbstractDomainObject implements Identifiable {
    
	public static final String GET_USER_BY_USERNAME = "User.getUserByUsername";
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERNAME", nullable = false, length = 100)
    @NotNull
    private String username;
    @Column(name = "PASSWORD", nullable = false, length = 100)
    @NotNull
    private String password;
    @Column(name = "EMAILADRESS", nullable = false, length = 100)
    @NotNull
    private String emailAdress;
    @Column(name = "ACCOUNTNONEXPIRED", nullable = false)
    private boolean accountNonExpired;
    @Column(name = "ACCOUNTNONLOCKED", nullable = false)
    private boolean accountNonLocked;
    @Column(name = "CREDENTIALSNONEXPIRED", nullable = false)
    private boolean credentialsNonExpired;
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;
    @Column(name = "ROLE", length = 6)
    @Enumerated(javax.persistence.EnumType.STRING)
    private Role role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @NotNull
    private Set<Movie> movies = new HashSet<Movie>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @NotNull
    private Set<Comment> comments = new HashSet<Comment>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @NotNull
    private Set<Rating> ratings = new HashSet<Rating>();

    public User() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    /**
     * Adds an object to the bidirectional many-to-one
     * association in both ends.
     * It is added the collection {@link #getMovies}
     * at this side and the association
     * {@link org.seke.filmanias.filmanias.domain.Movie#setUser}
     * at the opposite side is set.
     */
    public void addMovy(Movie movyElement) {
        getMovies().add(movyElement);
        movyElement.setUser((User) this);
    }

    /**
     * Removes an object from the bidirectional many-to-one
     * association in both ends.
     * It is removed from the collection {@link #getMovies}
     * at this side and the association
     * {@link org.seke.filmanias.filmanias.domain.Movie#setUser}
     * at the opposite side is cleared (nulled).
     */
    public void removeMovy(Movie movyElement) {
        getMovies().remove(movyElement);

        movyElement.setUser(null);

    }

    /**
     * Removes all object from the bidirectional
     * many-to-one association in both ends.
     * All elements are removed from the collection {@link #getMovies}
     * at this side and the association
     * {@link org.seke.filmanias.filmanias.domain.Movie#setUser}
     * at the opposite side is cleared (nulled).
     */
    public void removeAllMovies() {
        for (Movie d : getMovies()) {
            d.setUser(null);
        }

        getMovies().clear();

    }

    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Adds an object to the bidirectional many-to-one
     * association in both ends.
     * It is added the collection {@link #getComments}
     * at this side and the association
     * {@link org.seke.filmanias.filmanias.domain.Comment#setUser}
     * at the opposite side is set.
     */
    public void addComment(Comment commentElement) {
        getComments().add(commentElement);
        commentElement.setUser((User) this);
    }

    /**
     * Removes an object from the bidirectional many-to-one
     * association in both ends.
     * It is removed from the collection {@link #getComments}
     * at this side and the association
     * {@link org.seke.filmanias.filmanias.domain.Comment#setUser}
     * at the opposite side is cleared (nulled).
     */
    public void removeComment(Comment commentElement) {
        getComments().remove(commentElement);

        commentElement.setUser(null);

    }

    /**
     * Removes all object from the bidirectional
     * many-to-one association in both ends.
     * All elements are removed from the collection {@link #getComments}
     * at this side and the association
     * {@link org.seke.filmanias.filmanias.domain.Comment#setUser}
     * at the opposite side is cleared (nulled).
     */
    public void removeAllComments() {
        for (Comment d : getComments()) {
            d.setUser(null);
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
     * {@link org.seke.filmanias.filmanias.domain.Rating#setUser}
     * at the opposite side is set.
     */
    public void addRating(Rating ratingElement) {
        getRatings().add(ratingElement);
        ratingElement.setUser((User) this);
    }

    /**
     * Removes an object from the bidirectional many-to-one
     * association in both ends.
     * It is removed from the collection {@link #getRatings}
     * at this side and the association
     * {@link org.seke.filmanias.filmanias.domain.Rating#setUser}
     * at the opposite side is cleared (nulled).
     */
    public void removeRating(Rating ratingElement) {
        getRatings().remove(ratingElement);

        ratingElement.setUser(null);

    }

    /**
     * Removes all object from the bidirectional
     * many-to-one association in both ends.
     * All elements are removed from the collection {@link #getRatings}
     * at this side and the association
     * {@link org.seke.filmanias.filmanias.domain.Rating#setUser}
     * at the opposite side is cleared (nulled).
     */
    public void removeAllRatings() {
        for (Rating d : getRatings()) {
            d.setUser(null);
        }

        getRatings().clear();

    }

    /**
     * This method is used by toString. It specifies what to
     * include in the toString result.
     * @return true if the field is to be included in toString
     */
    protected boolean acceptToString(Field field) {
        if (super.acceptToString(field)) {
            return true;
        } else {
            if (field.getName().equals("role")) {
                return true;
            }
            return false;
        }
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
