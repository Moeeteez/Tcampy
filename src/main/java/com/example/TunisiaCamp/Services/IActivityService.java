package com.example.TunisiaCamp.Services;

import com.example.TunisiaCamp.Entity.Activity;

import java.util.List;

public interface IActivityService {
    Activity ajouterActivity(Activity activity);
    Activity updateActivity(Activity activity);
    List<Activity> retriveAllActivity();
    Activity retriveActivity(Long id);
    void deleteActivity(Long id);
}
