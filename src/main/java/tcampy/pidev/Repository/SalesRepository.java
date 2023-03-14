package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Entity.Sales;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface SalesRepository extends JpaRepository<Sales,Long> {
//    List<Sales> findByProduct(Product product);
//    List<Sales> findBySaleDate(Date date);
//    int countByProduct(Product product);

//    @Query("SELECT SUM(s.price) FROM Sales s WHERE s.product = :product")
//    double sumPrixByProduct(@Param("product") Product product);

    @Query("SELECT SUM(s.quantity * s.price) FROM Sales s WHERE s.product.idProduct = :productId")
    Double findTotalRevenueByProduct(@Param("productId") Long productId);

    @Query("SELECT p.name, SUM(s.quantity) as quantitySold "
            + "FROM Sales s "
            + "JOIN s.product p "
            + "WHERE s.saleDate BETWEEN :startDate AND :endDate "
            + "GROUP BY p.idProduct"
            + " order by quantitySold DESC")
    List<Object[]> findTopSellingProducts(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<Sales> findAllByOrderByQuantityDesc();
}
