package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcampy.pidev.Entity.Offer;
import tcampy.pidev.Entity.Order;

public interface OrdreRepository extends JpaRepository<Order,Long> {
}
