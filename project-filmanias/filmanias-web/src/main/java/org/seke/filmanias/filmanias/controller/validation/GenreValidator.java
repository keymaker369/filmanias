package org.seke.filmanias.filmanias.controller.validation;

import org.seke.filmanias.filmanias.domain.Genre;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GenreValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return clazz == Genre.class;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "prazanSadrzaj", "ime vrste filma ne moze biti prazno");
	}

}
