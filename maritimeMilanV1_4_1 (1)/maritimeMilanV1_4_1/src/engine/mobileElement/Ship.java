package engine.mobileElement;

import config.GameConfiguration;
/**
 * 
 * Defines and implements abstract methods 
 * 
 * @author nbant
 *
 */
public abstract class Ship{

	private String name;
	private int life;
	private int speed;

	public Ship(String name, int life, int speed) {

		this.name=name;
		this.life=life;
		this.speed=speed;
	}

	/**
	 * Constructor for PirateShip, they dont need a specific name. It will be chosen at random.
	 * @param name
	 * @param life
	 * @param speed
	 */
	public Ship(int life, int speed) {
		int index = (int)(Math.random()*5);
		this.name= GameConfiguration.PIRATE_NAMES[index];
		this.life=life;
		this.speed=speed;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
}
