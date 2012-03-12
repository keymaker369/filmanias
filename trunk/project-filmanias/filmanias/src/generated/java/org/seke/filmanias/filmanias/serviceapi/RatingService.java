package org.seke.filmanias.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Rating;
import org.seke.filmanias.filmanias.domain.User;

/**
 * Generated interface for the Service RatingService.
 */
public interface RatingService {
    public static final String BEAN_ID = "ratingService";

    public void saveRating(ServiceContext ctx, Rating rating, User user);
}
