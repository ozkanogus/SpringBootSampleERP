package tr.com.erpsample.grocery.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import tr.com.erpsample.grocery.domain.Grocery;
import tr.com.erpsample.grocery.service.dto.GroceryDTO;

/**
 * Mapper for the entity {@link Grocery} and its DTO {@link GroceryDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GroceryMapper extends EntityMapper<GroceryDTO, Grocery> {
	@Named("id")
	@BeanMapping(ignoreByDefault = true)
	@Mapping(target = "id", source = "id")
	GroceryDTO toDtoId(Grocery grocery);
}
