package com.edison.curso.springboot.app.springboot_crud.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.edison.curso.springboot.app.springboot_crud.repositories.ProductRepository;
import com.edison.curso.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component 
public class IsExistsValidationDb implements ConstraintValidator<IsExistsDb, String>{

    private  ProductService productService;

    @Autowired 
    public IsExistsValidationDb(ProductService productService) {
        this.productService = productService;
    }
    
    public IsExistsValidationDb() {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(productService == null) {
            return true;
        }
        return !productService.existsBySku(value);
    }

}
