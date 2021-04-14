package ro.msg.learning.shop.dtos.builders;

import lombok.extern.slf4j.Slf4j;
import ro.msg.learning.shop.dtos.ProductDto;
import ro.msg.learning.shop.entities.Product;

@Slf4j
public class ProductBuilder {

    public static ProductDto toProductDto(Product product){
        log.info("Entering the toProductDto(product) method in ProductBuilder...");
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageURL(product.getImageURL());
        productDto.setWeight(product.getWeight());
        productDto.setNameOfCategory(product.getProductCategory().getName());
        productDto.setDescriptionOfCategory(product.getProductCategory().getDescription());
        productDto.setNameOfSupplier(product.getSupplier().getName());
        return productDto;
    }

    public static Product toProductEntity(ProductDto productDto){
        log.info("Entering the toProductDto(product) method in ProductBuilder...");
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setWeight(productDto.getWeight());
        return product;
    }
}
