package com.example.demo_validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MyValidConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
// à quel moment? -> runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface MyValid {
    public String value() default "to";
    public String  message() default "must be contained 'to' !!!!";
    public Class<?>[] groups() default {};
    // provoquer par java
    public Class<? extends Payload> [] payload() default {};

}
