package com.example.TunisiaCamp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CampCentre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCamp;
    private String Name;
    private String Place;
    private String Email;
    private String Adresse;
    private String Phone;
    private String description;
    @ManyToMany
    private Set<Activity> activities;
    @ManyToOne
    private Note_Camping noteCamping;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="centre")
    private Set <Booking> bookings;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="image_Centres",
            joinColumns = {@JoinColumn(name = "idCamp")},
            inverseJoinColumns = {@JoinColumn(name = "IdImage")}

    )
     private  Set<ImageCentre> imageCentres;

}
