package com.example.csmodule5.service;

import com.example.csmodule5.model.Products;
import com.example.csmodule5.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductsService implements IProductService{
    @Autowired
    private IProductsRepository productsRepository;
    @Autowired
    private ITypeService typeService;
    @Override
    public Page<Products> getAll(Pageable pageable, String nameLike, int type_id) {
        nameLike = "%"+nameLike+"%";
        if(type_id==0){
            return  productsRepository.findProductsByNameContaining(pageable,nameLike);
        }else {
            return productsRepository.findProductsByNameContainingAndType(pageable, nameLike, type_id);
        }
    }

    @Override
    public Products getById(int id) {
        return productsRepository.findProductsById(id);
    }

    @Override
    public void add(Products product) {
        System.out.println(product.getDateAdded());
        productsRepository.addProduct(product.getCode(),product.getName(),product.getDateAdded(),product.getQuantity(),product.getType().getId());
//        productsRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productsRepository.deleteById(id);
    }


}
