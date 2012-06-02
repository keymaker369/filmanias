package org.seke.filmanias.filmanias.repositoryimplg;

import org.fornax.cartridges.sculptor.framework.accessapi.DeleteAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess2;
import org.fornax.cartridges.sculptor.framework.accessapi.FindByIdAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaDeleteAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaFindAllAccessImplGeneric;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaFindByIdAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaSaveAccessImpl;

import org.seke.filmanias.filmanias.domain.User;
import org.seke.filmanias.filmanias.domain.UserDAORepository;
import org.seke.filmanias.filmanias.exception.UserNotFoundException;

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
        return findAll(getPersistentClass());
    }

    public <R> List<R> findAll(Class<R> resultType) {
        FindAllAccess2<R> ao = createFindAllAccess(resultType);

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
        JpaSaveAccessImpl<User> ao =
            new JpaSaveAccessImpl<User>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected FindByIdAccess<User, Long> createFindByIdAccess() {
        JpaFindByIdAccessImpl<User, Long> ao =
            new JpaFindByIdAccessImpl<User, Long>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    // convenience method
    protected FindAllAccess2<User> createFindAllAccess() {
        return createFindAllAccess(getPersistentClass(), getPersistentClass());
    }

    // convenience method
    protected <R> FindAllAccess2<R> createFindAllAccess(Class<R> resultType) {
        return createFindAllAccess(getPersistentClass(), resultType);
    }

    protected <T, R> FindAllAccess2<R> createFindAllAccess(Class<T> type,
        Class<R> resultType) {
        JpaFindAllAccessImplGeneric<T, R> ao =
            new JpaFindAllAccessImplGeneric<T, R>(type, resultType);

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected DeleteAccess<User> createDeleteAccess() {
        JpaDeleteAccessImpl<User> ao =
            new JpaDeleteAccessImpl<User>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected Class<User> getPersistentClass() {
        return User.class;
    }
}
