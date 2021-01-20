package max.sk.HomeWork.controller;

import lombok.RequiredArgsConstructor;
import max.sk.HomeWork.dto.ProductDTO;
import max.sk.HomeWork.services.BasketProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
@RequiredArgsConstructor
public class BasketProductsController {
    private BasketProductsService basketProductsService;

    @Autowired
    public BasketProductsController(BasketProductsService basketProductsService){
        this.basketProductsService = basketProductsService;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductDTO> basketProduct(@RequestBody ProductDTO productDTO) {
         basketProductsService.addProdut(productDTO);
        return basketProductsService.getProductList();
    }
}
