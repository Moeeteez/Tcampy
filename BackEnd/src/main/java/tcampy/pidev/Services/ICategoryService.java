package tcampy.pidev.Services;

import tcampy.pidev.Entity.CategoryProduct;

import java.util.List;

public interface ICategoryService {
     List<CategoryProduct> retriveAllProductCategory() ;
     CategoryProduct AddProductCategory(CategoryProduct categoryProduct);
        void deleteProductCategory(long id) ;
       CategoryProduct updateProductCategory(CategoryProduct productCategory) ;
          CategoryProduct retrieveProductCategoryByID(long id);



}
