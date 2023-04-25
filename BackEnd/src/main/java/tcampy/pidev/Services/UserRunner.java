package tcampy.pidev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tcampy.pidev.Entity.User;
import tcampy.pidev.Repository.UserRepository;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("moetez" , "esprit");
        userRepository.save(user);
    }
}
