package com.example;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Alejandro Duarte
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConsistentDateRangeValidator.class)
public @interface ConsistentDateRange {

    String message() default "must be after end date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
