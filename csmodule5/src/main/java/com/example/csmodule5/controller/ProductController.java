package com.example.csmodule5.controller;

import com.example.csmodule5.model.Products;
import com.example.csmodule5.model.Type;
import com.example.csmodule5.service.IProductService;
import com.example.csmodule5.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ITypeService typeService;

    @GetMapping("/products")
    public ResponseEntity<Page<Products>> getAllProducts(
            @RequestParam(defaultValue = "") String name_like,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int type_id
    ){
        Pageable pageable = PageRequest.of(page,2, Sort.by("quantity").descending());
        Page<Products> productsPage;

            productsPage = productService.getAll(pageable, name_like,type_id);

        System.out.println(productsPage);
        return new ResponseEntity<>(productsPage,HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProduct(@PathVariable int id){
        Products product = productService.getById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping("/products")
    public  ResponseEntity<Products> addProducts(@RequestBody Products product){
        System.out.println(product.getType().getId());
        productService.add(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/products/{id}")
    public  ResponseEntity<Products> updateProducts(@RequestBody Products product,
                                                    @PathVariable int id){
        productService.add(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public  ResponseEntity<Products> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/types")
    public ResponseEntity<List<Type>> getAllType(){
        List<Type> typeList = typeService.getAll();
        return new ResponseEntity<>(typeList,HttpStatus.OK);
    }
    @GetMapping("/types/{id}")
    public ResponseEntity<Type> getType(@PathVariable int id){
        Type type = typeService.getById(id);
        return new ResponseEntity<>(type,HttpStatus.OK);
    }
}
