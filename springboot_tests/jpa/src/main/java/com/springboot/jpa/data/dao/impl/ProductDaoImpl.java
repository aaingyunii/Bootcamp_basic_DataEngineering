package com.springboot.jpa.data.dao.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.jpa.data.dao.ProductDao;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.data.repository.ProductRepository;

// ProductDAOImpl 클래스를 스프링이 관리하는 빈 으로 등록
// 빈 으로 등록된 객체는 다른 클래스가 인터페이스를 가지고 의존성 주입을 받을 때, 이 구현체를 찾아 주입.
@Component
public class ProductDaoImpl implements ProductDao{
    
    private ProductRepository productRepository;

    @Autowired
    public ProductDaoImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product){
        Product savedProduct = productRepository.save(product);
        
        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number){
       Product selectedProduct = productRepository.getById(number);
       // getById() -> EntityManager의 getReference()  메서드 호출
       // findByID() -> EntityManager의 find() 메서드를 호출 -> 리턴 값으로 Optional 객체로 전달 

       return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);
        Product updatedProduct;


        if (selectedProduct.isPresent()){
             Product product = selectedProduct.get();


            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());


            updatedProduct = productRepository.save(product);
        }else{
            throw new Exception();
        }


        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);


        if (selectedProduct.isPresent()){
             Product product = selectedProduct.get();
             productRepository.delete(product);
        }else{
            throw new Exception();
        }
    }

}   
