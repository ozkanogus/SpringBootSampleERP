package tr.com.erpsample.grocery.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SaleProductId implements Serializable {

	@Column(name = "sale_id")
	private Long saleId;

	@Column(name = "product_id")
	private Long productId;

	public SaleProductId() {
	}

	public SaleProductId(Long saleId, Long productId) {
		this.saleId = saleId;
		this.productId = productId;
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SaleProductId that = (SaleProductId) o;
		return Objects.equals(saleId, that.saleId) && Objects.equals(productId, that.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(saleId, productId);
	}

	@Override
	public String toString() {
		return "SaleProductId{" + "saleId=" + saleId + ", productId=" + productId + '}';
	}
}
