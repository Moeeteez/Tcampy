package tcampy.pidev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tcampy.pidev.Entity.CategoryProduct;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Repository.CategoryProductRepository;
import tcampy.pidev.Repository.ProductRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ProductServiceImpl implements  IProductService{
    @Autowired
    ProductRepository productRepository ;

    @Autowired
    CategoryProductRepository categoryProductRepository ;
    @Override
    public List<Product> retriveAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product AddProduct(Product product) {
        return productRepository.save(product);}

    @Override
    public void deleteProduct(Long id) {productRepository.deleteById(id);}
    @Override
    public Product updateProduct(Product product)  {return productRepository.save(product);}
    @Override
    public Product retrieveProductById(Long id) {
        return productRepository.findById(id).orElse(null) ;
    }
    @Override
    public void AddProductToCategory(Long idProduct, Long idCategory){
        CategoryProduct C =categoryProductRepository.findById(idCategory).orElse(null);
        Product p = productRepository.findById(idProduct).orElse(null) ;
        p.setCategory(C);
        productRepository.save(p);}

    @Override
    public Product findByName(String Name) {
        return productRepository.findProductByName(Name);
    }

    @Override
    public Product findProductByType(String Type) {
        return productRepository.findProductByType(Type);
    }


//    public void assigneProductToCategory(String sku, long idProduct) {
//    Product product =productRepository.findBySku(sku);
//    ProductCategory productCategory =productCategoryRepository.findById(idProduct).orElse(null);
//   productCategory.getProducts().add(product) ;}



//    public void uploadImage(Long productId, MultipartFile file) {
//        Product product = retrieveProductById(productId);
//        try {
//            String filename = StringUtils.cleanPath(file.getOriginalFilename());
//
//            Path targetLocation = this.fileStorageLocation.resolve(filename);
//            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//            String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(filename).toUriString();
//            product.setImageUrl(imageUrl);
//            productRepository.save(product);
//
//    }

}
