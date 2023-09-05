package com.example.csmodule5.service;

import com.example.csmodule5.model.Type;
import com.example.csmodule5.repository.ITypeRepository;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService{
    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public List<Type> getAll() {
        return typeRepository.findAllTypes();
    }

    @Override
    public Type getById(int id) {
        return typeRepository.findById(id).get();
    }

}
