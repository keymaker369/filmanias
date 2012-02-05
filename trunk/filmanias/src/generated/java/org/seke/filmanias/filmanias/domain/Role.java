package org.seke.filmanias.filmanias.domain;

import org.apache.commons.lang.Validate;

import org.fornax.cartridges.sculptor.framework.domain.AbstractDomainObject;
import org.fornax.cartridges.sculptor.framework.domain.Identifiable;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.NotNull;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
* Entity representing Role.
*/
@Entity
@Table(name = "ROLE")
@EntityListeners({org.hibernate.validator.event.JPAValidateListener.class
})
public class Role extends AbstractDomainObject implements Identifiable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false, length = 100, unique = true)
    @NotNull
    private String name;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ROLE_USER", joinColumns = @JoinColumn(name = "ROLE")
    , inverseJoinColumns = @JoinColumn(name = "USER")
    )
    @ForeignKey(name = "FK_ROLE_USER_ROLE", inverseName = "FK_ROLE_USER_USER")
    @NotNull
    private Set<User> users = new HashSet<User>();

    protected Role() {
    }

    public Role(String name) {
        super();
        Validate.notNull(name, "Role.name must not be null");
        this.name = name;
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

    public String getName() {
        return name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<User> getUsers() {
        return users;
    }

    /**
     * Adds an object to the bidirectional many-to-many
     * association in both ends.
     * It is added the collection {@link #getUsers}
     * at this side and to the collection
     * {@link org.seke.filmanias.filmanias.domain.User#getRoles}
     * at the opposite side.
     */
    public void addUser(User userElement) {
        getUsers().add(userElement);
        userElement.getRoles().add((Role) this);
    }

    /**
     * Removes an object from the bidirectional many-to-many
     * association in both ends.
     * It is removed from the collection {@link #getUsers}
     * at this side and from the collection
     * {@link org.seke.filmanias.filmanias.domain.User#getRoles}
     * at the opposite side.
     */
    public void removeUser(User userElement) {
        getUsers().remove(userElement);
        userElement.getRoles().remove((Role) this);
    }

    /**
     * Removes all object from the bidirectional
     * many-to-many association in both ends.
     * All elements are removed from the collection {@link #getUsers}
     * at this side and from the collection
     * {@link org.seke.filmanias.filmanias.domain.User#getRoles}
     * at the opposite side.
     */
    public void removeAllUsers() {
        for (User d : getUsers()) {
            d.getRoles().remove((Role) this);
        }
        getUsers().clear();

    }

    /**
     * This method is used by equals and hashCode.
     * @return {@link #getName}
     */
    public Object getKey() {
        return getName();
    }

    // This comment was generated from SpecialCases.xpt 
}
