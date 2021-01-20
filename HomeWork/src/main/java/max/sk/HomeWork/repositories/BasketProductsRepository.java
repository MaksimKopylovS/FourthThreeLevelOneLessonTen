package max.sk.HomeWork.repositories;

import max.sk.HomeWork.model.BasketProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketProductsRepository extends JpaRepository<BasketProducts, Long> {

}
