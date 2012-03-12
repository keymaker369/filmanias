package org.seke.filmanias.filmanias.domain;

import java.util.HashSet;
import java.util.Set;

/**
  * Builder for User class.
  */
public class UserBuilder {
    private String username;
    private String password;
    private String emailAdress;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Set<Movie> movies = new HashSet<Movie>();
    private Set<Comment> comments = new HashSet<Comment>();
    private Set<Rating> ratings = new HashSet<Rating>();
    private Set<Role> roles = new HashSet<Role>();

    public UserBuilder() {
    }

    /**
     * Static factor method for UserBuilder
     */
    public static UserBuilder user() {
        return new UserBuilder();
    }

    public UserBuilder username(String val) {
        this.username = val;
        return this;
    }

    public UserBuilder password(String val) {
        this.password = val;
        return this;
    }

    public UserBuilder emailAdress(String val) {
        this.emailAdress = val;
        return this;
    }

    public UserBuilder accountNonExpired(boolean val) {
        this.accountNonExpired = val;
        return this;
    }

    public UserBuilder accountNonLocked(boolean val) {
        this.accountNonLocked = val;
        return this;
    }

    public UserBuilder credentialsNonExpired(boolean val) {
        this.credentialsNonExpired = val;
        return this;
    }

    public UserBuilder enabled(boolean val) {
        this.enabled = val;
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getMovies}.
     */
    public UserBuilder addMovy(Movie movyElement) {
        getMovies().add(movyElement);
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getComments}.
     */
    public UserBuilder addComment(Comment commentElement) {
        getComments().add(commentElement);
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getRatings}.
     */
    public UserBuilder addRating(Rating ratingElement) {
        getRatings().add(ratingElement);
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getRoles}.
     */
    public UserBuilder addRole(Role roleElement) {
        getRoles().add(roleElement);
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * @return new User instance constructed based on the values that have been set into this builder
     */
    public User build() {
        User obj = new User();

        obj.setUsername(username);

        obj.setPassword(password);

        obj.setEmailAdress(emailAdress);

        obj.setAccountNonExpired(accountNonExpired);

        obj.setAccountNonLocked(accountNonLocked);

        obj.setCredentialsNonExpired(credentialsNonExpired);

        obj.setEnabled(enabled);

        obj.getMovies().addAll(movies);

        obj.getComments().addAll(comments);

        obj.getRatings().addAll(ratings);

        obj.getRoles().addAll(roles);

        return obj;
    }
}
