package ro.msg.learning.shop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.controllers.assemblers.ProductModelAssembler;
import ro.msg.learning.shop.dtos.ProductDto;
import ro.msg.learning.shop.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductModelAssembler productModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<ProductDto>> getProducts(){
        log.info("Entering the getProducts() method in ProductController...");
        List<EntityModel<ProductDto>> products = productService.findProducts().stream()
                .map(productDto -> productModelAssembler.toModel(productDto))
                .collect(Collectors.toList());
        return CollectionModel.of(products,
                linkTo(methodOn(ProductController.class).getProducts()).withSelfRel());
    }

    @GetMapping(value = "/{id}")
    public EntityModel<ProductDto> getProduct(@PathVariable("id") int productId){
        log.info("Entering the getProduct(id) method in ProductController...");
        ProductDto productDto = productService.findProductById(productId);
        return productModelAssembler.toModel(productDto);
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable("id") int productId){
        log.info("Entering the deleteProduct(id) method in ProductController...");
        ProductDto productDto = productService.deleteProductById(productId);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

    @PostMapping(value="/insert")
    public EntityModel<ProductDto> addProduct(@RequestBody ProductDto productDto){
        log.info("Entering the addProduct(productDto) method in ProductController...");
        ProductDto returnedProductDto = productService.addProduct(productDto);
        return productModelAssembler.toModel(returnedProductDto);
    }

    @PutMapping(value="/update/{id}")
    public EntityModel<ProductDto> updateProduct(@PathVariable("id") int productId, @RequestBody ProductDto updatedProductDto){
        log.info("Entering the updateProduct(productDto) method in ProductController...");
        ProductDto productDto = productService.updateProductById(productId, updatedProductDto);
        return productModelAssembler.toModel(productDto);
    }
}
