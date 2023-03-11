package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tcampy.pidev.Entity.Offer;
import tcampy.pidev.Entity.Order;

public interface OrdreRepository extends JpaRepository<Order,Long> {

//    @Query("SELECT SUM(p.priceSale * c.quantityProds) + SUM(p.priceRental * c.quantityProds) as totalAmount\n" +
//            "FROM CommandLine c\n" +
//            "JOIN c.products p\n" +
//            "WHERE c.id.idOrder = :orderId\n")
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o.idOrder, SUM(cl.quantityProds * p.priceSale) FROM Order JOIN o.commandLine cl JOIN cl.products p GROUP BY o.idOrder")
    double getTotalAmountByOrder(@Param("o") Order order);
}


    double getTotalAmountByOrder(@Param("order") Order order);

}
