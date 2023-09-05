package com.example.csmodule5.service;

import com.example.csmodule5.model.Type;

import java.util.List;

public interface ITypeService {
    List<Type> getAll();
    Type getById(int id);
}
