package engine.staticElement;


import engine.map.Block;

public class Harbor extends StaticElement {

	private String name;
	private boolean alignment;
	private Market marketPlace;
	private Workshop workshop;
	private Fort fort;
	private int id;

	
	/****
	 * 
	 * Harbor constructor
	 * 
	 * 
	 * 
	 * @param position Harbor's position
	 * @param name Harbor's name
	 * @param alignment Harbor's alignment (ALLY or ENEMY)
	 * @param id Harbors' id in HashMap
	 */
	public Harbor(Block position, String name, boolean alignment, int id) { //////////////// NOUVEAU
		super(position);
		this.id = id;
		this.name = name;
		this.alignment = alignment;
		marketPlace = new Market();
		workshop = new Workshop();
		fort = new Fort();
	}

	public Harbor(Block position, int id){
		super(position);
		this.id = id;
		this.name = "default";
		marketPlace = new Market();
		workshop = new Workshop();
		fort = new Fort();
	}

	public Harbor(Block position){
		super(position);
		this.id = 0;
		this.name = "default";
		marketPlace = new Market();
		workshop = new Workshop();
		fort = new Fort();
	}

	public boolean getAlignment() {
		return alignment;
	}

	public void setAlignment(boolean alignment) {
		this.alignment = alignment;
	}

	public Market getMarketPlace() {
		return marketPlace;
	}

	public void setMarketPlace(Market marketPlace) {
		this.marketPlace = marketPlace;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	public Fort getFort() {
		return fort;
	}

	public void setFort(Fort fort) {
		this.fort = fort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}