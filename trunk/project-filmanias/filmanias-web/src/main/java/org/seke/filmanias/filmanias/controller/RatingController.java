package org.seke.filmanias.filmanias.controller;

import java.security.Principal;
import java.util.Date;

import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.domain.Rating;
import org.seke.filmanias.filmanias.domain.RatingBuilder;
import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.exception.MovieNotFoundException;
import org.seke.filmanias.filmanias.model.AddMarkCommand;
import org.seke.filmanias.filmanias.serviceapi.MovieService;
import org.seke.filmanias.filmanias.serviceapi.RatingService;
import org.seke.filmanias.filmanias.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RatingController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private UserService userService;

	@Autowired
	private RatingService ratingService;

	@RequestMapping(value = "/movie/rateMovie", method = RequestMethod.GET, params = "idMovie")
	public ModelAndView loadAddMarkPage(@RequestParam("idMovie") String idMovie) {
		
		Movie movieToRate = null;
		try {
			movieToRate = getMovieService().retrieveMovie(null, Long.parseLong(idMovie));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MovieNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/movie/rateMovie", "movie", movieToRate);
		mav.addObject("addMarkCommand", new AddMarkCommand());
		return mav;
	}

	@RequestMapping(value = "/movie/rateMovie", method = RequestMethod.POST, params = "saveMark")
	public String saveMark(@ModelAttribute("addMarkCommand") AddMarkCommand command, Principal principal) {

		Rating rating = RatingBuilder.rating().build();
		rating.setMark(command.getMark());
		rating.setInputDate(new Date(System.currentTimeMillis()));
		
		Movie commentedMovie = null;
		try {
			commentedMovie = getMovieService().retrieveMovie(null, command.getMovieId());
		} catch (MovieNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User tempUser = getUserService().retrieveUser(null, principal.getName());
		
		rating.setUser(tempUser);
		rating.setMovie(commentedMovie);
		
		getRatingService().saveRating(null, rating, null);
		return "redirect:/movie/view?id=" + command.getMovieId();
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

	public RatingService getRatingService() {
		return ratingService;
	}

	public void setRatingService(RatingService ratingService) {
		this.ratingService = ratingService;
	}

}
