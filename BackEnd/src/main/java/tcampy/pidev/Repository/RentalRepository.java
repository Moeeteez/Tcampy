package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Entity.Rental;

import java.util.Date;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental ,Long> {
   // List<Rental> findBetwenDates(Date date1, Date date2);
 //   int countByProduct(Product product);

//    @Query("SELECT SUM(r.price) FROM Rental r WHERE r.Product = :product")
//    Double getTotalPriceByProduct(@Param("product") Product product);
}
