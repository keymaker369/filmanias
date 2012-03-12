package org.seke.filmanias.filmanias.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.seke.filmanias.filmanias.controller.validation.CommentValidator;
import org.seke.filmanias.filmanias.domain.Comment;
import org.seke.filmanias.filmanias.domain.CommentBuilder;
import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.exception.MovieNotFoundException;
import org.seke.filmanias.filmanias.model.AddCommentCommand;
import org.seke.filmanias.filmanias.serviceapi.CommentService;
import org.seke.filmanias.filmanias.serviceapi.MovieService;
import org.seke.filmanias.filmanias.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommentService commentService;

	@InitBinder(value = "addCommentCommand")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new CommentValidator());
	}

	@RequestMapping(value = "/movie/addComment", method = RequestMethod.GET, params = "idMovie")
	public ModelAndView loadAddCommentPage(@RequestParam("idMovie") String idMovie) {
		Movie movieToComment = null;
		try {
			movieToComment = getMovieService().retrieveMovie(null, Long.parseLong(idMovie));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MovieNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/movie/addComment", "movie", movieToComment);
		mav.addObject("addCommentCommand", new AddCommentCommand());
		return mav;
	}

	@RequestMapping(value = "/movie/addComment", method = RequestMethod.POST, params = "sacuvajCommentar")
	public String addCommentPage(@Valid AddCommentCommand addCommentCommand, BindingResult result, Principal principal) {
		if (result.hasErrors()) {
			return "/movie/addComment";
		}

		Comment comment = CommentBuilder.comment().build();
		comment.setContent(addCommentCommand.getComment());
		comment.setInputDate(new Date(System.currentTimeMillis()));

		getMovieService().addMovieComment(null, addCommentCommand.getMovieId(), comment, principal.getName());
		return "redirect:/movie/view?id=" + addCommentCommand.getMovieId();
	}

	public MovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

}
