package org.seke.filmanias.exception;

import org.fornax.cartridges.sculptor.framework.errorhandling.ApplicationException;

import java.io.Serializable;

import java.util.Formatter;

public class UserNotFoundException extends ApplicationException {
    private static final long serialVersionUID = 1L;
    private static final String CLASS_NAME =
        UserNotFoundException.class.getSimpleName();
    private static final String CLASS_FULL_NAME =
        UserNotFoundException.class.getName();

    public UserNotFoundException(String m, Serializable... messageParameter) {
        super(CLASS_FULL_NAME, m);
        setMessageParameters(messageParameter);
    }

    public UserNotFoundException(int errorCode, String m,
        Serializable... messageParameter) {
        super(new Formatter().format("%1$s-%3$04d", CLASS_FULL_NAME,
                CLASS_NAME, errorCode).toString(), m);
        setMessageParameters(messageParameter);
    }
}
