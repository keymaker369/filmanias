package org.seke.filmanias.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.filmanias.domain.MovieBean}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class MovieBeanProperties {
    private static final MovieBeanPropertiesImpl<MovieBean> sharedInstance =
        new MovieBeanPropertiesImpl<MovieBean>(MovieBean.class);

    private MovieBeanProperties() {
    }

    public static Property<MovieBean> name() {
        return sharedInstance.name();
    }

    public static Property<MovieBean> allGenres() {
        return sharedInstance.allGenres();
    }

    public static Property<MovieBean> inputDate() {
        return sharedInstance.inputDate();
    }

    public static Property<MovieBean> user() {
        return sharedInstance.user();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.filmanias.domain.MovieBean},
     * i.e. nested property.
     */
    public static class MovieBeanProperty<T> extends MovieBeanPropertiesImpl<T>
        implements Property<T> {
        private static final long serialVersionUID = 1L;

        public MovieBeanProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class MovieBeanPropertiesImpl<T>
        extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        MovieBeanPropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        MovieBeanPropertiesImpl(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath);
            this.owningClass = owningClass;
        }

        public Property<T> name() {
            return new LeafProperty<T>(getParentPath(), "name", false,
                owningClass);
        }

        public Property<T> allGenres() {
            return new LeafProperty<T>(getParentPath(), "allGenres", false,
                owningClass);
        }

        public Property<T> inputDate() {
            return new LeafProperty<T>(getParentPath(), "inputDate", false,
                owningClass);
        }

        public Property<T> user() {
            return new LeafProperty<T>(getParentPath(), "user", false,
                owningClass);
        }
    }
}
