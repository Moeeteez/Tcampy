package com.example.TunisiaCamp.Services;

import com.example.TunisiaCamp.Entity.Activity;
import com.example.TunisiaCamp.Entity.CampCentre;
import com.example.TunisiaCamp.Repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@AllArgsConstructor
public class ActivityService implements IActivityService{

    ActivityRepository activityRepository;
    @Override
    public Activity ajouterActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityRepository.save(activity);
    }


    public List<Activity> retriveAllActivity() {
        return activityRepository.findAll();
    }

    @Override
    public Activity retriveActivity(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);

    }
//RechercherCentreByActivity
public List<CampCentre> RechercherCentreByActivity(String TitleActivity) {

    return activityRepository.RechercherCentreByActivity(TitleActivity);
    }
}
