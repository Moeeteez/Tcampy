package tcampy.pidev.Repository;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , String> {
}
