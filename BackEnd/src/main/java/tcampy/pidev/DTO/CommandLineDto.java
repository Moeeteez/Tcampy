package tcampy.pidev.DTO;

import tcampy.pidev.Entity.Product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CommandLineDto {

    private Product product;
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
