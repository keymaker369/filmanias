package org.seke.filmanias.filmanias.repositoryimpl;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.seke.filmanias.filmanias.domain.User;

import org.springframework.stereotype.Repository;

/**
 * Repository implementation for UserDAO
 */
@NamedQueries({ @NamedQuery(name = UserDAORepositoryImpl.GET_USER_BY_USERNAME, 
							query = "Select u " +
									"from User u " +
									"where u.username= :username")})
@Repository("userDAORepository")
public class UserDAORepositoryImpl extends UserDAORepositoryBase {
    
	public static final String GET_USER_BY_USERNAME = "UserDAORepositoryImpl.getUserByUsername";
	
	public UserDAORepositoryImpl() {
    }

    public User getUser(String username) {

    	Query query = getEntityManager().createNamedQuery(UserDAORepositoryImpl.GET_USER_BY_USERNAME).setParameter("username", username);
		query.setMaxResults(1);
		List resultList = query.getResultList();
		if (resultList != null && !resultList.isEmpty()) {
			return (User) resultList.get(0);
		}
		return null;

    }
}
