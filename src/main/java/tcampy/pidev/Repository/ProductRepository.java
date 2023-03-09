package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findBySku(String sku) ;
}
