package marketplace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import marketplace.entity.Product;
import marketplace.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
