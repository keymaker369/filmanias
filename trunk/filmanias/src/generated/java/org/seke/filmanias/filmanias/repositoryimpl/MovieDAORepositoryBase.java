package org.seke.filmanias.filmanias.repositoryimpl;

import org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibFindAllAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibSaveAccessImpl;

import org.seke.filmanias.filmanias.domain.Movie;
import org.seke.filmanias.filmanias.domain.MovieDAORepository;

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
        FindAllAccess<Movie> ao = createFindAllAccess();

        ao.execute();

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
        JpaHibSaveAccessImpl<Movie> ao =
            new JpaHibSaveAccessImpl<Movie>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected FindAllAccess<Movie> createFindAllAccess() {
        JpaHibFindAllAccessImpl<Movie> ao =
            new JpaHibFindAllAccessImpl<Movie>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected Class<Movie> getPersistentClass() {
        return Movie.class;
    }
}
