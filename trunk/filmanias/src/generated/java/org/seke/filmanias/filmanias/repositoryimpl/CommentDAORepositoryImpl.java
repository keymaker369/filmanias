package org.seke.filmanias.filmanias.repositoryimpl;

import org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess;
import org.fornax.cartridges.sculptor.framework.accessimpl.jpahibernate.JpaHibSaveAccessImpl;

import org.seke.filmanias.filmanias.domain.Comment;
import org.seke.filmanias.filmanias.domain.CommentDAORepository;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Repository implementation for CommentDAO
 */
@Repository("commentDAORepository")
public class CommentDAORepositoryImpl extends JpaDaoSupport
    implements CommentDAORepository {
    private EntityManager entityManager;

    public CommentDAORepositoryImpl() {
    }

    /**
     * Delegates to {@link org.fornax.cartridges.sculptor.framework.accessapi.SaveAccess}
     */
    public Comment save(Comment entity) {
        SaveAccess<Comment> ao = createSaveAccess();

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

    protected SaveAccess<Comment> createSaveAccess() {
        JpaHibSaveAccessImpl<Comment> ao =
            new JpaHibSaveAccessImpl<Comment>(getPersistentClass());

        ao.setEntityManager(getEntityManager());

        return ao;
    }

    protected Class<Comment> getPersistentClass() {
        return Comment.class;
    }
}
