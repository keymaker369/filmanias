package org.seke.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.serviceapi.GenreBeanDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of GenreService.
 */
@Service("genreService")
public class GenreServiceImpl extends GenreServiceImplBase {
    public GenreServiceImpl() {
    }

    public List<GenreBeanDto> getAllGenreBeans(ServiceContext ctx) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "getAllGenreBeans not implemented");

    }
}
