package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(value = FIELD)
@Constraint(validatedBy = TestValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestValidatorAnnotationInterface {
    String message() default "Invalid list is not allowed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
