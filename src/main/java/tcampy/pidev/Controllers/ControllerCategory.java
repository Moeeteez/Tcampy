package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcampy.pidev.Entity.CategoryProduct;
import tcampy.pidev.Services.ICategoryService;

import java.util.List;

@AllArgsConstructor

@RestController
@Slf4j
public class ControllerCategory {
@Autowired
    ICategoryService iCategoryService ;


    @PostMapping("/addProductCategory")
    @ResponseBody
    public CategoryProduct AddProductCategory(@RequestBody CategoryProduct categoryProduct) {
        return iCategoryService.AddProductCategory(categoryProduct);
    }

    @PutMapping("/updateProductCategory")
    @ResponseBody
    public CategoryProduct updateProductCategory(@RequestBody CategoryProduct categoryProduct) {
        return iCategoryService.updateProductCategory(categoryProduct);
    }

    @GetMapping("/getAllProductCategory")
    List<CategoryProduct> retriveAllProductCategory() {
        return iCategoryService.retriveAllProductCategory();
    }

    @GetMapping("/getProductCategory/{id}")
    CategoryProduct retriveProductCategory(@PathVariable long id) {
        return iCategoryService.retrieveProductCategoryByID(id);
    }

    @DeleteMapping("/deleteProductCategory{id}")
    void deleteProductCategory(@PathVariable long id) {
        iCategoryService.deleteProductCategory(id);
    }
}
