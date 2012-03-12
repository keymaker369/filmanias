package org.seke.filmanias.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Role;

import java.util.List;

/**
 * Generated interface for the Service RoleService.
 */
public interface RoleService {
    public static final String BEAN_ID = "roleService";

    public List<Role> retrieveAll(ServiceContext ctx);
}
