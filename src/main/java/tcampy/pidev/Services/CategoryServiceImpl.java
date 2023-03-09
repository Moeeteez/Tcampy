package tcampy.pidev.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcampy.pidev.Entity.CategoryProduct;
import tcampy.pidev.Repository.CategoryProductRepository;
import tcampy.pidev.Repository.ProductRepository;

import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService {


    @Autowired
    CategoryProductRepository categoryProductRepository;
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<CategoryProduct> retriveAllProductCategory() {
        return categoryProductRepository.findAll();
    }

    @Override
    public CategoryProduct AddProductCategory(CategoryProduct categoryProduct) {
        return categoryProductRepository.save(categoryProduct);
    }

    @Override
    public void deleteProductCategory(long id) {
        categoryProductRepository.deleteById(id);
    }

    @Override
    public CategoryProduct updateProductCategory(CategoryProduct productCategory) {
        return categoryProductRepository.save(productCategory);
    }

    @Override
    public CategoryProduct retrieveProductCategoryByID(long id) {
        return categoryProductRepository.findById(id).orElse(null);
    }

}
