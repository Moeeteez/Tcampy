package tn.esprit.springprojet.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.PromotionType;

import java.time.LocalDate;
@Data
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private double priceSale;
    private String imageUrl;
    private PromotionDTO promotionDTO;

}

