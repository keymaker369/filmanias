package org.seke.filmanias.filmanias.exception;

import org.fornax.cartridges.sculptor.framework.errorhandling.ApplicationException;

import java.io.Serializable;

import java.util.Formatter;

public class MovieNotFoundException extends ApplicationException {
    private static final long serialVersionUID = 1L;
    private static final String CLASS_NAME =
        MovieNotFoundException.class.getSimpleName();
    private static final String CLASS_FULL_NAME =
        MovieNotFoundException.class.getName();

    public MovieNotFoundException(String m, Serializable... messageParameter) {
        super(CLASS_FULL_NAME, m);
        setMessageParameters(messageParameter);
    }

    public MovieNotFoundException(int errorCode, String m,
        Serializable... messageParameter) {
        super(new Formatter().format("%1$s-%3$04d", CLASS_FULL_NAME,
                CLASS_NAME, errorCode).toString(), m);
        setMessageParameters(messageParameter);
    }
}
