package org.seke.filmanias.filmanias.repositoryimpl;

import org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess2;
import org.fornax.cartridges.sculptor.framework.accessapi.FindByIdAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaFindAllAccessImplGeneric;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaFindByIdAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaSaveAccessImpl;

import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.domain.MovieDAORepository;
import org.seke.filmanias.filmanias.exception.MovieNotFoundException;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Generated base class for implementation of Repository for MovieDAO
 * <p>Make sure that subclass defines the following annotations:
 * <pre>
   @org.springframework.stereotype.Repository("movieDAORepository")
 * </pre>
 *
 */
public abstract class MovieDAORepositoryBase extends JpaDaoSupport
    implements MovieDAORepository {
    private EntityManager entityManager;

    public MovieDAORepositoryBase() {
    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess}
     */
    public Movie save(Movie entity) {
        SaveAccess<Movie> ao = createSaveAccess();

        ao.setEntity(entity);

        ao.execute();

        return ao.getResult();

    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess}
     */
    public List<Movie> findAll() {
        return findAll(getPersistentClass());
    }

    public <R> List<R> findAll(Class<R> resultType) {
        FindAllAccess2<R> ao = createFindAllAccess(resultType);

        ao.execute();

        return ao.getResult();

    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.FindByIdAccess}
     */
    public Movie findById(Long id) throws MovieNotFoundException {
        FindByIdAccess<Movie, Long> ao = createFindByIdAccess();

        ao.setId(id);

        ao.execute();

        if (ao.getResult() == null) {
            throw new MovieNotFoundException("No MovieDAO found with id: " +
                id);
        }

        return ao.getResult();

    }

    public abstract List<Movie> retrieveMoviesStartingWith(String movieName);

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

    protected SaveAccess<Movie> createSaveAccess() {
        JpaSaveAccessImpl<Movie> ao =
            new JpaSaveAccessImpl<Movie>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    // convenience method
    protected FindAllAccess2<Movie> createFindAllAccess() {
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

    protected FindByIdAccess<Movie, Long> createFindByIdAccess() {
        JpaFindByIdAccessImpl<Movie, Long> ao =
            new JpaFindByIdAccessImpl<Movie, Long>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected Class<Movie> getPersistentClass() {
        return Movie.class;
    }
}
