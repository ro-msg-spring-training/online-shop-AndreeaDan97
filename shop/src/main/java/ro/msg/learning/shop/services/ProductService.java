package ro.msg.learning.shop.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.controllers.exceptions.ProductNotFoundException;
import ro.msg.learning.shop.dtos.ProductDto;
import ro.msg.learning.shop.dtos.builders.ProductBuilder;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.SupplierRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    /**
     * @param id
     * @return the productDto found based on the given id
     */
    public ProductDto findProductById(int id) {
        log.info("Entering the findProductById(id) method in ProductService...");

        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)
        );
        return ProductBuilder.toProductDto(product);
    }

    /**
     * @return a list of all the productDtos
     */
    public List<ProductDto> findProducts() {
        log.info("Entering the findProductById(id) method in ProductService...");

        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductBuilder::toProductDto)
                .collect(Collectors.toList());
    }

    /**
     * @param id
     * @return the deleted object based on the given id
     */
    public ProductDto deleteProductById(int id) {
        log.info("Entering the deleteProductById(id) method in ProductService...");

        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)
        );
        productRepository.delete(product);
        return ProductBuilder.toProductDto(product);
    }

    /**
     * @param productDto
     * @return the productDto based on the product added to the dabatase
     */
    public ProductDto addProduct(ProductDto productDto) {
        log.info("Entering the addProduct(productDto) method in ProductService...");

        ProductCategory productCategory = productCategoryRepository.findByName(productDto.getNameOfCategory());
        Supplier supplier = supplierRepository.findByName(productDto.getNameOfSupplier());
        Product product = ProductBuilder.toProductEntity(productDto);
        product.setProductCategory(productCategory);
        product.setSupplier(supplier);
        productRepository.save(product);
        return productDto;
    }

    /**
     * @param id                of the product we want to find in the db in order to be updated
     * @param updatedProductDto contains the new values for the product, if found
     * @return the productDto based on the updated product
     */
    public ProductDto updateProductById(int id, ProductDto updatedProductDto) {
        log.info("Entering the updateProductById(id, updatedProductDto) method in ProductService...");

        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)
        );
        ProductCategory productCategory = productCategoryRepository.findByName(updatedProductDto.getNameOfCategory());
        Supplier supplier = supplierRepository.findByName(updatedProductDto.getNameOfSupplier());
        product = ProductBuilder.toProductEntity(updatedProductDto);
        product.setProductCategory(productCategory);
        product.setSupplier(supplier);
        product.setId(id);
        productRepository.save(product);
        return ProductBuilder.toProductDto(product);
    }
}
