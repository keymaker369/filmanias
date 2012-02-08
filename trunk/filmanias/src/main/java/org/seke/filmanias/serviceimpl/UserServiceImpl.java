package org.seke.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.springframework.stereotype.Service;

/**
 * Implementation of UserService.
 */
@Service("userService")
public class UserServiceImpl extends UserServiceImplBase {
    public UserServiceImpl() {
    }

    public void deleteUser(ServiceContext ctx, String username) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("deleteUser not implemented");

    }
}
