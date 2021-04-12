package engine.mobileElement;

import engine.map.Block;

public class PirateShip extends CombatShip{
	private int gold ;


	/**
	 * Pirate Ship constructor
	 * @param life
	 * @param speed
	 * @param attack
	 */
	public PirateShip(int life, int speed, int attack) {
		super(life, speed, attack);
		this.gold = 1000;
	}
}
