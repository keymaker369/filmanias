package org.seke.filmanias.filmanias.domain;

import java.io.Serializable;

/**
* Enum for Role
*/
public enum Role implements Serializable {
    MEMBER,
    ADMIN;

    /**
     */
    private Role() {
    }

    public String getName() {
        return name();
    }
}
