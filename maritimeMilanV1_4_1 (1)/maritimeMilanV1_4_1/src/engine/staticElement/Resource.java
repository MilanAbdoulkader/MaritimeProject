package engine.staticElement;

public class Resource {
	
	private String name;
	private int quantity;
	private int purchaseValue ;
	/**
	 * @param name
	 * @param quantity
	 * @param purchaseValue
	 */
	public Resource(int purchaseValue) {

		this.purchaseValue = purchaseValue;
	}
	
	public Resource(String name, int purchaseValue) {
		this.name = name;
		this.purchaseValue = purchaseValue;
	}
	
	public Resource(String name, int quantity, int purchaseValue) {
		this.setName(name);
		this.setQuantity(quantity);
		this.setPurchaseValue(purchaseValue);
	}
	
	public int getPurchaseValue() {
		return purchaseValue;
	}
	public void setPurchaseValue(int purchaseValue) {
		this.purchaseValue = purchaseValue;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
