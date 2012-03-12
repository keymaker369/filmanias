package org.seke.filmanias.filmanias.controller.validation;

import org.seke.filmanias.filmanias.domain.MovieBean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MovieValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz == MovieBean.class;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "prazanSadrzaj", "ime filma ne moze biti prazno");
	}

}
