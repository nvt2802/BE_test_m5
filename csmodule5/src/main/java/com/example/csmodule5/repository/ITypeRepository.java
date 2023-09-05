package com.example.csmodule5.repository;

import com.example.csmodule5.model.Products;
import com.example.csmodule5.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ITypeRepository extends JpaRepository<Type,Integer> {
    @Query(value = "select * from type",nativeQuery = true)
    List<Type> findAllTypes();
}
