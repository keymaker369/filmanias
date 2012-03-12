package org.seke.filmanias.filmanias.serviceimpl;

import java.util.Set;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.domain.MovieDAORepository;
import org.seke.filmanias.filmanias.domain.Rating;
import org.seke.filmanias.filmanias.domain.RatingDAORepository;
import org.seke.filmanias.filmanias.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementation of RatingService.
 */
@Service("ratingService")
public class RatingServiceImpl extends RatingServiceImplBase {

	@Autowired
	@Qualifier("ratingDAORepository")
	private RatingDAORepository ratingDAO;

	@Autowired
	@Qualifier("movieDAORepository")
	private MovieDAORepository movieDAO;

	public RatingServiceImpl() {
	}

	public void saveRating(ServiceContext ctx, Rating rating, User user) {

		Movie movie = rating.getMovie();
		int numberOfRatings = movie.getRatings().size();
		double score = calculateScore(movie.getRatings());
		movie.setRank((score + rating.getMark()) / (numberOfRatings + 1));
		movieDAO.save(movie);
		getRatingDAO().save(rating);

	}

	private double calculateScore(Set<Rating> ratings) {
		double score = 0;
		for (Rating rating : ratings) {
			score += rating.getMark();
		}
		return score;
	}

	public RatingDAORepository getRatingDAO() {
		return ratingDAO;
	}

	public void setRatingDAO(RatingDAORepository ratingDAO) {
		this.ratingDAO = ratingDAO;
	}

	public MovieDAORepository getMovieDAO() {
		return movieDAO;
	}

	public void setMovieDAO(MovieDAORepository movieDAO) {
		this.movieDAO = movieDAO;
	}

}
