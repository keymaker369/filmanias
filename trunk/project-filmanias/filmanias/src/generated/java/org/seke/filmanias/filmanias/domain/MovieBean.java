package org.seke.filmanias.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.AbstractDomainObject;
import org.fornax.cartridges.sculptor.framework.util.EqualsHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* ValueObject representing MovieBean.
*/
public class MovieBean extends AbstractDomainObject {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<GenreBean> allGenres = new ArrayList<GenreBean>();
    private Date inputDate;
    private User user;

    public MovieBean() {
    }

    public MovieBean(String name, List<GenreBean> allGenres, Date inputDate,
        User user) {
        super();
        this.name = name;
        this.allGenres = allGenres;
        this.inputDate = inputDate;
        this.user = user;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
		this.name = name;
	}

    public List<GenreBean> getAllGenres() {
        return allGenres;
    }
    
    public void setAllGenres(List<GenreBean> allGenres) {
		this.allGenres = allGenres;
	}
    
    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
		this.user = user;
	}
    
    /**
     * Creates a copy of this instance, but with another name.
     */
    public MovieBean withName(String name) {
        if (EqualsHelper.equals(name, getName())) {
            return this;
        }
        return new MovieBean(name, getAllGenres(), getInputDate(), getUser());
    }

    /**
     * Creates a copy of this instance, but with another allGenres.
     */
    public MovieBean withAllGenres(List<GenreBean> allGenres) {
        if (EqualsHelper.equals(allGenres, getAllGenres())) {
            return this;
        }
        return new MovieBean(getName(), allGenres, getInputDate(), getUser());
    }

    /**
     * Creates a copy of this instance, but with another inputDate.
     */
    public MovieBean withInputDate(Date inputDate) {
        if (EqualsHelper.equals(inputDate, getInputDate())) {
            return this;
        }
        return new MovieBean(getName(), getAllGenres(), inputDate, getUser());
    }

    /**
     * Creates a copy of this instance, but with another user.
     */
    public MovieBean withUser(User user) {
        if (EqualsHelper.equals(user, getUser())) {
            return this;
        }
        return new MovieBean(getName(), getAllGenres(), getInputDate(), user);
    }

    // This comment was generated from SpecialCases.xpt 
}
