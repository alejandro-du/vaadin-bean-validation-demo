package com.example;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Alejandro Duarte
 */
public class ConsistentDateRangeValidator implements ConstraintValidator<ConsistentDateRange, Meetup> {

    @Override
    public void initialize(ConsistentDateRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(Meetup meetup, ConstraintValidatorContext context) {
        return meetup.getStart().isBefore(meetup.getEnd());
    }
}
