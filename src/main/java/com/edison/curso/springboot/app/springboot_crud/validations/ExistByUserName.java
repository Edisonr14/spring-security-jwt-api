package com.edison.curso.springboot.app.springboot_crud.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint (validatedBy = ExistByUserNameValidation.class)
@Target (ElementType.FIELD)
@Retention (RetentionPolicy.RUNTIME)
public @interface  ExistByUserName {

    String message() default "ya existe en la base de datos escoja otro usernam";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};


}
