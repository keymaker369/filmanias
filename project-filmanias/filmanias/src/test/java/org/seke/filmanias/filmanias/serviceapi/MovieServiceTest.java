package org.seke.filmanias.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import static org.junit.Assert.fail;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring based transactional test with DbUnit support.
 */
public class MovieServiceTest extends AbstractDbUnitJpaTests
    implements MovieServiceTestBase {
    @Autowired
    protected MovieService movieService;

    @Test
    public void testSaveMovie() throws Exception {
        // TODO Auto-generated method stub
        fail("testSaveMovie not implemented");
    }

    @Test
    public void testRetriveAllMovies() throws Exception {
        // TODO Auto-generated method stub
        fail("testRetriveAllMovies not implemented");
    }

    @Test
    public void testRetrieveMovie() throws Exception {
        // TODO Auto-generated method stub
        fail("testRetrieveMovie not implemented");
    }

    @Test
    public void testRetrieveMoviesStartingWith() throws Exception {
        // TODO Auto-generated method stub
        fail("testRetrieveMoviesStartingWith not implemented");
    }

    @Test
    public void testAddMovieComment() throws Exception {
        // TODO Auto-generated method stub
        fail("testAddMovieComment not implemented");
    }
}
