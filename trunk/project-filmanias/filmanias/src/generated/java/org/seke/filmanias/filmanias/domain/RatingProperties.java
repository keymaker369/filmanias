package org.seke.filmanias.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

import org.seke.filmanias.filmanias.domain.MovieProperties.MovieProperty;
import org.seke.filmanias.filmanias.domain.UserProperties.UserProperty;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.filmanias.domain.Rating}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class RatingProperties {
    private static final RatingPropertiesImpl<Rating> sharedInstance =
        new RatingPropertiesImpl<Rating>(Rating.class);

    private RatingProperties() {
    }

    public static Property<Rating> id() {
        return sharedInstance.id();
    }

    public static Property<Rating> mark() {
        return sharedInstance.mark();
    }

    public static Property<Rating> inputDate() {
        return sharedInstance.inputDate();
    }

    public static Property<Rating> version() {
        return sharedInstance.version();
    }

    public static UserProperty<Rating> user() {
        return sharedInstance.user();
    }

    public static MovieProperty<Rating> movie() {
        return sharedInstance.movie();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.filmanias.domain.Rating},
     * i.e. nested property.
     */
    public static class RatingProperty<T> extends RatingPropertiesImpl<T>
        implements Property<T> {
        private static final long serialVersionUID = 1L;

        public RatingProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class RatingPropertiesImpl<T> extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        RatingPropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        RatingPropertiesImpl(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath);
            this.owningClass = owningClass;
        }

        public Property<T> id() {
            return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
        }

        public Property<T> mark() {
            return new LeafProperty<T>(getParentPath(), "mark", false,
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
