package tr.com.erpsample.grocery.service.mapper;

import org.mapstruct.Mapper;

import tr.com.erpsample.grocery.domain.Product;
import tr.com.erpsample.grocery.service.dto.ProductDTO;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
}
