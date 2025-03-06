package week1.internJava.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week1.internJava.entity.Product;
import week1.internJava.entity.ProductSold;
import week1.internJava.repository.ProductRepository;
import week1.internJava.repository.ProductSoldRepository;

import java.time.Instant;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSoldRepository productSoldRepository;

    @Transactional
    public void sellProduct(int productId, int quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        product.setQuantity(product.getQuantity() - quantity);
        product.setExportAt(Instant.from(Instant.now()));
        productRepository.save(product);

        ProductSold productSold = new ProductSold();
        productSold.setProduct(product);
        productSold.setQuantityOut(quantity);
        productSold.setStockOutDate(Instant.now());

        productSoldRepository.save(productSold);
    }
}


