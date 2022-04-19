package tr.com.erpsample.grocery.domain.enumeration;

public enum OperationType {
	PURCHASE("Purchase"),
	SALE("Sale"),
	INVENTORY("Inventory"),
	GARBAGE("Garbage");
	

	private String name;
	
	private OperationType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


}
