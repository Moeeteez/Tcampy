package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Services.ICategoryService;
import tcampy.pidev.Services.IProductService;

import java.util.List;

@AllArgsConstructor

@RestController
@Slf4j
@RequestMapping("Product")
public class ProductController {

    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/getAll")
    List<Product> retriveAllProduct() {
        return iProductService.retriveAllProduct();
    }

    @PostMapping("/add")
    @ResponseBody
    public Product AddProduct(@RequestBody Product product) {
        return iProductService.AddProduct(product);
    }

    @PutMapping("/update")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) {
        return iProductService.updateProduct(product);
    }

    @GetMapping("/get/{id}")
    Product retriveProduct(@PathVariable long id) {
        return iProductService.retrieveProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable long id) {
        iProductService.deleteProduct(id);
    }

    @PutMapping("/AddToCategory/{idProduct}/{idCategory}")
    public void AddProductToCategory(@PathVariable long idProduct, @PathVariable long idCategory) {
        iProductService.AddProductToCategory(idProduct, idCategory);
    }
    @GetMapping("/{name}")
    Product retriveProduct(@PathVariable String name) {
        return iProductService.findByName(name);
    }

    @GetMapping("/type/{type}")
    Product retriveProductByType(@PathVariable String type) {
        return iProductService.findProductByType(type);
    }



}


