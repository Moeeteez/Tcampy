package tcampy.pidev.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Cart;

@Repository
public interface CardRepository extends JpaRepository<Cart,Integer> {


}
