package org.seke.filmanias.repositoryimpl;

import org.seke.filmanias.domain.User;

import org.springframework.stereotype.Repository;

/**
 * Repository implementation for UserDAO
 */
@Repository("userDAORepository")
public class UserDAORepositoryImpl extends UserDAORepositoryBase {
    public UserDAORepositoryImpl() {
    }

    public User getUser(String username) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("getUser not implemented");

    }
}
