package org.seke.filmanias.filmanias.domain;

import java.util.Date;

/**
  * Builder for Rating class.
  */
public class RatingBuilder {
    private int mark;
    private Date inputDate;
    private User user;
    private Movie movie;

    public RatingBuilder() {
    }

    public RatingBuilder(User user, Movie movie) {
        this.user = user;

        this.movie = movie;

    }

    /**
     * Static factor method for RatingBuilder
     */
    public static RatingBuilder rating() {
        return new RatingBuilder();
    }

    public RatingBuilder mark(int val) {
        this.mark = val;
        return this;
    }

    public RatingBuilder inputDate(Date val) {
        this.inputDate = val;
        return this;
    }

    public RatingBuilder user(User user) {
        this.user = user;
        return this;
    }

    public RatingBuilder movie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public int getMark() {
        return mark;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    /**
     * @return new Rating instance constructed based on the values that have been set into this builder
     */
    public Rating build() {
        Rating obj = new Rating(getUser(), getMovie());

        obj.setMark(mark);

        obj.setInputDate(inputDate);

        return obj;
    }
}
