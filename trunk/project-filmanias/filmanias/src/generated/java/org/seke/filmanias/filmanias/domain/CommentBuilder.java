package org.seke.filmanias.filmanias.domain;

import java.util.Date;

/**
  * Builder for Comment class.
  */
public class CommentBuilder {
    private String content;
    private Date inputDate;
    private User user;
    private Movie movie;

    public CommentBuilder() {
    }

    public CommentBuilder(User user, Movie movie) {
        this.user = user;

        this.movie = movie;

    }

    /**
     * Static factor method for CommentBuilder
     */
    public static CommentBuilder comment() {
        return new CommentBuilder();
    }

    public CommentBuilder content(String val) {
        this.content = val;
        return this;
    }

    public CommentBuilder inputDate(Date val) {
        this.inputDate = val;
        return this;
    }

    public CommentBuilder user(User user) {
        this.user = user;
        return this;
    }

    public CommentBuilder movie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public String getContent() {
        return content;
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
     * @return new Comment instance constructed based on the values that have been set into this builder
     */
    public Comment build() {
        Comment obj = new Comment(getUser(), getMovie());

        obj.setContent(content);

        obj.setInputDate(inputDate);

        return obj;
    }
}
