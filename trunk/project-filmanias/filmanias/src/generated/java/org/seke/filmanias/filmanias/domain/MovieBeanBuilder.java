package org.seke.filmanias.filmanias.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
  * Builder for MovieBean class.
  */
public class MovieBeanBuilder {
    private String name;
    private List<GenreBean> allGenres = new ArrayList<GenreBean>();
    private Date inputDate;
    private User user;

    public MovieBeanBuilder() {
    }

    public MovieBeanBuilder(String name, List<GenreBean> allGenres,
        Date inputDate, User user) {
        this.name = name;

        this.allGenres = allGenres;

        this.inputDate = inputDate;

        this.user = user;

    }

    /**
     * Static factor method for MovieBeanBuilder
     */
    public static MovieBeanBuilder movieBean() {
        return new MovieBeanBuilder();
    }

    public MovieBeanBuilder name(String val) {
        this.name = val;
        return this;
    }

    public MovieBeanBuilder allGenres(ArrayList<GenreBean> val) {
        this.allGenres = val;
        return this;
    }

    public MovieBeanBuilder inputDate(Date val) {
        this.inputDate = val;
        return this;
    }

    public MovieBeanBuilder user(User val) {
        this.user = val;
        return this;
    }

    public String getName() {
        return name;
    }

    public List<GenreBean> getAllGenres() {
        return allGenres;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public User getUser() {
        return user;
    }

    /**
     * @return new MovieBean instance constructed based on the values that have been set into this builder
     */
    public MovieBean build() {
        MovieBean obj =
            new MovieBean(getName(), getAllGenres(), getInputDate(), getUser());

        return obj;
    }
}
