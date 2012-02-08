package org.seke.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import static org.junit.Assert.fail;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring based transactional test with DbUnit support.
 */
public class RoleServiceTest extends AbstractDbUnitJpaTests
    implements RoleServiceTestBase {
    @Autowired
    protected RoleService roleService;

    @Test
    public void testRetrieveAll() throws Exception {
        // TODO Auto-generated method stub
        fail("testRetrieveAll not implemented");
    }
}
