package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tcampy.pidev.Entity.ImageProduct;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Services.ICategoryService;
import tcampy.pidev.Services.IProductService;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor

@RestController
@Slf4j
@RequestMapping("Product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/getAll")
    List<Product> retriveAllProduct( @RequestParam(defaultValue = "0") int pageNumber,
                                     @RequestParam(defaultValue ="") String searchKey) {

        Pageable pageable = PageRequest.of(pageNumber,1);
        if(searchKey.equals("")) {
            return iProductService.retriveAllProduct(pageable);
        }else {
            return (List<Product>) iProductService.findByNameAndDescription(searchKey,searchKey,pageable);

        }
    }

    @PostMapping(value = {"/add"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})

    public Product AddProduct(  @RequestPart("product") Product product ,
                                @RequestPart("imageFile") MultipartFile[] file) {
        try {
            Set<ImageProduct> images = uploadImage(file);
            product.setProductImages(images);
           return iProductService.AddProduct(product);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return  null ;
            }
    }
    public Set<ImageProduct> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageProduct> imageProducts = new HashSet<>() ;
        for(MultipartFile file: multipartFiles){
            ImageProduct imageProduct = new ImageProduct(
            file.getOriginalFilename(),
            file.getContentType(),
            file.getBytes()
            );
            imageProducts.add(imageProduct) ;
        }
        return imageProducts ;
    }

    @PutMapping("/update")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) {
        return iProductService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Integer id) {
        iProductService.deleteProduct(id);
    }

    @PutMapping("/AddToCategory/{idProduct}/{idCategory}")
    public void AddProductToCategory(@PathVariable Integer idProduct, @PathVariable long idCategory) {
        iProductService.AddProductToCategory(idProduct, idCategory);
    }
//    @GetMapping("/{name}")
//    Product retriveProduct(@PathVariable String name) {
//        return iProductService.findByName(name);
//    }

    @GetMapping("/type/{type}")
    Product retriveProductByType(@PathVariable String type) {
        return iProductService.findProductByType(type);
    }

    @GetMapping("/get/{idProduct}")
    public Product getProductDetailsById( @PathVariable("idProduct") Integer idProduct){
        return  iProductService.getProductDetailsById(idProduct) ;
    }



@GetMapping({"/getProductDetails/{isSingleProductCheckout}/{productId}"})
public List<Product> getProductDetails(@PathVariable(name = "isSingleProductCheckout" ) boolean isSingleProductCheckout,
                                       @PathVariable(name = "productId")  Integer productId) {
    return iProductService.getProductDetails(isSingleProductCheckout, productId);
}
}


