package ezenweb.controller;

import ezenweb.model.dto.ProductCategoryDto;
import ezenweb.model.dto.ProductDto;
import ezenweb.service.FileService;
import ezenweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PutMapping("/category")
    public boolean updateCategory( @RequestBody ProductCategoryDto productCategoryDto){

        return productService.updateCategory(productCategoryDto );
    }

    @DeleteMapping("/category")
    public boolean deleteCategory( @RequestParam int pcno ){
        return productService.deleteCategory( pcno );
    }

    @PostMapping("")
    public boolean onProductAdd( ProductDto productDto){

        return productService.onProductAdd(productDto);
    }

    // 2.
    @GetMapping("")
    public List<ProductDto> onProductAll(){

        return productService.onProductAll();
    }

    @PutMapping("")
    public boolean onProductUpdate( @RequestBody ProductDto productDto){

        return productService.onProductUpdate(productDto);
    }


    @DeleteMapping("")
    public boolean onProductDelete( @RequestParam String pno ){
        return productService.onProductDelete(pno);
    }

    @GetMapping("/barchart")
    public List< Map<Object , Object> > getBarChart(){
        return productService.getBarChart();
    }

    @GetMapping("/piechart")
    public List< Map<Object , Object> > getPieChart(){
        return productService.getPieChart();
    }
}
