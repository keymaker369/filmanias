package org.seke.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

import org.seke.filmanias.domain.CommentProperties.CommentProperty;
import org.seke.filmanias.domain.GenreProperties.GenreProperty;
import org.seke.filmanias.domain.RatingProperties.RatingProperty;
import org.seke.filmanias.domain.UserProperties.UserProperty;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.domain.Movie}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class MovieProperties {
    private static final MoviePropertiesImpl<Movie> sharedInstance =
        new MoviePropertiesImpl<Movie>(Movie.class);

    private MovieProperties() {
    }

    public static Property<Movie> id() {
        return sharedInstance.id();
    }

    public static Property<Movie> name() {
        return sharedInstance.name();
    }

    public static Property<Movie> inputDate() {
        return sharedInstance.inputDate();
    }

    public static Property<Movie> rank() {
        return sharedInstance.rank();
    }

    public static Property<Movie> version() {
        return sharedInstance.version();
    }

    public static UserProperty<Movie> user() {
        return sharedInstance.user();
    }

    public static CommentProperty<Movie> comments() {
        return sharedInstance.comments();
    }

    public static RatingProperty<Movie> ratings() {
        return sharedInstance.ratings();
    }

    public static GenreProperty<Movie> genres() {
        return sharedInstance.genres();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.domain.Movie},
     * i.e. nested property.
     */
    public static class MovieProperty<T> extends MoviePropertiesImpl<T>
        implements Property<T> {
        private static final long serialVersionUID = 1L;

        public MovieProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class MoviePropertiesImpl<T> extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        MoviePropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        MoviePropertiesImpl(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath);
            this.owningClass = owningClass;
        }

        public Property<T> id() {
            return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
        }

        public Property<T> name() {
            return new LeafProperty<T>(getParentPath(), "name", false,
                owningClass);
        }

        public Property<T> inputDate() {
            return new LeafProperty<T>(getParentPath(), "inputDate", false,
                owningClass);
        }

        public Property<T> rank() {
            return new LeafProperty<T>(getParentPath(), "rank", false,
                owningClass);
        }

        public Property<T> version() {
            return new LeafProperty<T>(getParentPath(), "version", false,
                owningClass);
        }

        public UserProperty<T> user() {
            return new UserProperty<T>(getParentPath(), "user", owningClass);
        }

        public CommentProperty<T> comments() {
            return new CommentProperty<T>(getParentPath(), "comments",
                owningClass);
        }

        public RatingProperty<T> ratings() {
            return new RatingProperty<T>(getParentPath(), "ratings", owningClass);
        }

        public GenreProperty<T> genres() {
            return new GenreProperty<T>(getParentPath(), "genres", owningClass);
        }
    }
}
