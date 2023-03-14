package com.example.TunisiaCamp.Controllers;

import com.example.TunisiaCamp.Entity.Activity;
import com.example.TunisiaCamp.Entity.CampCentre;
import com.example.TunisiaCamp.Services.ActivityService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("TCampy")
@CrossOrigin(origins = "http://localhost:8081")


public class ActivityController {

    ActivityService activityService;
    @PostMapping("/ajouterActivity")
    Activity ajouterActivity(@RequestBody Activity activity)
    {
        return activityService.ajouterActivity(activity);
    }
    @PutMapping("/updateActivity")
    Activity updateActivity(@RequestBody Activity activity)
    {
        return activityService.updateActivity(activity);
    }

    @GetMapping("/afficheAllActivity")
    List<Activity> retriveAllActivity()
    {
        return activityService.retriveAllActivity();
    }

    @GetMapping("/afficheActivity/{id}")
    Activity retriveActivity(@PathVariable Long id)
    {
        return activityService.retriveActivity(id);
    }
    @DeleteMapping("/deleteActivity/{id}")
    void deleteActivity(@PathVariable Long id) {activityService.deleteActivity(id);}

    @GetMapping("/CentreByActivity/{TitleActivity}")
    List<CampCentre> RechercherCentreByActivity(String TitleActivity) {
        return activityService.RechercherCentreByActivity(TitleActivity);
    }
}
