package org.seke.filmanias.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Comment;
import org.seke.filmanias.filmanias.domain.CommentDAORepository;
import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.domain.UserDAORepository;
import org.seke.filmanias.filmanias.exception.UserNotFoundException;
import org.seke.filmanias.filmanias.serviceimplg.CommentServiceImplBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementation of CommentService.
 */
@Service("commentService")
public class CommentServiceImpl extends CommentServiceImplBase {

	@Autowired
	@Qualifier("userDAORepository")
	private UserDAORepository userDAO;

	@Autowired
	@Qualifier("commentDAORepository")
	private CommentDAORepository commentDAO;

	public CommentServiceImpl() {
	}

	public void saveComment(ServiceContext ctx, Comment comment, User user) {
		
		try {
			user = getUserDAO().findById(user.getId());
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comment.setUser(user);
		getCommentDAO().save(comment);

	}

	public UserDAORepository getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAORepository userDAO) {
		this.userDAO = userDAO;
	}

	public CommentDAORepository getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAORepository commentDAO) {
		this.commentDAO = commentDAO;
	}

}
