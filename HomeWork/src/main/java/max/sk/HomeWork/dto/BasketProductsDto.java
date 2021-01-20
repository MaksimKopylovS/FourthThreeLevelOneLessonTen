package max.sk.HomeWork.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class BasketProductsDto {

    private Long id;

    private Long idProduct;
}
