package tr.com.erpsample.grocery.service.mapper;

import org.mapstruct.Mapper;

import tr.com.erpsample.grocery.domain.StockMovement;
import tr.com.erpsample.grocery.service.dto.StockMovementDTO;

/**
 * Mapper for the entity {@link StockMovement} and its DTO
 * {@link StockMovementDTO}.
 */
@Mapper(componentModel = "spring")
public interface StockMovementMapper extends EntityMapper<StockMovementDTO, StockMovement> {
}
