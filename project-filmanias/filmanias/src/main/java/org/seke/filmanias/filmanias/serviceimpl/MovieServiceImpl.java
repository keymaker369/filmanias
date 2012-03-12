package org.seke.filmanias.filmanias.serviceimpl;

import java.util.Date;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.seke.filmanias.filmanias.domain.Comment;
import org.seke.filmanias.filmanias.domain.CommentDAORepository;
import org.seke.filmanias.filmanias.domain.GenreBean;
import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.domain.MovieBean;
import org.seke.filmanias.filmanias.domain.MovieDAORepository;
import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.exception.MovieNotFoundException;
import org.seke.filmanias.filmanias.serviceapi.GenreService;
import org.seke.filmanias.filmanias.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementation of MovieService.
 */
@Service("movieService")
public class MovieServiceImpl extends MovieServiceImplBase {

	@Autowired
	@Qualifier("movieDAORepository")
	private MovieDAORepository movieDAO;

	@Autowired
	@Qualifier("genreService")
	private GenreService genreService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("commentDAORepository")
	private CommentDAORepository commentDAO;
	
	public MovieServiceImpl() {
	}

	public void saveMovie(ServiceContext ctx, MovieBean movieBean) {
		
		Movie movie = createMovieFromMovieBean(movieBean);
		movieDAO.save(movie);
		
	}

	public void addMovieComment(ServiceContext ctx, long movieId,
			Comment comment, String username) {

		User user = getUserService().retrieveUser(null, username);
		Movie movie = null;
		try {
			movie = getMovieDAO().findById(movieId);
		} catch (MovieNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comment.setMovie(movie);
		comment.setUser(user);
		getCommentDAO().save(comment);
		

	}

	private Movie createMovieFromMovieBean(MovieBean movieBean) {
		
		Movie movie = new Movie();
		movie.setName(movieBean.getName());
		movie.setInputDate(new Date(movieBean.getInputDate().getTime()));
		for (GenreBean genreBean : movieBean.getAllGenres()) {
			if (genreBean.isAssigned()) {
				movie.getGenres().add(getGenreService().retrieveGenre(null, genreBean.getName()));
			}
		}
		movie.setRank(new Double(0));
		movie.setUser(movieBean.getUser());
		return movie;
	}
	
	public MovieDAORepository getMovieDAO() {
		return movieDAO;
	}

	public void setMovieDAO(MovieDAORepository movieDAO) {
		this.movieDAO = movieDAO;
	}

	public GenreService getGenreService() {
		return genreService;
	}

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CommentDAORepository getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAORepository commentDAO) {
		this.commentDAO = commentDAO;
	}

	
}
