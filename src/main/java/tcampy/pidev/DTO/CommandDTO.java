package tcampy.pidev.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandDTO {
    private Long productId;
    private Integer quantity;
}
