package org.seke.filmanias.repositoryimpl;

import org.fornax.cartridges.sculptor.framework.accessapi.FindAllAccess;
import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibFindAllAccessImpl;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibSaveAccessImpl;

import org.seke.filmanias.domain.Genre;
import org.seke.filmanias.domain.GenreDAORepository;

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
        FindAllAccess<Genre> ao = createFindAllAccess();

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
        JpaHibSaveAccessImpl<Genre> ao =
            new JpaHibSaveAccessImpl<Genre>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected FindAllAccess<Genre> createFindAllAccess() {
        JpaHibFindAllAccessImpl<Genre> ao =
            new JpaHibFindAllAccessImpl<Genre>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected Class<Genre> getPersistentClass() {
        return Genre.class;
    }
}
