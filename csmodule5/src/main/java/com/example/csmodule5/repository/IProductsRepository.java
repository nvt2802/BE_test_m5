package com.example.csmodule5.repository;

import com.example.csmodule5.model.Products;
import com.example.csmodule5.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IProductsRepository extends JpaRepository<Products,Integer> {
    @Query(value = "select * from products where name like :searchName",nativeQuery = true)
    Page<Products> findProductsByNameContaining(Pageable pageable, @Param(value = "searchName") String searchName);
    @Query(value = "select * from products where name like :searchName and type_id = :typeId",nativeQuery = true)
    Page<Products> findProductsByNameContainingAndType(Pageable pageable, @Param(value = "searchName") String searchName, @Param(value = "typeId") int typeId);

    @Query(value = "select * from products where id = :id",nativeQuery = true)
    Products findProductsById(@Param(value = "id") int id);
@Modifying
@Transactional
    @Query(value = "insert into products (code, date_added, name, quantity, type_id ) values (:code,  :name,:date_added, :quantity, :type_id)",nativeQuery = true)
    void addProduct(@Param(value = "code") String code,@Param(value = "date_added") String dateAdded,
                        @Param(value = "name") String name,@Param(value = "quantity") int quantity,
                        @Param(value = "type_id") int type);

    @Modifying
    @Transactional
    @Query(value = "delete from products where id= :id",nativeQuery = true)
    void deleteById(int id);

}
