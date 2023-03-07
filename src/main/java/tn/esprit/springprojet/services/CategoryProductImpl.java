package tn.esprit.springprojet.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.repositories.ProductCategoryRepository;
import tn.esprit.springprojet.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
@Service
@Slf4j
@AllArgsConstructor
public class CategoryProductImpl  implements IProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductCategory> retriveAllProductCategory() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory AddProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteProductCategory(long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory retrieveProductCategory(long id) {
        return productCategoryRepository.findById(id).orElse(null);
    }


}