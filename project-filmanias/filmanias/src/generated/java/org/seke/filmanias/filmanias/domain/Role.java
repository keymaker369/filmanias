package org.seke.filmanias.filmanias.domain;

import java.io.Serializable;

/**
* Enum for Role
*/
public enum Role implements Serializable {
    member,
    admin;

    /**
     */
    private Role() {
    }

    public String getName() {
        return name();
    }
}
