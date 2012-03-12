package org.seke.filmanias.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.domain.UserDAORepository;
import org.seke.filmanias.filmanias.exception.UserNotFoundException;
import org.seke.filmanias.filmanias.serviceapi.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Generated base class for implementation of UserService.
 * <p>Make sure that subclass defines the following annotations:
 * <pre>

@org.springframework.stereotype.Service("userService")

 * </pre>
 *
 */
public abstract class UserServiceImplBase implements UserService {
    @Autowired
    private UserDAORepository userDAORepository;

    public UserServiceImplBase() {
    }

    protected UserDAORepository getUserDAORepository() {
        return userDAORepository;
    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.UserDAORepository#save}
     */
    public User saveUser(ServiceContext ctx, User user) {
        return userDAORepository.save(user);

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.UserDAORepository#findById}
     */
    public User retrieveUser(ServiceContext ctx, Long id)
        throws UserNotFoundException {
        return userDAORepository.findById(id);

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.UserDAORepository#findAll}
     */
    public List<User> retrieveAllUsers(ServiceContext ctx) {
        return userDAORepository.findAll();

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.UserDAORepository#getUser}
     */
    public User retrieveUser(ServiceContext ctx, String username) {
        return userDAORepository.getUser(username);

    }

    /**
     * Delegates to {@link org.seke.filmanias.filmanias.domain.UserDAORepository#save}
     */
    public User updateUser(ServiceContext ctx, User user) {
        return userDAORepository.save(user);

    }
}
