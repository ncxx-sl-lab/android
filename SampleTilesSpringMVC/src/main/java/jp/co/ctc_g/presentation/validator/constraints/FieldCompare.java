package jp.co.ctc_g.presentation.validator.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FieldCompareValidator.class)
@Documented
public @interface FieldCompare {

	String message() default "{org.hibernate.validator.constraints.FieldCompare.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

    String field();

    String compareTo();

    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        FieldCompare[] value();
    }

}
