package engine.mobileElement;

import engine.map.Block;
/**
 * 
 * Creats a combat ship with specific stats
 * 
 * 
 * @author nbant
 *
 */
public class CombatShip extends Ship {
	
	private int attack;

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param name Name of the ship
	 * @param life Health points of the ship
	 * @param speed Speed of the ship (Changes travel time)
	 * @param attack Attack points of the ship
	 */
	public CombatShip(String name, int life, int speed, int attack) {
		super(name , life, speed);
		this.attack= 40;
	}

	public CombatShip(int life, int speed, int attack) {
		super(life, speed);
		this.attack=attack;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	
}
