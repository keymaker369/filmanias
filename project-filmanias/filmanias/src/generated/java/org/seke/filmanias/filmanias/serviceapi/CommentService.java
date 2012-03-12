package org.seke.filmanias.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.filmanias.domain.Comment;
import org.seke.filmanias.filmanias.domain.User;

/**
 * Generated interface for the Service CommentService.
 */
public interface CommentService {
    public static final String BEAN_ID = "commentService";

    public void saveComment(ServiceContext ctx, Comment comment, User user);
}
