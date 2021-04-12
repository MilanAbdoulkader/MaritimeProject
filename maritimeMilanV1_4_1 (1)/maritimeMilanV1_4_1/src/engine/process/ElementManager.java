package engine.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobileElement.CombatShip;
import engine.mobileElement.Fleet;
import engine.mobileElement.MerchantShip;
import engine.staticElement.Harbor;
import engine.staticElement.Land;
import engine.staticElement.Seaway;

public class ElementManager {
	private Map map;

	private List<Land> lands = new ArrayList<Land>();
	private List<CombatShip> combatShips = new ArrayList<CombatShip>();
	private List<MerchantShip> merchantShips = new ArrayList<MerchantShip>();

	private HashMap<Integer,ArrayList<Harbor>> harbors = new HashMap<Integer,ArrayList<Harbor>>();
	private HashMap<Integer,ArrayList<Seaway>> seaways = new HashMap<Integer, ArrayList<Seaway>>();

	private HashMap<Integer,Fleet> pirateFleets = new HashMap<Integer, Fleet>();
	private HashMap<Integer,Fleet> fleets = new HashMap<Integer, Fleet>();

/**
 * 
 * 
 * ElementManager constructor
 * 
 * 
 * 
 * @param map Our created map
 */
	public ElementManager(Map map) {
		this.map = map;
	}

	
	
	public List<Land> getLands() {
		return lands;
	}

	public void setLands(List<Land> lands) {
		this.lands = lands;
	}

	public HashMap<Integer,ArrayList<Harbor>> getHarbors() {
		return harbors;
	}

	public void setHarbors(HashMap<Integer,ArrayList<Harbor>> harbors) {
		this.harbors = harbors;
	}

	public List<CombatShip> getCombatShips() {
		return combatShips;
	}

	public void setCombatShips(List<CombatShip> combatShips) {
		this.combatShips = combatShips;
	}

	public List<MerchantShip> getMerchantShips() {
		return merchantShips;
	}

	public void setMerchantShips(List<MerchantShip> merchantShips) {
		this.merchantShips = merchantShips;
	}

	public HashMap<Integer, ArrayList<Seaway>> getSeaways() {
		return seaways;
	}

	public void setSeaways(HashMap<Integer, ArrayList<Seaway>> seaways) {
		this.seaways = seaways;
	}

	public HashMap<Integer, Fleet> getFleets() {
		return fleets;
	}

