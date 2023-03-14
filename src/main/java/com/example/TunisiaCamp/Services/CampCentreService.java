package com.example.TunisiaCamp.Services;

import com.example.TunisiaCamp.Entity.CampCentre;
import com.example.TunisiaCamp.Repository.CampCentreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class CampCentreService implements ICampCentreService{

    CampCentreRepository campCentreRepository;
    @Override
    public String ajouterCampCentre(CampCentre campCentre)
    {
        if (campCentre.getPhone().length() != 12 || campCentre.getPhone().length() != 8 ) {
        return "Le CIN doit contenir 12 ou bien 8 chiffres.";
    }
         else
            campCentreRepository.save(campCentre);
        return "ajout avec succés";
    }

    @Override
    public CampCentre updateCampCentre(CampCentre campCentre) {
        return campCentreRepository.save(campCentre);
    }

    @Override
    public List<CampCentre> retriveAllCampCentre() {
        return campCentreRepository.findAll();
    }

    @Override
    public CampCentre retriveCampCentre(Long id) {
        return campCentreRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCampCentre(Long id) {
        campCentreRepository.deleteById(id);

    }

}
