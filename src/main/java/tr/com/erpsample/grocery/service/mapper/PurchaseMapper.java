package tr.com.erpsample.grocery.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tr.com.erpsample.grocery.domain.Purchase;
import tr.com.erpsample.grocery.domain.PurchaseProduct;
import tr.com.erpsample.grocery.service.dto.ProductSalePurchaseDTO;
import tr.com.erpsample.grocery.service.dto.PurchaseDTO;

/**
 * Mapper for the entity {@link Purchase} and its DTO {@link PurchaseDTO}.
 */
@Mapper(componentModel = "spring", uses = { GroceryMapper.class })
public interface PurchaseMapper extends EntityMapper<PurchaseDTO, Purchase> {

	@Mapping(target = "products", ignore = true)
	@Mapping(target = "removeProduct", ignore = true)
	Purchase toEntity(PurchaseDTO dto);

	@Mapping(target = "grocery", source = "grocery", qualifiedByName = "id")
	PurchaseDTO toDto(Purchase s);

	@Mapping(target = "productId", source = "product.id")
	ProductSalePurchaseDTO map(PurchaseProduct purchaseProduct);

}
