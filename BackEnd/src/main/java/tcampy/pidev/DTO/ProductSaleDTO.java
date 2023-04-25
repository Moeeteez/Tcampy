package tcampy.pidev.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tcampy.pidev.Entity.CategoryProduct;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaleDTO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idd;
    private String productName;
    private Long quantity;


    public ProductSaleDTO(Long productId, String productName, String description, double price, CategoryProduct categoryProduct) {

    }
}