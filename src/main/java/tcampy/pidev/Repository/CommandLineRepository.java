package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcampy.pidev.Entity.CommandLine;

public interface CommandLineRepository extends JpaRepository<CommandLine,Long> {
}
