package org.seke.filmanias.filmanias.controller;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.seke.filmanias.filmanias.controller.validation.MovieValidator;
import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.domain.MovieBean;
import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.exception.MovieNotFoundException;
import org.seke.filmanias.filmanias.serviceapi.GenreService;
import org.seke.filmanias.filmanias.serviceapi.MovieService;
import org.seke.filmanias.filmanias.serviceapi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Nenad Seke
 * 
 */
@Controller
public class MovieController {

	@Autowired
	private GenreService genreService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private UserService userService;

	@InitBinder(value = "newMovie")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new MovieValidator());
    }
	
	@RequestMapping(value = "/movie/add")
	public ModelAndView openAddMoviePage() {
		MovieBean movieBean = new MovieBean(null, getGenreService().getAllGenreBeans(null), null, null) ;
		return new ModelAndView("/movie/add", "newMovie", movieBean);
	}

	@RequestMapping(value = "/movie/add", params = "saveNewMovie", method = RequestMethod.POST)
	public ModelAndView saveNewMovie(@Valid @ModelAttribute("newMovie") MovieBean movieBean, BindingResult result, Principal principal) {
		if(result.hasErrors()){
			return new ModelAndView("/movie/add");
		}
		
		User tempUser = getUserService().retrieveUser(null, principal.getName());
		movieBean = movieBean.withUser(tempUser);
		movieBean = movieBean.withInputDate(new Timestamp(System.currentTimeMillis()));
		getMovieService().saveMovie(null, movieBean);
		return new ModelAndView("redirect:/movie/movies", "newMovie", movieBean);
	}

	@RequestMapping(value = "/movie/view")
	public ModelAndView viewMovie(@RequestParam(value = "id") String id) {
		Movie movie = null;
		try {
			movie = getMovieService().retrieveMovie(null, Long.parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MovieNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("/movie/view", "movie", movie);
	}

	@RequestMapping(value = "/movie/movies")
	public ModelAndView openShowAllMoviesPage() {
		List<Movie> movies = getMovieService().retriveAllMovies(null);
		return new ModelAndView("/movie/movies", "movies", movies);
	}

	@RequestMapping(value = "/movie/movies", method = RequestMethod.POST, params = "searchMovie")
	public ModelAndView searchMovies(@RequestParam("movieName") String movieName) {
		List<Movie> movies = getMovieService().retrieveMoviesStartingWith(null, movieName);
		return new ModelAndView("/movie/movies", "movies", movies);
	}

	public GenreService getGenreService() {
		return genreService;
	}

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
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

}
