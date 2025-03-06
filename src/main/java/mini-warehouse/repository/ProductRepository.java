package week1.internJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import week1.internJava.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    Optional<Product> findByProductName(String productName);
//
//    List<Product> findListProduct(String productName);
//
//    Product findByPosition(String position);
//
//    Product findProductByImportAt(Instant importAt);
//
//    Product findProductByExportAt(Instant exportAt);


}
