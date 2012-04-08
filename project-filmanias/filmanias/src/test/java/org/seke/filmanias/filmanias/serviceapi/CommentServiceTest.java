package org.seke.filmanias.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import static org.junit.Assert.fail;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring based transactional test with DbUnit support.
 */
public class CommentServiceTest extends AbstractDbUnitJpaTests
    implements CommentServiceTestBase {
    @Autowired
    protected CommentService commentService;

    @Test
    public void testSaveComment() throws Exception {
        // TODO Auto-generated method stub
        fail("testSaveComment not implemented");
    }
}
