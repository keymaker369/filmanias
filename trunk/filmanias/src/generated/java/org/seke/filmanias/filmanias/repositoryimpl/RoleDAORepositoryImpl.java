package org.seke.filmanias.filmanias.repositoryimpl;

import org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibFindAllAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibSaveAccessImpl;

import org.seke.filmanias.filmanias.domain.Role;
import org.seke.filmanias.filmanias.domain.RoleDAORepository;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Repository implementation for RoleDAO
 */
@Repository("roleDAORepository")
public class RoleDAORepositoryImpl extends JpaDaoSupport
    implements RoleDAORepository {
    private EntityManager entityManager;

    public RoleDAORepositoryImpl() {
    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess}
     */
    public Role save(Role entity) {
        SaveAccess<Role> ao = createSaveAccess();

        ao.setEntity(entity);

        ao.execute();

        return ao.getResult();

    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess}
     */
    public List<Role> findAll() {
        FindAllAccess<Role> ao = createFindAllAccess();

        ao.execute();

        return ao.getResult();

    }

    /**
     * Dependency injection
     */
    @PersistenceContext(unitName = "MyAppEntityManagerFactory")
    protected void setEntityManagerDependency(EntityManager entityManager) {
        this.entityManager = entityManager;
        // for JpaDaoSupport, JpaTemplate
        setEntityManager(entityManager);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected SaveAccess<Role> createSaveAccess() {
        JpaHibSaveAccessImpl<Role> ao =
            new JpaHibSaveAccessImpl<Role>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected FindAllAccess<Role> createFindAllAccess() {
        JpaHibFindAllAccessImpl<Role> ao =
            new JpaHibFindAllAccessImpl<Role>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected Class<Role> getPersistentClass() {
        return Role.class;
    }
}
