package tcampy.pidev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcampy.pidev.Entity.CategoryProduct;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Repository.CategoryProductRepository;
import tcampy.pidev.Repository.ProductRepository;

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
    public Product AddProduct(Product product) {return productRepository.save(product);}

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

//    public void assigneProductToCategory(String sku, long idProduct) {
//    Product product =productRepository.findBySku(sku);
//    ProductCategory productCategory =productCategoryRepository.findById(idProduct).orElse(null);
//   productCategory.getProducts().add(product) ;}

}
