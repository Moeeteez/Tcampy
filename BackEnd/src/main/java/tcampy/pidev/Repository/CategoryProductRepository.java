package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.CategoryProduct;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct,Long> {
}
