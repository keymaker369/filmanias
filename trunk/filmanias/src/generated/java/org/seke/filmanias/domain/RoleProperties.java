package org.seke.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

import org.seke.filmanias.domain.UserProperties.UserProperty;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.domain.Role}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class RoleProperties {
    private static final RolePropertiesImpl<Role> sharedInstance =
        new RolePropertiesImpl<Role>(Role.class);

    private RoleProperties() {
    }

    public static Property<Role> id() {
        return sharedInstance.id();
    }

    public static Property<Role> name() {
        return sharedInstance.name();
    }

    public static Property<Role> version() {
        return sharedInstance.version();
    }

    public static UserProperty<Role> users() {
        return sharedInstance.users();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.domain.Role},
     * i.e. nested property.
     */
    public static class RoleProperty<T> extends RolePropertiesImpl<T>
        implements Property<T> {
        private static final long serialVersionUID = 1L;

        public RoleProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class RolePropertiesImpl<T> extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        RolePropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        RolePropertiesImpl(String parentPath, String additionalPath,
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

        public UserProperty<T> users() {
            return new UserProperty<T>(getParentPath(), "users", owningClass);
        }
    }
}
