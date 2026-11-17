package marketplace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import marketplace.entity.Product;
import marketplace.repository.ProductRepository;

@SpringBootTest
class MarketplaceApplicationTests {
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void shouldSaveProduct() {
		
		Product product = new Product();
		
		product.setName("Notebook");
		product.setDescription("Notebook for testing");
		product.setPrice(3500.0);
		product.setStock(10);
		
		Product savedProduct = productRepository.save(product);
		System.out.println("Produxt ID: " + savedProduct.getId());
	}

}
