package tcampy.pidev.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Cart;
import tcampy.pidev.Entity.User;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Cart,Integer> {

    List<Cart> findByUser(User user);
}
