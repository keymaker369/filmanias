package org.seke.filmanias.serviceapi;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.seke.filmanias.domain.User;

/**
* Data transfer object for MovieBeanDto.
*/
public class MovieBeanDto implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<GenreBeanDto> allGenres = new ArrayList<GenreBeanDto>();
    private Date inputDate;
    private User user;

    public MovieBeanDto() {
    }

    @XmlElement()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement()
    public List<GenreBeanDto> getAllGenres() {
        return allGenres;
    }

    public void setAllGenres(List<GenreBeanDto> allGenres) {
        this.allGenres = allGenres;
    }

    @XmlElement()
    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    @XmlElement()
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {

            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }
}
