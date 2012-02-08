package org.seke.filmanias.domain;

import java.util.List;

/**
 * Generated interface for Repository for UserDAO
 */
public interface UserDAORepository {
    public static final String BEAN_ID = "userDAORepository";

    public User getUser(String username);

    public User save(User entity);

    public User findById(Long id)
        throws org.seke.filmanias.exception.UserNotFoundException;

    public List<User> findAll();

    public void delete(User entity);
}
