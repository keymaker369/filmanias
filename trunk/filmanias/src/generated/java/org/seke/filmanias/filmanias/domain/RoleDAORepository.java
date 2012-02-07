package org.seke.filmanias.filmanias.domain;

import java.util.List;

/**
 * Generated interface for Repository for RoleDAO
 */
public interface RoleDAORepository {
    public static final String BEAN_ID = "roleDAORepository";

    public Role save(Role entity);

    public List<Role> findAll();
}
