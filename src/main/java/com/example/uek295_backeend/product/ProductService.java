package com.example.uek295_backeend.product;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing products.
 */
@Service
public interface ProductService {

    /**
     * Creates a new product.
     *
     * @param product The product to be created.
     * @return The created product.
     */
    Product create(Product product);

    /**
     * Creates a new product using a DTO.
     *
     * @param productDto The product DTO with product details.
     * @return The created product DTO.
     */
    ProductDTO create(ProductDTO productDto);

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product.
     * @return The product DTO with the given ID.
     */
    ProductDTO getById(Long id);

    /**
     * Retrieves all products.
     *
     * @return A list of all product DTOs.
     */
    List<ProductDTO> getAll();

    /**
     * Creates a new product using a DTO.
     *
     * @param productDTO The product DTO with product details.
     */
    void createProduct(ProductDTO productDTO);

    /**
     * Retrieves all product entities.
     *
     * @return A list of all product entities.
     */
    List<Product> getAllProducts();

    /**
     * Retrieves a product entity by its ID.
     *
     * @param productId The ID of the product.
     * @return The product entity with the given ID.
     */
    Product getProductById(int productId);


    /**
     * Updates a product DTO using its ID.
     *
     * @param id The ID of the product DTO to be updated.
     * @param productDto The updated product DTO.
     * @return The updated product DTO.
     */
    ProductDTO update(Long id, ProductDTO productDto);

    /**
     * Updates a product using its ID.
     *
     * @param id The ID of the product to be updated.
     * @param product The updated product.
     * @return The updated product.
     */
    Product update(Long id, Product product);

    /**
     * Deletes a product using its ID.
     *
     * @param productId The ID of the product to be deleted.
     */
    void deleteProduct(int productId);

    /**
     * Retrieves all product entities by category ID.
     *
     * @param categoryId The ID of the category.
     * @return A list of all product entities in the given category.
     */
    List<Product> getProductsByCategoryId(int categoryId);

    /**
     * Deletes a product using its ID.
     *
     * @param id The ID of the product to be deleted.
     */
    void delete(Long id);

    /**
     * Converts a product entity to its corresponding DTO.
     *
     * @param product The product entity.
     * @return The corresponding product DTO.
     */
    default ProductDTO convertToDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setActive(product.getActive() == 1);
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());
        productDto.setSku(product.getSku());
        return productDto;
    }

    /**
     * Converts a product DTO to its corresponding entity.
     *
     * @param productDto The product DTO.
     * @return The corresponding product entity.
     */
    default Product convertToEntity(ProductDTO productDto) {
        Product product = new Product();
        if (productDto.getId() != null) {
            product.setId(productDto.getId());
        }
        product.setName(productDto.getName());
        product.setActive((byte) (productDto.getActive() ? 1 : 0));
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setSku(productDto.getSku());
        return product;
    }
}
