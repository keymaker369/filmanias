package org.seke.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.domain.Comment;
import org.seke.filmanias.serviceapi.MovieBeanDto;

import org.springframework.stereotype.Service;

/**
 * Implementation of MovieService.
 */
@Service("movieService")
public class MovieServiceImpl extends MovieServiceImplBase {
    public MovieServiceImpl() {
    }

    public void saveMovie(ServiceContext ctx, MovieBeanDto movieBean) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("saveMovie not implemented");

    }

    public void addMovieComment(ServiceContext ctx, long movieId,
        Comment comment, String username) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "addMovieComment not implemented");

    }
}
