package org.seke.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

import org.seke.filmanias.domain.MovieProperties.MovieProperty;
import org.seke.filmanias.domain.UserProperties.UserProperty;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.domain.Comment}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class CommentProperties {
    private static final CommentPropertiesImpl<Comment> sharedInstance =
        new CommentPropertiesImpl<Comment>(Comment.class);

    private CommentProperties() {
    }

    public static Property<Comment> id() {
        return sharedInstance.id();
    }

    public static Property<Comment> content() {
        return sharedInstance.content();
    }

    public static Property<Comment> inputDate() {
        return sharedInstance.inputDate();
    }

    public static Property<Comment> version() {
        return sharedInstance.version();
    }

    public static UserProperty<Comment> user() {
        return sharedInstance.user();
    }

    public static MovieProperty<Comment> movie() {
        return sharedInstance.movie();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.domain.Comment},
     * i.e. nested property.
     */
    public static class CommentProperty<T> extends CommentPropertiesImpl<T>
        implements Property<T> {
        private static final long serialVersionUID = 1L;

        public CommentProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class CommentPropertiesImpl<T> extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        CommentPropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        CommentPropertiesImpl(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath);
            this.owningClass = owningClass;
        }

        public Property<T> id() {
            return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
        }

        public Property<T> content() {
            return new LeafProperty<T>(getParentPath(), "content", false,
                owningClass);
        }

        public Property<T> inputDate() {
            return new LeafProperty<T>(getParentPath(), "inputDate", false,
                owningClass);
        }

        public Property<T> version() {
            return new LeafProperty<T>(getParentPath(), "version", false,
                owningClass);
        }

        public UserProperty<T> user() {
            return new UserProperty<T>(getParentPath(), "user", owningClass);
        }

        public MovieProperty<T> movie() {
            return new MovieProperty<T>(getParentPath(), "movie", owningClass);
        }
    }
}
