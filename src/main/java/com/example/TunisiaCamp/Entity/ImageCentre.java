package com.example.TunisiaCamp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter

@AllArgsConstructor
@ToString


public class ImageCentre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdImage;
    private String name;
    private String type;
    @Column(length = 500000000)
    private byte[] picByte;



    public ImageCentre(String name,String type, byte[] picByte) {
        this.name = name;
        this.picByte = picByte;
        this.type = type;
    }
}
