package com.example.TunisiaCamp.Controllers;


import com.example.TunisiaCamp.Entity.CampCentre;
import com.example.TunisiaCamp.Entity.ImageCentre;
import com.example.TunisiaCamp.Services.CampCentreService;
import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("TCampy")
@CrossOrigin(origins = "http://localhost:8081")

public class CampCentreController {
    CampCentreService campCentreService;
    @PostMapping(value = {"ajouterCentreCamp"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    String ajouterCampCentre(@RequestPart("CampCntre") CampCentre campCentre,
                             @RequestPart("ImageFile") MultipartFile[] file)
    {
        // return campCentreService.ajouterCampCentre(campCentre);
       try{
          Set<ImageCentre> images = TelechargerImage(file);
          campCentre.setImageCentres(images);
          return  campCentreService.ajouterCampCentre(campCentre);

       } catch(Exception e){
           System.out.println(e.getMessage());
           return null;
       }
    }
    @PutMapping("/updateCampCentre")
    CampCentre updateCampCentre(@RequestBody CampCentre campCentre) {return campCentreService.updateCampCentre(campCentre);}

    @GetMapping("/afficheAllCampCentre")
    List<CampCentre> retriveAllCampCentre()
    {
        return campCentreService.retriveAllCampCentre();
    }

    @GetMapping("/afficheCampCentre/{id}")
    CampCentre retriveCampCentre(@PathVariable Long id)
    {
        return campCentreService.retriveCampCentre(id);
    }
    @DeleteMapping("/deleteCampCentre/{id}")
    void deleteCampCentre(@PathVariable Long id) {campCentreService.deleteCampCentre(id);}

    public Set<ImageCentre> TelechargerImage(MultipartFile[] multipartFiles) throws IOException
    {
        Set<ImageCentre> imageCentres=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            ImageCentre imageCentre=new ImageCentre(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
        }
        return imageCentres;
    }

}
