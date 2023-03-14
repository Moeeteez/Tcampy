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

public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ActivityID;
    private String Title;

    private String Category;
    private int Price;
    private String Type;
    private String Description;
    @ManyToMany(mappedBy="activities", cascade = CascadeType.ALL)
    private Set <CampCentre> campCentreset;



}
