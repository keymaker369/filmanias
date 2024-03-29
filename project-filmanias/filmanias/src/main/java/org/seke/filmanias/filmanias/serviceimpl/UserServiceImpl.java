package org.seke.filmanias.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.domain.UserDAORepository;
import org.seke.filmanias.filmanias.serviceimplg.UserServiceImplBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of UserService.
 */
@Service("userService")
public class UserServiceImpl extends UserServiceImplBase implements UserDetailsService{
    
	@Autowired
	@Qualifier("userDAORepository")
	private UserDAORepository userDAO;
	
	public UserServiceImpl() {
    }

	@Transactional
    public void deleteUser(ServiceContext ctx, String username) {

    	User user = getUserDAO().getUser(username);
    	getUserDAO().delete(user);

    }

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		return getUserDAO().getUser(username);
	}
    
	public UserDAORepository getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAORepository userDAO) {
		this.userDAO = userDAO;
	}

	
    
}
