package com.example.TunisiaCamp.Services;

import com.example.TunisiaCamp.Entity.Note_Camping;
import com.example.TunisiaCamp.Repository.NoteCampingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class NoteCampingService implements INoteCampingService{

    NoteCampingRepository noteCampingRepository;
    @Override
    public Note_Camping ajouterNoteCamping(Note_Camping noteCamping) {
        return noteCampingRepository.save(noteCamping);
    }

    @Override
    public Note_Camping updateNoteCamping(Note_Camping noteCamping) {
        return noteCampingRepository.save(noteCamping);
    }

    @Override
    public List<Note_Camping> retriveAllNoteCamping() {
        return noteCampingRepository.findAll();
    }

    @Override
    public Note_Camping retriveNoteCamping(Long id) {
        return noteCampingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteNoteCamping(Long id) {
        noteCampingRepository.deleteById(id);

    }
}
