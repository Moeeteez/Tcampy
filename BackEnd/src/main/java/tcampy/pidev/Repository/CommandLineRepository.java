package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.CommandLine;
import tcampy.pidev.Entity.CommandLineKey;

@Repository
public interface CommandLineRepository extends JpaRepository<CommandLine, CommandLineKey> {
}
