package tr.com.erpsample.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.erpsample.grocery.domain.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
