package com.edison.curso.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edison.curso.springboot.app.springboot_crud.models.Product;
import com.edison.curso.springboot.app.springboot_crud.repositories.ProductRepository;

@Service 
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional (readOnly = true)
     @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

     @Override
     @Transactional (readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional 
     @Override
    public Optional<Product> update(Long id, Product product) {
           Optional <Product> productOptinal = productRepository.findById(id);       

           if(productOptinal.isPresent()) {
            Product productDb = productOptinal.orElseThrow();

            productDb.setSku(product.getName());
            productDb.setName(product.getName());
            productDb.setDescription(product.getDescription());
            productDb.setPrice(product.getPrice());
            return Optional.of(productRepository.save(productDb));
        }
        return productOptinal; 
    }

    @Override
    public Optional<Product> delete (Long id) {
        Optional <Product> productOptinal = productRepository.findById(id);       

        productOptinal.ifPresent(productDb -> {
            productRepository.delete(productDb);
        });
        return productOptinal; 
    }

    @Override
    @Transactional (readOnly = true)
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);
    }

    



   

   
   


    

}
