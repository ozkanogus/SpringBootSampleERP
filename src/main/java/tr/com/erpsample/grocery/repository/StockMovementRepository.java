package tr.com.erpsample.grocery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.erpsample.grocery.domain.StockMovement;
import tr.com.erpsample.grocery.domain.enumeration.OperationType;

@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
	Optional<StockMovement> findByOperationIdAndProductIdAndOperationType(Long oparationId, Long productId,
			OperationType operationType);

	void deleteByOperationId(Long id);
}
