package marketplace.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import marketplace.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);

	List<Product> findByPriceGreaterThan(Double price);

}
