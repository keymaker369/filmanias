package org.seke.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.domain.User;

import java.util.List;

/**
 * Generated interface for the Service UserService.
 */
public interface UserService {
    public static final String BEAN_ID = "userService";

    public User saveUser(ServiceContext ctx, User user);

    public User retrieveUser(ServiceContext ctx, Long id)
        throws org.seke.filmanias.exception.UserNotFoundException;

    public List<User> retrieveAllUsers(ServiceContext ctx);

    public User retrieveUser(ServiceContext ctx, String username);

    public User updateUser(ServiceContext ctx, User user);

    public void deleteUser(ServiceContext ctx, String username);
}
