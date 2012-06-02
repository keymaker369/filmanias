package org.seke.filmanias.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Genre;
import org.seke.filmanias.filmanias.domain.GenreBean;
import org.seke.filmanias.filmanias.domain.GenreDAORepository;
import org.seke.filmanias.filmanias.serviceimplg.GenreServiceImplBase;
import org.seke.filmanias.filmanias.utils.GenreUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of GenreService.
 */
@Service("genreService")
public class GenreServiceImpl extends GenreServiceImplBase {

	@Autowired
	@Qualifier("genreDAORepository")
	private GenreDAORepository genreDAO;

	public GenreServiceImpl() {
	}

	public List<GenreBean> getAllGenreBeans(ServiceContext ctx) {

		List<GenreBean> genreBeans = new ArrayList<GenreBean>();
		List<Genre> genres = genreDAO.findAll();
		for (Genre genre : genres) {
			genreBeans.add(GenreUtils.createGenreBeanFromGenre(genre));
		}
		return genreBeans;

	}

	public GenreDAORepository getGenreDAO() {
		return genreDAO;
	}

	public void setGenreDAO(GenreDAORepository genreDAO) {
		this.genreDAO = genreDAO;
	}
	
}
