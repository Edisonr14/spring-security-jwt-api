package com.edison.curso.springboot.app.springboot_crud.validations;

//import com.edison.curso.springboot.app.springboot_crud.repositories.ProductRepository;
import com.edison.curso.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsExistsValidationDb implements ConstraintValidator<IsExistsDb, String>{

    private final ProductService productService;
    public IsExistsValidationDb(ProductService productService) {
        this.productService = productService;
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !productService.existsBySku(value);
    }

}
