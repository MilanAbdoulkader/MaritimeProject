package engine.mobileElement;

//import java.util.HashMap;


import engine.map.Block;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author nbant
 *
 */
public class Fleet {

	private HashMap<String, CombatShip> combatShips = new HashMap<String, CombatShip>();
	private HashMap<String, MerchantShip> merchantShips = new HashMap<String, MerchantShip>();
	private ArrayList<PirateShip> pirateShips = new ArrayList<PirateShip>();
	private Block position;
	private boolean alignment;
	private int number;
/**
 *
 * Creates an empty Fleet
 *
 * @param position Initial position of the Fleet
 * @param number Fleets ID, 
 * @param alignment Helps to determine whether the Fleet is an ally or an enemy
 * 
 */
	public Fleet(Block position, int number, boolean alignment) {
		this.alignment = alignment;
		this.number = number;
		this.position = position;
	}

	/**
	 * This constructor is here to create fleets that countains Piratships, it will use the ArrayList of pirateShips.
	 * They don't have initialized position, they will be set randomly later, around the seaways.
	 * @param number
	 * @param alignment
	 */
	public Fleet(int number, boolean alignment) {
		this.alignment = alignment;
		this.number = number;
	}
	
	
	
	
	/**
	 *
	 * @param ship Adds a merchant ship in the correct HashMap
	 *
	 */
	public void add(MerchantShip ship){
		this.merchantShips.put(ship.getName(),ship);
	}

	/**
	 *
	 * @param ship Adds a combat ship in the correct HashMap
	 *
	 */
	public void add(CombatShip ship){
		this.combatShips.put(ship.getName(),ship);
	}

	public HashMap<String,MerchantShip> getMerchantShips(){
		return this.merchantShips;
	}

	public HashMap<String,CombatShip> getCombatShips(){
		return this.combatShips;
	}

	public void setCombatShips(HashMap<String, CombatShip> combatShips) {
		this.combatShips = combatShips;
	}

	public void setMerchantShips(HashMap<String, MerchantShip> merchantShips) {
		this.merchantShips = merchantShips;
	}

	public ArrayList<PirateShip> getPirateShips() {
		return pirateShips;
	}

	public void setPirateShips(ArrayList<PirateShip> pirateShips) {
		this.pirateShips = pirateShips;
	}

	public boolean isAlignment() {
		return alignment;
	}

	public void setAlignment(boolean alignment) {
		this.alignment = alignment;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean getAlignement(){ //////////////////// NOUVEAU
		return this.alignment;
	}

	public int getNumber(){
		return this.number;
	}
	public Block getPosition(){
		return this.position;
	}
	public void setPosition(Block position){
		this.position=position;
	}
	public boolean isSetPosition(){
		return position == null;
	}

}

