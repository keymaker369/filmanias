package org.seke.filmanias.filmanias.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
  * Builder for Movie class.
  */
public class MovieBuilder {
    private String name;
    private Date inputDate;
    private Double rank;
    private User user;
    private Set<Comment> comments = new HashSet<Comment>();
    private Set<Rating> ratings = new HashSet<Rating>();
    private Set<Genre> genres = new HashSet<Genre>();

    public MovieBuilder() {
    }

    /**
     * Static factor method for MovieBuilder
     */
    public static MovieBuilder movie() {
        return new MovieBuilder();
    }

    public MovieBuilder name(String val) {
        this.name = val;
        return this;
    }

    public MovieBuilder inputDate(Date val) {
        this.inputDate = val;
        return this;
    }

    public MovieBuilder rank(Double val) {
        this.rank = val;
        return this;
    }

    public MovieBuilder user(User user) {
        this.user = user;
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getComments}.
     */
    public MovieBuilder addComment(Comment commentElement) {
        getComments().add(commentElement);
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getRatings}.
     */
    public MovieBuilder addRating(Rating ratingElement) {
        getRatings().add(ratingElement);
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getGenres}.
     */
    public MovieBuilder addGenre(Genre genreElement) {
        getGenres().add(genreElement);
        return this;
    }

    public String getName() {
        return name;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public Double getRank() {
        return rank;
    }

    public User getUser() {
        return user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    /**
     * @return new Movie instance constructed based on the values that have been set into this builder
     */
    public Movie build() {
        Movie obj = new Movie();

        obj.setName(name);

        obj.setInputDate(inputDate);

        obj.setRank(rank);

        obj.setUser(user);

        obj.getComments().addAll(comments);

        obj.getRatings().addAll(ratings);

        obj.getGenres().addAll(genres);

        return obj;
    }
}
