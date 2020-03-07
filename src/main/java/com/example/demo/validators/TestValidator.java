package com.example.demo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class TestValidator implements ConstraintValidator<TestValidatorAnnotationInterface, List<String>> {
    @Override
    public boolean isValid(List<String> stringList, ConstraintValidatorContext constraintValidatorContext) {
        return stringList.size() >= 3;
    }
}
