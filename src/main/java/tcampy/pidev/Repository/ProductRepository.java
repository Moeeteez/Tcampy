package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Product;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {

   // Product findBySku(String sku) ;
//   @Query("select p from Product p where p.name=:Name")
//    Product findByName (@Param("Name") String Name);
   Product findProductByName(String Name);
   Product findProductByType ( String Type) ;
}
