package tcampy.pidev.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tcampy.pidev.Config.ImageUtils;
import tcampy.pidev.Entity.ImageProduct;
import tcampy.pidev.Repository.ImageProductRepository;

import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class ImageProductService {
    @Autowired
    ImageProductRepository imageProductRepository ;


    public String uploadImage(MultipartFile file) throws IOException {
        ImageProduct imageCentre= imageProductRepository.save(ImageProduct.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageProduct(ImageUtils.compressImage(file.getBytes())).build());
        if (imageCentre != null) {
            return "file uploaded sucessfully :" + file.getOriginalFilename();
        } return null;
    }

    public  byte[] download (String fileName){
        Optional<ImageProduct> dbImageCentre= imageProductRepository.findByName(fileName);

        byte[] images=ImageUtils.decompressImage(dbImageCentre.get().getImageProduct());
        return images;
    }


}
