package tr.com.erpsample.grocery.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.erpsample.grocery.domain.Purchase;
import tr.com.erpsample.grocery.domain.PurchaseProduct;
import tr.com.erpsample.grocery.domain.enumeration.OperationType;
import tr.com.erpsample.grocery.repository.ProductRepository;
import tr.com.erpsample.grocery.repository.PurchaseRepository;
import tr.com.erpsample.grocery.service.dto.PurchaseDTO;
import tr.com.erpsample.grocery.service.mapper.PurchaseMapper;

/**
 * Service Implementation for managing {@link Purchase}.
 */
@Service
@Transactional
public class PurchaseService {

	private final PurchaseRepository purchaseRepository;

	private final PurchaseMapper purchaseMapper;

	private final ProductRepository productRepository;

	private StockMovementService stockMovementService;

	public PurchaseService(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper,
			ProductRepository productRepository, StockMovementService stockMovementService) {
		this.purchaseRepository = purchaseRepository;
		this.purchaseMapper = purchaseMapper;
		this.productRepository = productRepository;
		this.stockMovementService = stockMovementService;
	}

	/**
	 * Save a purchase.
	 *
	 * @param purchaseDTO the entity to save.
	 * @return the persisted entity.
	 */
	public PurchaseDTO save(PurchaseDTO purchaseDTO) {
		Purchase purchase = purchaseMapper.toEntity(purchaseDTO);
		final Set<PurchaseProduct> products = purchaseDTO.getProducts().stream()
				.map(product -> new PurchaseProduct()
						.product(productRepository.findById(product.getProductId()).orElse(null))
						.count(product.getCount()).price(product.getPrice()))
				.collect(Collectors.toSet());
		purchase.setProducts(products);
		Purchase purchaseSaved = purchaseRepository.save(purchase);
		// StockMovement
		stockMovementService.updateStockMovement(OperationType.PURCHASE, purchaseSaved);
		//
		return purchaseMapper.toDto(purchaseSaved);
	}

	/**
	 * Get all the purchases.
	 *
	 * @return the list of entities.
	 */
	@Transactional(readOnly = true)
	public List<PurchaseDTO> findAll() {
		return purchaseRepository.findAll().stream().map(purchaseMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one purchase by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	@Transactional(readOnly = true)
	public Optional<PurchaseDTO> findOne(Long id) {
		return purchaseRepository.findById(id).map(purchaseMapper::toDto);
	}

	/**
	 * Delete the purchase by id.
	 *
	 * @param id the id of the entity.
	 */
	public void delete(Long id) {
		// StockMovement
		stockMovementService.deleteByOperationId(id);
		//
		purchaseRepository.deleteById(id);
	}
}
