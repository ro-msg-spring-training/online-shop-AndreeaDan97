package ro.msg.learning.shop.controllers.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.controllers.ProductController;
import ro.msg.learning.shop.dtos.ProductDto;
import ro.msg.learning.shop.entities.Product;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<ProductDto, EntityModel<ProductDto>>{

    @Override
    public EntityModel<ProductDto> toModel(ProductDto entity) {
        return  EntityModel.of(entity,
                linkTo(methodOn(ProductController.class).getProduct(entity.getId())).withSelfRel());
    }
}
