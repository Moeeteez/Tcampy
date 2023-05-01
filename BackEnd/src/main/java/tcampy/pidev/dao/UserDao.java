package tcampy.pidev.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
