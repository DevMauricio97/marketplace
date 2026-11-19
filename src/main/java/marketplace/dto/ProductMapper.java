package marketplace.dto;

import marketplace.entity.Product;

public class ProductMapper {
	public static Product toEntity(ProductRequestDTO dto) {

		Product product = new Product();

		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());

		return product;
	}

	public static ProductResponseDTO toResponseDTO(Product product) {

		ProductResponseDTO dto = new ProductResponseDTO();

		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setStock(product.getStock());

		return dto;
	}

}