	public void setFleets(HashMap<Integer, Fleet> fleets) {
		this.fleets = fleets;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Map getMap() {
		return map;
	}

	public HashMap<Integer, Fleet> getPirateFleets() {
		return pirateFleets;
	}

	public void setPirateFleets(HashMap<Integer, Fleet> pirateFleets) {
		this.pirateFleets = pirateFleets;
	}


	/**
	 *
	 *
	 *Allows our ship to follow the indicated path
	 *
	 *
	 *
	 * @param seawayKey Represents the key of a Seaway in our Hash Map
	 * @param index Used in our thread to , starts at 0
	 */
	public void followSeaway(int seawayKey, int index){
		if( index + 1 < seaways.get(seawayKey).size()) {
			Block fleetNewPosition = seaways.get(seawayKey).get(index).getPosition() ;
			fleets.get(1).setPosition(fleetNewPosition);

		}
		else {
			GameConfiguration.wayForward = false;
		}

	}

	/**
	 *
	 *
	 *Allows our ship to follow the indicated path
	 *
	 *
	 *
	 * @param seawayKey Represents the key of a Seaway in our Hash Map
	 * @param index Used in our thread to , starts at last index of seaway
	 */
	public void followReturnSeaway(int seawayKey, int index, int cptsize){
		if(cptsize <= seaways.get(seawayKey).size()) {
			Block fleetNewPosition = seaways.get(seawayKey).get(index).getPosition() ;
			fleets.get(1).setPosition(fleetNewPosition);
		}
		else {
			GameConfiguration.wayBack = false;
			System.out.println("STOPPINGTRDYCTFVUYGJBKUHIJLNK?MOMLKBHUGJVYHFCGDX");
		}
	}

/**
 * 
 * Simple check to see if a certain Block is a land
 * 
 *
 * @param x Column coordinate
 * @param y Row coordinate
 * @return boolean value
 */
	public boolean isLand( int x, int y){
		for(Land land : lands){
			if (land.getPosition().getRow()==y && land.getPosition().getColumn()==x){
				return false;
			}
		}
		return true;
	}

	public void setPirateFleetsPosition(){
		Block position1 = new Block(1,1);
		Block position2 = new Block(2,2);
		Block position3 = new Block(3,3);
		Block position4 = new Block(4,4);
		Block position5 = new Block(5,5);
		for(int i = 0 ; i < GameConfiguration.PIRATE_FLEET_COUNT ; i++){
			pirateFleets.get(i).setPosition(position1);
		}
	}
/**
 * 
 * 
 * 
 * Simple check to see if a certain Block is a land
 * 
 * 
 * @param x Column coordinate
 * @param y Row coordinate
 * @return boolean value
 * 
 */
	public boolean isHarbor(int x, int y){
		for (int harborCount = 1 ; harborCount<= GameConfiguration.HARBOR_COUNT ; harborCount++) {
			for (Harbor part : harbors.get(harborCount)) {
				if (part.getPosition().getRow() == y && part.getPosition().getColumn()==x){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * Simple check to see if a certain Block is a land
	 * 
	 * 
	 * @param x Column coordinate
	 * @param y Row coordinate
	 * @return boolean value
	 */
	public boolean isFleet(int x, int y){
		for (int fleetCount = 1 ; fleetCount<= GameConfiguration.FLEET_COUNT ; fleetCount++) {
			if (fleets.get(fleetCount).getPosition().getRow() == y && fleets.get(fleetCount).getPosition().getColumn()==x){
				return true;
			}
		}
		return false;
	}

	
	
	/**
	 * 
	 *  When clicking on a Harbor fins its ID thanks to the coordinates
	 * 
	 * 
	 * @param x Harbors column coordinate
	 * @param y Harbors row coordinate
	 * @return
	 */
	public int harborId(int x, int y){
		for (int harborCount = 1 ; harborCount<= GameConfiguration.HARBOR_COUNT ; harborCount++) {
			for (Harbor part : harbors.get(harborCount)) {
				if (part.getPosition().getRow() == y && part.getPosition().getColumn()==x){
					return part.getId();
				}
			}
		}
		return 0;
	}

	public String harborName(int x, int y){
		for (int harborCount = 1 ; harborCount<= GameConfiguration.HARBOR_COUNT ; harborCount++) {
			for (Harbor part : harbors.get(harborCount)) {
				if (part.getPosition().getRow() == y && part.getPosition().getColumn()==x){
					return part.getName();
				}
			}
		}
		return "no_name";
	}

	
	public boolean isHarborAlly(int x, int y){
		for (int harborCount = 1 ; harborCount<= GameConfiguration.HARBOR_COUNT ; harborCount++) {
			for (Harbor part : harbors.get(harborCount)) {
				if (part.getPosition().getRow() == y && part.getPosition().getColumn()==x){
					return part.getAlignment();
				}
			}
		}
		return false;
	}
	/**
	 *
	 * Handles Fleet's movement
	 *
	 */
	public void moveDownShip() {
		Block position = fleets.get(GameConfiguration.FLEET_TWO).getPosition();

		if(position.getRow() >= 0 && position.getRow()<=GameConfiguration.ROW_COUNT && !isHarbor(position.getColumn() , position.getRow()+1) && isLand(position.getColumn(), position.getRow() + 1)) {
			Block newPosition = map.getBlock(position.getRow() +1 , position.getColumn());
			fleets.get(GameConfiguration.FLEET_TWO).setPosition(newPosition);
		}

	}
	/**
	 *
	 * Handles Fleet's movement
	 *
	 */
	public void moveLeftShip() {
		Block position = fleets.get(GameConfiguration.FLEET_TWO).getPosition();

		if (position.getColumn() > 0 && !isHarbor(position.getColumn()-1 , position.getRow()) && isLand(position.getColumn() - 1, position.getRow())) {
			Block newPosition = map.getBlock(position.getRow(), position.getColumn() - 1);
			fleets.get(GameConfiguration.FLEET_TWO).setPosition(newPosition);
		}
	}
	/**
	 *
	 * Handles Fleet's movement
	 *
	 */
	public void moveUpShip() {
		Block position = fleets.get(GameConfiguration.FLEET_TWO).getPosition();

		if(position.getRow() <= GameConfiguration.ROW_COUNT -1 && !isHarbor(position.getColumn() , position.getRow()-1) && isLand(position.getColumn(), position.getRow() - 1)) {
			Block newPosition = map.getBlock(position.getRow() -1 , position.getColumn());
			fleets.get(GameConfiguration.FLEET_TWO).setPosition(newPosition);
		}

	}
	/**
	 *
	 * Handles Fleet's movement
	 *
	 */

	public void moveRightShip() {
		Block position = fleets.get(GameConfiguration.FLEET_TWO).getPosition();
		if (position.getColumn() < GameConfiguration.COLUMN_COUNT + 1 && !isHarbor(position.getColumn()+1 , position.getRow()) && isLand(position.getColumn() + 1, position.getRow())) {
			Block newPosition = map.getBlock(position.getRow(), position.getColumn() + 1 );
			fleets.get(GameConfiguration.FLEET_TWO).setPosition(newPosition);

		}

	}

}
