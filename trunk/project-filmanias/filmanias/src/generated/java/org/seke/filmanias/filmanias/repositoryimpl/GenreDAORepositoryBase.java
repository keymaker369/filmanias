package org.seke.filmanias.filmanias.repositoryimplg;

import org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess2;
import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaFindAllAccessImplGeneric;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaSaveAccessImpl;

import org.seke.filmanias.filmanias.domain.Genre;
import org.seke.filmanias.filmanias.domain.GenreDAORepository;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Generated base class for implementation of Repository for GenreDAO
 * <p>Make sure that subclass defines the following annotations:
 * <pre>
   @org.springframework.stereotype.Repository("genreDAORepository")
 * </pre>
 *
 */
public abstract class GenreDAORepositoryBase extends JpaDaoSupport
    implements GenreDAORepository {
    private EntityManager entityManager;

    public GenreDAORepositoryBase() {
    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess}
     */
    public Genre save(Genre entity) {
        SaveAccess<Genre> ao = createSaveAccess();

        ao.setEntity(entity);

        ao.execute();

        return ao.getResult();

    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess}
     */
    public List<Genre> findAll() {
        return findAll(getPersistentClass());
    }

    public <R> List<R> findAll(Class<R> resultType) {
        FindAllAccess2<R> ao = createFindAllAccess(resultType);

        ao.execute();

        return ao.getResult();

    }

    public abstract Genre findGenreByName(String name);

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

    protected SaveAccess<Genre> createSaveAccess() {
        JpaSaveAccessImpl<Genre> ao =
            new JpaSaveAccessImpl<Genre>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    // convenience method
    protected FindAllAccess2<Genre> createFindAllAccess() {
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

    protected Class<Genre> getPersistentClass() {
        return Genre.class;
    }
}
