package max.sk.HomeWork.services;

import max.sk.HomeWork.dto.ProductDTO;
import max.sk.HomeWork.model.BasketProducts;
import max.sk.HomeWork.model.Product;
import max.sk.HomeWork.repositories.BasketProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BasketProductsService {

    private BasketProductsRepository basketProductsRepository;
    private List<ProductDTO> productList;

    @Autowired
    public BasketProductsService(BasketProductsRepository basketProductsRepository){
        this.basketProductsRepository = basketProductsRepository;
    }

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
    }

    public void addProdut(ProductDTO productDTO){
        BasketProducts basketProducts = new BasketProducts(productDTO);
        productList.add(productDTO);
        basketProductsRepository.save(basketProducts);
    }
//Не хватило времени разобраться как сделать связь OneTooMany в базу H2, по быстрому сделал через лист
    //Покажите пожалуйста как сделать данную связь и получить List из базы

    public List<ProductDTO> getProductList(){
        return productList;
    }

}
