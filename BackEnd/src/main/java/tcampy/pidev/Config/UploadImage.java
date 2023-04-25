package tcampy.pidev.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import tcampy.pidev.Entity.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



@Service
public class UploadImage {


    @Value("C:\\Users\\Moetez\\Desktop\\pidev\\src\\main \\resources\\images\\")
    String FILE_DIR;

    public  ResponseEntity<Object> image (MultipartFile imageFile, Model model , Product publicity) throws IOException {
        File myFile =new File(FILE_DIR + imageFile.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(imageFile.getBytes());
        fos.close();
        return  new ResponseEntity<Object>("the File Uploaded Successfully", HttpStatus.OK);
    }

}
