package com.edison.curso.springboot.app.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.edison.curso.springboot.app.springboot_crud.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

        public boolean existsBySku(String sku);
}