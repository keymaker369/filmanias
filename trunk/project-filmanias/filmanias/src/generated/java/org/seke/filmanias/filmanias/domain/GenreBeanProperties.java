package org.seke.filmanias.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.filmanias.domain.GenreBean}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class GenreBeanProperties {
    private static final GenreBeanPropertiesImpl<GenreBean> sharedInstance =
        new GenreBeanPropertiesImpl<GenreBean>(GenreBean.class);

    private GenreBeanProperties() {
    }

    public static Property<GenreBean> genre() {
        return sharedInstance.genre();
    }

    public static Property<GenreBean> assigned() {
        return sharedInstance.assigned();
    }

    public static Property<GenreBean> name() {
        return sharedInstance.name();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.filmanias.domain.GenreBean},
     * i.e. nested property.
     */
    public static class GenreBeanProperty<T> extends GenreBeanPropertiesImpl<T>
        implements Property<T> {
        private static final long serialVersionUID = 1L;

        public GenreBeanProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class GenreBeanPropertiesImpl<T>
        extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        GenreBeanPropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        GenreBeanPropertiesImpl(String parentPath, String additionalPath,
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
