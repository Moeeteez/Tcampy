package com.example.TunisiaCamp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdBooking;
    @Temporal(TemporalType.DATE)
    private Date DateCheckIN;
    @Temporal(TemporalType.DATE)
    private Date DateCheckOut;
    private int Membres;
    private String Place;
    @ManyToOne
    private CampCentre centre;

}
