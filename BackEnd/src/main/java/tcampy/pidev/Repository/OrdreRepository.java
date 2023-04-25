package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tcampy.pidev.Entity.Offer;
import tcampy.pidev.Entity.Order;

public interface OrdreRepository extends JpaRepository<Order,Integer> {

}
