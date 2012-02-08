package org.seke.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import static org.junit.Assert.fail;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring based transactional test with DbUnit support.
 */
public class UserServiceTest extends AbstractDbUnitJpaTests
    implements UserServiceTestBase {
    @Autowired
    protected UserService userService;

    @Test
    public void testSaveUser() throws Exception {
        // TODO Auto-generated method stub
        fail("testSaveUser not implemented");
    }

    @Test
    public void testRetrieveUser() throws Exception {
        // TODO Auto-generated method stub
        fail("testRetrieveUser not implemented");
    }

    @Test
    public void testRetrieveAllUsers() throws Exception {
        // TODO Auto-generated method stub
        fail("testRetrieveAllUsers not implemented");
    }

    @Test
    public void testUpdateUser() throws Exception {
        // TODO Auto-generated method stub
        fail("testUpdateUser not implemented");
    }

    @Test
    public void testDeleteUser() throws Exception {
        // TODO Auto-generated method stub
        fail("testDeleteUser not implemented");
    }
}
