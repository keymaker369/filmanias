package org.seke.filmanias.serviceimpl;

import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;

import org.seke.filmanias.domain.Comment;
import org.seke.filmanias.domain.User;

import org.springframework.stereotype.Service;

/**
 * Implementation of CommentService.
 */
@Service("commentService")
public class CommentServiceImpl extends CommentServiceImplBase {
    public CommentServiceImpl() {
    }

    public void saveComment(ServiceContext ctx, Comment comment, User user) {

        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("saveComment not implemented");

    }
}
