package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Services.ICategoryService;
import tcampy.pidev.Services.IProductService;
import tcampy.pidev.Services.ProductServiceImpl;

import java.util.List;

@AllArgsConstructor

@RestController
@Slf4j
public class ControllerProduct {

    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/getAllProduct")
    List<Product> retriveAllProduct() {
        return iProductService.retriveAllProduct();
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public Product AddProduct(@RequestBody Product product) {
        return iProductService.AddProduct(product);
    }

    @PutMapping("/updateProduct")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) {
        return iProductService.updateProduct(product);
    }

    @GetMapping("/getProduct/{id}")
    Product retriveProduct(@PathVariable long id) {
        return iProductService.retrieveProductById(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    void deleteProduct(@PathVariable long id) {
        iProductService.deleteProduct(id);
    }

    @PutMapping("/AddProductToCategory/{idProduct}/{idCategory}")
    public void AddProductToCategory(@PathVariable long idProduct, @PathVariable long idCategory) {
        iProductService.AddProductToCategory(idProduct, idCategory);
    }

}

