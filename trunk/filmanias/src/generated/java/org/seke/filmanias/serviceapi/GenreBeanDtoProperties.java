package org.seke.filmanias.serviceapi;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.serviceapi.GenreBeanDto}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class GenreBeanDtoProperties {
    private static final GenreBeanDtoPropertiesImpl<GenreBeanDto> sharedInstance =
        new GenreBeanDtoPropertiesImpl<GenreBeanDto>(GenreBeanDto.class);

    private GenreBeanDtoProperties() {
    }

    public static Property<GenreBeanDto> genre() {
        return sharedInstance.genre();
    }

    public static Property<GenreBeanDto> assigned() {
        return sharedInstance.assigned();
    }

    public static Property<GenreBeanDto> name() {
        return sharedInstance.name();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.serviceapi.GenreBeanDto},
     * i.e. nested property.
     */
    public static class GenreBeanDtoProperty<T>
        extends GenreBeanDtoPropertiesImpl<T> implements Property<T> {
        private static final long serialVersionUID = 1L;

        public GenreBeanDtoProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class GenreBeanDtoPropertiesImpl<T>
        extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        GenreBeanDtoPropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        GenreBeanDtoPropertiesImpl(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath);
            this.owningClass = owningClass;
        }

        public Property<T> genre() {
            return new LeafProperty<T>(getParentPath(), "genre", false,
                owningClass);
        }

        public Property<T> assigned() {
            return new LeafProperty<T>(getParentPath(), "assigned", false,
                owningClass);
        }

        public Property<T> name() {
            return new LeafProperty<T>(getParentPath(), "name", false,
                owningClass);
        }
    }
}
