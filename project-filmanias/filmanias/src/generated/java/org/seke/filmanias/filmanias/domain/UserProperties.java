package org.seke.filmanias.filmanias.domain;

import org.fornax.cartridges.sculptor.framework.domain.LeafProperty;
import org.fornax.cartridges.sculptor.framework.domain.PropertiesCollection;
import org.fornax.cartridges.sculptor.framework.domain.Property;

import org.seke.filmanias.filmanias.domain.CommentProperties.CommentProperty;
import org.seke.filmanias.filmanias.domain.MovieProperties.MovieProperty;
import org.seke.filmanias.filmanias.domain.RatingProperties.RatingProperty;

/**
 * This generated interface defines property names for all
 * attributes and associatations in
 * {@link org.seke.filmanias.filmanias.domain.User}.
 * <p>
 * These properties are useful when building
 * criteria with {@link org.fornax.cartridges.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class UserProperties {
    private static final UserPropertiesImpl<User> sharedInstance =
        new UserPropertiesImpl<User>(User.class);

    private UserProperties() {
    }

    public static Property<User> id() {
        return sharedInstance.id();
    }

    public static Property<User> username() {
        return sharedInstance.username();
    }

    public static Property<User> password() {
        return sharedInstance.password();
    }

    public static Property<User> emailAdress() {
        return sharedInstance.emailAdress();
    }

    public static Property<User> accountNonExpired() {
        return sharedInstance.accountNonExpired();
    }

    public static Property<User> accountNonLocked() {
        return sharedInstance.accountNonLocked();
    }

    public static Property<User> credentialsNonExpired() {
        return sharedInstance.credentialsNonExpired();
    }

    public static Property<User> enabled() {
        return sharedInstance.enabled();
    }

    public static Property<User> version() {
        return sharedInstance.version();
    }

    public static Property<User> role() {
        return sharedInstance.role();
    }

    public static MovieProperty<User> movies() {
        return sharedInstance.movies();
    }

    public static CommentProperty<User> comments() {
        return sharedInstance.comments();
    }

    public static RatingProperty<User> ratings() {
        return sharedInstance.ratings();
    }

    /**
     * This class is used for references to {@link org.seke.filmanias.filmanias.domain.User},
     * i.e. nested property.
     */
    public static class UserProperty<T> extends UserPropertiesImpl<T>
        implements Property<T> {
        private static final long serialVersionUID = 1L;

        public UserProperty(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath, owningClass);
        }
    }

    protected static class UserPropertiesImpl<T> extends PropertiesCollection {
        private static final long serialVersionUID = 1L;
        Class<T> owningClass;

        UserPropertiesImpl(Class<T> owningClass) {
            super(null);
            this.owningClass = owningClass;
        }

        UserPropertiesImpl(String parentPath, String additionalPath,
            Class<T> owningClass) {
            super(parentPath, additionalPath);
            this.owningClass = owningClass;
        }

        public Property<T> id() {
            return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
        }

        public Property<T> username() {
            return new LeafProperty<T>(getParentPath(), "username", false,
                owningClass);
        }

        public Property<T> password() {
            return new LeafProperty<T>(getParentPath(), "password", false,
                owningClass);
        }

        public Property<T> emailAdress() {
            return new LeafProperty<T>(getParentPath(), "emailAdress", false,
                owningClass);
        }

        public Property<T> accountNonExpired() {
            return new LeafProperty<T>(getParentPath(), "accountNonExpired",
                false, owningClass);
        }

        public Property<T> accountNonLocked() {
            return new LeafProperty<T>(getParentPath(), "accountNonLocked",
                false, owningClass);
        }

        public Property<T> credentialsNonExpired() {
            return new LeafProperty<T>(getParentPath(),
                "credentialsNonExpired", false, owningClass);
        }

        public Property<T> enabled() {
            return new LeafProperty<T>(getParentPath(), "enabled", false,
                owningClass);
        }

        public Property<T> version() {
            return new LeafProperty<T>(getParentPath(), "version", false,
                owningClass);
        }

        public Property<T> role() {
            return new LeafProperty<T>(getParentPath(), "role", false,
                owningClass);
        }

        public MovieProperty<T> movies() {
            return new MovieProperty<T>(getParentPath(), "movies", owningClass);
        }

        public CommentProperty<T> comments() {
            return new CommentProperty<T>(getParentPath(), "comments",
                owningClass);
        }

        public RatingProperty<T> ratings() {
            return new RatingProperty<T>(getParentPath(), "ratings", owningClass);
        }
    }
}
