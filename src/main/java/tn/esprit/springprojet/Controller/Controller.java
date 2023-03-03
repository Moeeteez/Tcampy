package tn.esprit.springprojet.Controller;

import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.services.IProductCategoryService;
import tn.esprit.springprojet.services.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@AllArgsConstructor

@RestController
@Slf4j
public class Controller {
    @Autowired
    IProductService list;
    @Autowired
    IProductCategoryService listC ;

    @PostMapping("/addProduct")
    @ResponseBody
    public Product AddProduct(@RequestBody Product product) {return list.AddProduct(product);}
    @PutMapping("/updateProduct")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) {return list.updateProduct(product);}
    @GetMapping("/getAllProduct")
    List<Product> retriveAllProduct(){return list.retriveAllProduct();}
    @GetMapping("/getProduct/{id}")
    Product retriveProduct(@PathVariable long id){return list.retrieveProduct(id);}
    @DeleteMapping("/deleteProduct{id}")
    void deleteProduct(@PathVariable long id){
        list.deleteProduct(id);
    }

    ///////////////////Category///
    @PostMapping("/addProductCategory")
    @ResponseBody
    public ProductCategory AddProductCategory(@RequestBody ProductCategory productCategory) {return listC.AddProductCategory(productCategory);}
    @PutMapping("/updateProductCategory")
    @ResponseBody
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {return list.updateProduct(productCategory);}
    @GetMapping("/getAllPProductCategory")
    List<ProductCategory> retriveAllProduct(){return listC.retriveAllProductCategory();}
    @GetMapping("/getProductCategory/{id}")
    ProductCategory retriveProductCategory(@PathVariable long id){return listC.retrieveProductCategory(id);}
    @DeleteMapping("/deleteProduct{id}")
    void deleteProductCategory(@PathVariable long id){
        list.deleteProductCategory(id);
    }

}


