package org.seke.filmanias.repositoryimpl;

import org.fornax.cartridges.sculptor.framework.accessapi.DeleteAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.FindByIdAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibDeleteAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibFindAllAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibFindByIdAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibSaveAccessImpl;

import org.seke.filmanias.domain.User;
import org.seke.filmanias.domain.UserDAORepository;
import org.seke.filmanias.exception.UserNotFoundException;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Generated base class for implementation of Repository for UserDAO
 * <p>Make sure that subclass defines the following annotations:
 * <pre>
   @org.springframework.stereotype.Repository("userDAORepository")
 * </pre>
 *
 */
public abstract class UserDAORepositoryBase extends JpaDaoSupport
    implements UserDAORepository {
    private EntityManager entityManager;

    public UserDAORepositoryBase() {
    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess}
     */
    public User save(User entity) {
        SaveAccess<User> ao = createSaveAccess();

        ao.setEntity(entity);

        ao.execute();

        return ao.getResult();

    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.FindByIdAccess}
     */
    public User findById(Long id) throws UserNotFoundException {
        FindByIdAccess<User, Long> ao = createFindByIdAccess();

        ao.setId(id);

        ao.execute();

        if (ao.getResult() == null) {
            throw new UserNotFoundException("No UserDAO found with id: " + id);
        }

        return ao.getResult();

    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess}
     */
    public List<User> findAll() {
        FindAllAccess<User> ao = createFindAllAccess();

        ao.execute();

        return ao.getResult();

    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.DeleteAccess}
     */
    public void delete(User entity) {
        DeleteAccess<User> ao = createDeleteAccess();

        ao.setEntity(entity);

        ao.execute();
    }

    public abstract User getUser(String username);

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

    protected SaveAccess<User> createSaveAccess() {
        JpaHibSaveAccessImpl<User> ao =
            new JpaHibSaveAccessImpl<User>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected FindByIdAccess<User, Long> createFindByIdAccess() {
        JpaHibFindByIdAccessImpl<User, Long> ao =
            new JpaHibFindByIdAccessImpl<User, Long>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected FindAllAccess<User> createFindAllAccess() {
        JpaHibFindAllAccessImpl<User> ao =
            new JpaHibFindAllAccessImpl<User>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected DeleteAccess<User> createDeleteAccess() {
        JpaHibDeleteAccessImpl<User> ao =
            new JpaHibDeleteAccessImpl<User>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected Class<User> getPersistentClass() {
        return User.class;
    }
}
