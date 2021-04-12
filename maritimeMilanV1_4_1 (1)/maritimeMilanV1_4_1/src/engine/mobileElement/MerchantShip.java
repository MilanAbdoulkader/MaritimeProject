package engine.mobileElement;

import engine.map.Block;

public class MerchantShip extends Ship {
	
	int storage; 
	/**
	 * 
	 * Merchant ship Constructor
	 * 
	 * @param storage Ships storage, helps transport bigger merchandise 
	 * @param name Name of the ship
	 * @param life Health points of the ship
	 * @param speed Speed of the ship (Changes travel time)
	 */
	public MerchantShip(String name, int life, int speed, int storage) {
		super(name, life, speed);
		this.storage=storage;
	}

}
