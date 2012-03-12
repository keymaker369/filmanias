package org.seke.filmanias.filmanias.domain;

import java.util.HashSet;
import java.util.Set;

/**
  * Builder for Role class.
  */
public class RoleBuilder {
    private String name;
    private Set<User> users = new HashSet<User>();

    public RoleBuilder() {
    }

    public RoleBuilder(String name) {
        this.name = name;

    }

    /**
     * Static factor method for RoleBuilder
     */
    public static RoleBuilder role() {
        return new RoleBuilder();
    }

    public RoleBuilder name(String val) {
        this.name = val;
        return this;
    }

    /**
     * Adds an object to the to-many
     * association.
     * It is added the collection {@link #getUsers}.
     */
    public RoleBuilder addUser(User userElement) {
        getUsers().add(userElement);
        return this;
    }

    public String getName() {
        return name;
    }

    public Set<User> getUsers() {
        return users;
    }

    /**
     * @return new Role instance constructed based on the values that have been set into this builder
     */
    public Role build() {
        Role obj = new Role(getName());

        obj.getUsers().addAll(users);

        return obj;
    }
}
