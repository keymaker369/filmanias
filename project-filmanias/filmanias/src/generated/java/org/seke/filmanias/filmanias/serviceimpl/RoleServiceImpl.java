package org.seke.filmanias.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Role;
import org.seke.filmanias.filmanias.domain.RoleDAORepository;
import org.seke.filmanias.filmanias.serviceapi.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* Implementation of RoleService.
*/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAORepository roleDAORepository;

    public RoleServiceImpl() {
    }

    protected RoleDAORepository getRoleDAORepository() {
        return roleDAORepository;
    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.RoleDAORepository#findAll}
     */
    public List<Role> retrieveAll(ServiceContext ctx) {
        return roleDAORepository.findAll();

    }
}
