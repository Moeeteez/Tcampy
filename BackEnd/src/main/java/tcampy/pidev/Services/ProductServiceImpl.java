package tcampy.pidev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tcampy.pidev.Entity.Cart;
import tcampy.pidev.Entity.CategoryProduct;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Entity.User;
import tcampy.pidev.Repository.CardRepository;
import tcampy.pidev.Repository.CategoryProductRepository;
import tcampy.pidev.Repository.ProductRepository;
import tcampy.pidev.dao.ProductDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements  IProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryProductRepository categoryProductRepository;

    @Autowired
    CardRepository cardRepository ;

//    @Override
//    public List<Product> retriveAllProduct() {
//        return productRepository.findAll();
//    }

    @Override
    public Product AddProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product retrieveProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void AddProductToCategory(Integer idProduct, Long idCategory) {
        CategoryProduct C = categoryProductRepository.findById(idCategory).orElse(null);
        Product p = productRepository.findById(idProduct).orElse(null);
        p.setCategory(C);
        productRepository.save(p);
    }

    @Override
    public List <Product> findByNameAndDescription(String key1 , String key2 , Pageable pageable) {
        return productRepository.findProductByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(key1,key2,pageable);
    }

    @Override
    public Product findProductByType(String Type) {
        return productRepository.findProductByType(Type);
    }

    public Product getProductDetailsById(Integer idProduct) {
        return productRepository.findById(idProduct).get();
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

    public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {
        if (isSingleProductCheckout && productId != 0) {
            // we are going to buy a single product

            List<Product> list = new ArrayList<>();
            Product product = productDao.findById(productId).get();
            list.add(product);
            return list;
        } else {
            // we are going to checkout entire cart

            User user = new User("moeeteez", "moetez", "hammadi", "moet1544");
            List<Cart> carts = cardRepository.findByUser(user);

            return carts.stream().map(x -> x.getProduct()).collect(Collectors.toList());
        }

    }

    @Override
    public List<Product> retriveAllProduct(Pageable pageable) {
        return  productRepository.findAll(pageable).getContent();

    }
}

