package com.example.TunisiaCamp.Repository;

import com.example.TunisiaCamp.Entity.Activity;
import com.example.TunisiaCamp.Entity.CampCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Long> {
    @Query("SELECT a.campCentreset FROM Activity a where a.Title=:TitleActivity")
    List<CampCentre> RechercherCentreByActivity(String TitleActivity);
}
