package com.example.TunisiaCamp.Repository;

import com.example.TunisiaCamp.Entity.CampCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampCentreRepository extends JpaRepository<CampCentre,Long> {

}
