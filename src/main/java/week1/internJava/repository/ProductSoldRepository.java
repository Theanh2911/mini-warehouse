package week1.internJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import week1.internJava.entity.ProductSold;

@Repository
public interface ProductSoldRepository extends JpaRepository<ProductSold, Integer> {
}
