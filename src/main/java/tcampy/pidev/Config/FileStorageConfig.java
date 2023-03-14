//package tcampy.pidev.Config;
//
//import lombok.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Configuration
//public class FileStorageConfig {
//    @Value("${file.upload-dir}")
//    private String uploadDir;
//
//    @Bean
//    public void init() {
//        Path uploadPath = Paths.get(uploadDir);
//        try {
//            Files.createDirectories(uploadPath);
//        } catch (IOException ex) {
//            throw new FileStorageException("Could not create upload directory " + uploadDir, ex);
//        }
//    }
//
//    @Bean
//    public Path fileStorageLocation() {
//        return Paths.get(uploadDir).toAbsolutePath().normalize();
//    }
//}
