package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tcampy.pidev.Services.IimageService;
import tcampy.pidev.Services.ImageProductService;

import java.io.IOException;

@AllArgsConstructor

@RestController
@Slf4j
public class ImageController {
@Autowired
ImageProductService imageProductService ;


	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		String uploadImage=imageProductService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}
	@GetMapping
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageCentre=imageProductService.download(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageCentre);
    }
}
