package tn.esprit.springprojet.DTO;

import tn.esprit.springprojet.entities.PromotionType;

import java.time.LocalDate;


    public class PromotionDTO {
        private Long id;
        private String name;
        private String description;
        private PromotionType promotionType;
        private int percentageDiscount;
        private LocalDate startDate;
        private LocalDate endDate;

        // constructeurs, getters et setters
    }

