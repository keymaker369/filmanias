package org.seke.filmanias.filmanias.repositoryimpl;

import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpa2.JpaSaveAccessImpl;

import org.seke.filmanias.filmanias.domain.Rating;
import org.seke.filmanias.filmanias.domain.RatingDAORepository;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Repository implementation for RatingDAO
 */
@Repository("ratingDAORepository")
public class RatingDAORepositoryImpl extends JpaDaoSupport
    implements RatingDAORepository {
    private EntityManager entityManager;

    public RatingDAORepositoryImpl() {
    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess}
     */
    public Rating save(Rating entity) {
        SaveAccess<Rating> ao = createSaveAccess();

        ao.setEntity(entity);

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

    protected SaveAccess<Rating> createSaveAccess() {
        JpaSaveAccessImpl<Rating> ao =
            new JpaSaveAccessImpl<Rating>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected Class<Rating> getPersistentClass() {
        return Rating.class;
    }
}
