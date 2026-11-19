package marketplace.service;

import java.util.List;
import marketplace.dto.ProductMapper;
import marketplace.dto.ProductRequestDTO;
import marketplace.dto.ProductResponseDTO;

import org.springframework.stereotype.Service;

import marketplace.entity.Product;
import marketplace.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductResponseDTO saveProduct(ProductRequestDTO dto) {

		Product product = ProductMapper.toEntity(dto);

		Product savedProduct = productRepository.save(product);

		return ProductMapper.toResponseDTO(savedProduct);
	}

	public List<ProductResponseDTO> findAllProducts() {

		return productRepository.findAll().stream().map(ProductMapper::toResponseDTO).toList();

	}

	public ProductResponseDTO findProductById(Long id) {

		Product product = productRepository.findById(id).orElse(null);

		if (product == null) {
			return null;
		}

		return ProductMapper.toResponseDTO(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
