package com.example.uek295_backeend.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product create(Product product);

    ProductDTO create(ProductDTO productDto);

    ProductDTO getById(Long id);

    List<ProductDTO> getAll();

    ProductDTO update(Long id, ProductDTO productDto);

    Product update(Long id, Product product);

    void delete(Long id);

    default ProductDTO convertToDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setActive(product.getActive() == 1);
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());
        return productDto;
    }

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
        return product;
    }

}
