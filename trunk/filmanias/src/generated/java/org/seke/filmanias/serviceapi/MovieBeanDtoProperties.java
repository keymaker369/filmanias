package org.seke.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.serviceapi.MovieBeanDto}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class MovieBeanDtoProperties {
    private static final MovieBeanDtoPropertiesImpl<MovieBeanDto> sharedInstance =
        new MovieBeanDtoPropertiesImpl<MovieBeanDto>(MovieBeanDto.class);

    private MovieBeanDtoProperties() {
    }

    public static Property<MovieBeanDto> name() {
        return sharedInstance.name();
    }

    public static Property<MovieBeanDto> allGenres() {
        return sharedInstance.allGenres();
    }

    public static Property<MovieBeanDto> inputDate() {
        return sharedInstance.inputDate();
    }

    public static Property<MovieBeanDto> user() {
        return sharedInstance.user();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.serviceapi.MovieBeanDto},
     * i.e. nested property.
     */
    public static class MovieBeanDtoProperty<T>
        extends MovieBeanDtoPropertiesImpl<T> implements Property<T> {
        private static final long serialVersionUID = 1L;

        public MovieBeanDtoProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class MovieBeanDtoPropertiesImpl<T>
        extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        MovieBeanDtoPropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        MovieBeanDtoPropertiesImpl(String parentPath, String additionalPath,
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
