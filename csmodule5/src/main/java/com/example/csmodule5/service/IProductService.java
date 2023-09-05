package com.example.csmodule5.service;

import com.example.csmodule5.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Products> getAll(Pageable pageable, String nameLike, int type_id);

    Products getById(int id);

    void add(Products product);

    void deleteProduct(int id);
}
