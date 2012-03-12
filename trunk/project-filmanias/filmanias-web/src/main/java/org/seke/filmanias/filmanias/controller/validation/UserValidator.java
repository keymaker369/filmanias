package org.seke.filmanias.filmanias.controller.validation;

import org.seke.filmanias.filmanias.model.UserCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz == UserCommand.class;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "prazanSadrzaj", "username polje ne moze biti prazno");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "prazanSadrzaj", "email polje ne moze biti prazno");
	}

}
