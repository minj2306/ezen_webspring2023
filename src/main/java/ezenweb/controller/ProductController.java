package ezenweb.controller;

import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.dto.ProductDto;
import ezenweb.service.FileService;
import ezenweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/product" )
public class ProductController {

    @Autowired
    ProductService productService;



    @PostMapping("/category")
    public boolean addCategory(@RequestBody ProductCategoryDto productCategoryDto){

        return productService.addCategory(productCategoryDto);
    }

    @GetMapping("/category")
    public List<ProductCategoryDto> printCategory(){

        return productService.printCategory();
    }

    @PutMapping("category")
    public boolean updateCategory( @RequestBody ProductCategoryDto productCategoryDto){

        return productService.updateCategory(productCategoryDto );
    }

    @DeleteMapping("/category")
    public boolean deleteCategory( @RequestParam int pcno ){
        return productService.deleteCategory( pcno );
    }


}
