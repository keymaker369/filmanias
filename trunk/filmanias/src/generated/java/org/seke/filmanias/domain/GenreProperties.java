package org.seke.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

import org.seke.filmanias.domain.MovieProperties.MovieProperty;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.domain.Genre}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class GenreProperties {
    private static final GenrePropertiesImpl<Genre> sharedInstance =
        new GenrePropertiesImpl<Genre>(Genre.class);

    private GenreProperties() {
    }

    public static Property<Genre> id() {
        return sharedInstance.id();
    }

    public static Property<Genre> name() {
        return sharedInstance.name();
    }

    public static Property<Genre> version() {
        return sharedInstance.version();
    }

    public static MovieProperty<Genre> movies() {
        return sharedInstance.movies();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.domain.Genre},
     * i.e. nested property.
     */
    public static class GenreProperty<T> extends GenrePropertiesImpl<T>
        implements Property<T> {
        private static final long serialVersionUID = 1L;

        public GenreProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class GenrePropertiesImpl<T> extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        GenrePropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        GenrePropertiesImpl(String parentPath, String additionalPath,
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

        public Property<T> version() {
            return new LeafProperty<T>(getParentPath(), "version", false,
                owningClass);
        }

        public MovieProperty<T> movies() {
            return new MovieProperty<T>(getParentPath(), "movies", owningClass);
        }
    }
}
