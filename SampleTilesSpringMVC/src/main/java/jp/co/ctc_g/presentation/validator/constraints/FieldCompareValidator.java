package jp.co.ctc_g.presentation.validator.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class FieldCompareValidator implements ConstraintValidator<FieldCompare, Object> {

    private String fieldFieldName;

	private String compareToFieldName;

	@Override
	public void initialize(final FieldCompare constraintAnnotation) {
		this.fieldFieldName = constraintAnnotation.field();
		this.compareToFieldName = constraintAnnotation.compareTo();
	}

	@Override
	public boolean isValid(final Object value,final ConstraintValidatorContext context) {
		
		final BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
		final Object fieldValue = wrapper.getPropertyValue(this.fieldFieldName);
		final Object compareToValue = wrapper.getPropertyValue(this.compareToFieldName);
		boolean isValid = ((fieldValue == null) && (compareToValue == null))
				|| ((fieldValue != null) && (fieldValue.equals(compareToValue)));

		if (!isValid) {
			context.buildConstraintViolationWithTemplate(
					context.getDefaultConstraintMessageTemplate())
					.addNode(this.fieldFieldName).addConstraintViolation()
					.disableDefaultConstraintViolation();
		}

		return isValid;
	}

}
