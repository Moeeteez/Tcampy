package com.example.TunisiaCamp.Controllers;


import com.example.TunisiaCamp.Entity.Note_Camping;
import com.example.TunisiaCamp.Services.NoteCampingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("TCampy")
@CrossOrigin(origins = "http://localhost:8081")


public class NoteCampingController {
    NoteCampingService noteCampingService;
    @PostMapping("/ajouterNoteCamping")
    Note_Camping ajouterNoteCamping(@RequestBody Note_Camping noteCamping) {return noteCampingService.ajouterNoteCamping(noteCamping);}
    @PutMapping("/updateNoteCamping")
    Note_Camping updateNoteCamping(@RequestBody Note_Camping noteCampin) {return noteCampingService.updateNoteCamping(noteCampin);}

    @GetMapping("/afficheAllNoteCamping")
    List<Note_Camping> retriveAllNoteCamping() {return noteCampingService.retriveAllNoteCamping();}

    @GetMapping("/afficheNoteCamping/{id}")
    Note_Camping retriveNoteCamping(@PathVariable Long id)
    {
        return noteCampingService.retriveNoteCamping(id);
    }
    @DeleteMapping("/deleteNoteCamping/{id}")
    void deleteNoteCamping(@PathVariable Long id) {noteCampingService.deleteNoteCamping(id);}
}
