
package marketplace;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import marketplace.dto.ProductRequestDTO;
import marketplace.dto.ProductResponseDTO;
import marketplace.entity.Product;
import marketplace.repository.ProductRepository;
import marketplace.service.ProductService;

@SpringBootTest
class MarketplaceApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

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

		System.out.println("Product ID: " + savedProduct.getId());
	}

	@Test
	void shouldFindAllProducts() {

		List<ProductResponseDTO> products = productService.findAllProducts();

		products.forEach(product -> {
			System.out.println("Product: " + product.getName());
		});
	}

	@Test
	void shouldFindProductById() {

		ProductResponseDTO product = productService.findProductById(3L);

		System.out.println("Found Product: " + product.getName());

	}

	@Test
	void shouldDeleteProduct() {

		ProductRequestDTO dto = new ProductRequestDTO();

		dto.setName("Product to delete");
		dto.setDescription("Temporary product");
		dto.setPrice(100.0);
		dto.setStock(5);

		ProductResponseDTO savedProduct = productService.saveProduct(dto);

		productService.deleteProduct(savedProduct.getId());

		ProductResponseDTO deletedProduct = productService.findProductById(savedProduct.getId());

		System.out.println("Product deleted: " + (deletedProduct == null));
	}

}
