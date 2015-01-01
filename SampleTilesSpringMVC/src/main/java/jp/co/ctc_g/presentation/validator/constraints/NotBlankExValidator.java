package jp.co.ctc_g.presentation.validator.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBlankExValidator implements ConstraintValidator<NotBlankEx, String>{

	public void initialize(NotBlankEx constraintAnnotation) {
		
	}

	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		
		if(object == null){
			return false;
		}
		if(object.trim().length() == 0){
			return false;
		}
		return true;
	}

}
