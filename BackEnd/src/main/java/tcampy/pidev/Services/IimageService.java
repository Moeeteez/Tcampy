package tcampy.pidev.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IimageService {

    public String uploadImage(MultipartFile file)throws IOException;
    public  byte[] download (String fileName);
}
