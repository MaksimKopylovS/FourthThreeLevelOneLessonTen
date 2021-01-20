package max.sk.HomeWork.services;

import max.sk.HomeWork.dto.ProductDTO;
import max.sk.HomeWork.model.Product;
import max.sk.HomeWork.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<ProductDTO> findAll(Specification<Product> spec, int page, int pageSize) {
        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDTO::new);
    }

    public ProductDTO saveOrUpdate(ProductDTO productDTO) {
        productRepository.save(new Product(productDTO));
        return productDTO;
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<ProductDTO> findProductById(Long findId){
        //Product product = productRepository.getOne(findId);
        return productRepository.findById(findId).map(ProductDTO::new);
    }

    public ProductDTO editProduct(ProductDTO productDTO){
        Product product = productRepository.getOne(productDTO.getId());
        productRepository.save(new Product(
                product.getId(),
                product.getTitle(),
                product.getCost(),
                product.getCreateAt(),
                new Date()
        ));
        return productDTO;
    }

}
