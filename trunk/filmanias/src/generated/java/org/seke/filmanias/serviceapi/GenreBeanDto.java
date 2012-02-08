package org.seke.filmanias.serviceapi;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import org.seke.filmanias.domain.Genre;

/**
* Data transfer object for GenreBeanDto.
*/
public class GenreBeanDto implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private Genre genre;
    private boolean assigned;
    private String name;

    public GenreBeanDto() {
    }

    @XmlElement()
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @XmlElement()
    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    @XmlElement()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
