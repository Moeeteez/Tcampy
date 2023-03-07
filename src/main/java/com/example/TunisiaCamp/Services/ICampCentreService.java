package com.example.TunisiaCamp.Services;

import com.example.TunisiaCamp.Entity.Booking;
import com.example.TunisiaCamp.Entity.CampCentre;

import java.util.List;

public interface ICampCentreService {
    String ajouterCampCentre(CampCentre campCentre);
    CampCentre updateCampCentre(CampCentre campCentre);
    List<CampCentre> retriveAllCampCentre();
    CampCentre retriveCampCentre(Long id);
    void deleteCampCentre(Long id);
}
