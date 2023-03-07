package com.example.TunisiaCamp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Note_Camping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDNote;
    private String Note;
    private String Comment;
    @Enumerated(EnumType.STRING)
    private NoteCampingEnum noteCampingEnum;
    @Temporal(TemporalType.DATE)
    private Date DateCamping;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="noteCamping")
    private  Set<CampCentre> campCentres;
}
