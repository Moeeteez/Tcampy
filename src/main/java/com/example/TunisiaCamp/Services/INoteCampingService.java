package com.example.TunisiaCamp.Services;

import com.example.TunisiaCamp.Entity.CampCentre;
import com.example.TunisiaCamp.Entity.Note_Camping;

import java.util.List;

public interface INoteCampingService {
    Note_Camping ajouterNoteCamping(Note_Camping noteCamping);
    Note_Camping updateNoteCamping(Note_Camping noteCamping);
    List<Note_Camping> retriveAllNoteCamping();
    Note_Camping retriveNoteCamping(Long id);
    void deleteNoteCamping(Long id);
}
