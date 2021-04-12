package engine.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import config.GameConfiguration;
import engine.staticElement.Resource;

public class Player {
	
	public int goldCounter = 100;
	private HashMap<String,ArrayList<Resource>> resources = new HashMap<String,ArrayList<Resource>>();

	
	public Player(HashMap<String, ArrayList<Resource>> resources) {
		this.resources = resources;
	}
	
	public Player() {
		
	}
	
	/*public HashMap<Integer,Fleet> getFleets() {
		return fleets;
	}*/
	
	public HashMap<String,ArrayList<Resource>> getResources() {
		return resources;
	}
	
	public void setRessources(HashMap<String,ArrayList<Resource>> resources) {
		this.resources = resources;
	}

	public int getGoldCounter() {
		return goldCounter;
	}

	public void setGoldCounter(int goldCounter) {
		this.goldCounter = goldCounter;
	}

	public void buy(int amount){
		System.out.println("salut");
		 goldCounter -= amount;
	}

	public void sell(int amount){
		goldCounter += amount;
	}
	
	public String resourceName(int amount){
		for (int index = 1 ; index <= 11 ; index++) {
			for (Resource resource : resources.get(index)) {
				if (resource.getPurchaseValue()==amount){
					return resource.getName();
				}
			}			
		}
		return "no_name";
	}
	
	public int resourcePrice(String name){
		System.out.println(resources.get(GameConfiguration.COFFEE));

		for (int index = 0 ; index <= 9 ; index++) {
			for (Resource resource : resources.get(GameConfiguration.RESOURCES[index])) {
				if (resource.getName().equals(name)){
					System.out.println(resource.getPurchaseValue());
					return resource.getPurchaseValue();
				}
			}
		}
		
		return 0;
	}
}
