package engine.process;

import config.GameConfiguration;

import engine.map.Block;
import engine.map.Map;
import engine.mobileElement.*;
import engine.staticElement.*;

import java.util.ArrayList;


/**
 * 
 * This is where all our eleme,ts will be created
 * 
 * 
 * 
 * @author nbant
 *
 */
public class Gamebuilder {
/**
 * Creates a new map with coordinates specified in the GameConfiguration class
 * 
 * 
 * 
 * @return
 */
    public static Map buildMap() {
        return new Map(GameConfiguration.ROW_COUNT, GameConfiguration.COLUMN_COUNT);
    }
/**
 * 
 * Initialzes different elements on the map
 *
 * @param map
 * @return
 */
    public static ElementManager buildElements(Map map){
        ElementManager manager = new ElementManager(map);


        initializeFleet(map, manager, GameConfiguration.FLEET_ONE, GameConfiguration.BEGIN_FlEET_ROW , GameConfiguration.BEGIN_FLEET_COLUMN);

        initializeFleet(map, manager, GameConfiguration.FLEET_TWO,GameConfiguration.BEGIN_FlEET_ROW+5 , GameConfiguration.BEGIN_FLEET_COLUMN+5); //TEST

        initializeAllPirateFleets(map, manager);

        initializeHarbors(map, manager);

        initializeSeaways(map, manager);

        initializeIsle(map, manager);

        return manager;
    }

    public static Player buildResources(){
        Player player = new Player();

        initializeResources(player);

        return player;
    }

/**
 * 
 * Temporary initializes a Fleet
 * 
 * @param map
 * @param manager
 * @param fleetNumber
 * @param row
 * @param column
 */
    private static void initializeFleet(Map map, ElementManager manager, int fleetNumber, int row, int column){
        Block block = map.getBlock(row, column);
        Fleet fleet = new Fleet(block,fleetNumber,GameConfiguration.ALLY);
        manager.getFleets().put(fleetNumber , fleet);
    }

    private static void initializeResource(Player player, String name, int price) {
        ArrayList<Resource> resources = new ArrayList<Resource>();
        Resource res = new Resource(name,price);
        resources.add(res);
        player.getResources().put(name, resources);
    }

    /**
     * Each Pirate Fleet is initialized with 3 PirateShip and are added to the manager They will later on be randomly put on the map.
     * Each PirateShip has Base statistic of 500 life, 6 speed, and 50 attack.
     * @param map
     * @param manager
     * @param fleetNumber
     */
    private static void initializePirateFleet(Map map, ElementManager manager, int fleetNumber){
        PirateShip pirateShip_one = new PirateShip(500, 6,50);
        PirateShip pirateShip_two = new PirateShip(500, 6,50);
        PirateShip pirateShip_three = new PirateShip(500, 6,50);
        Fleet pirateFleet = new Fleet(fleetNumber,!GameConfiguration.ALLY);

        pirateFleet.getPirateShips().add(pirateShip_one);
        pirateFleet.getPirateShips().add(pirateShip_two);
        pirateFleet.getPirateShips().add(pirateShip_three);

        manager.getPirateFleets().put(fleetNumber, pirateFleet);

    }

    /**
     * Use method InitializePirateFleet to initialize all the pirateFleets that will be needed to play the game.
     *
     * @param map
     * @param manager
     */
    private static void initializeAllPirateFleets(Map map, ElementManager manager){
        for (int i = 0 ; i<GameConfiguration.PIRATE_FLEET_COUNT ; i++) {
            initializePirateFleet(map, manager, i);
        }
    }


    
    /**
     * 
     * 
     * 
     *
     * @param map Our map
     * @param manager Our manager
     * @param name Harbor's name
     * @param id Harbor's ID
     * @param startingrow Harbor's starting point
     * @param finishingrow Harbor's finishing point
     * @param startingcolumn Harbor's starting point
     * @param finishingcolumn Harbor's finishing point
     * @param alignment Harbor's hostility(or lack thereof)
     */
    private static void initializeHarbor(Map map, ElementManager manager,String name,int id, int startingrow, int finishingrow,  int startingcolumn, int finishingcolumn, boolean alignment){
        ArrayList<Harbor> harbor = new ArrayList<Harbor>();
        for (int i = startingrow; i <finishingrow; i++) {
            for (int j = startingcolumn; j < finishingcolumn; j++) {
                Block block = map.getBlock(i, j);
                Harbor patch = new Harbor(block, name ,alignment, id);
                harbor.add(patch);
            }
        }
        manager.getHarbors().put(id, harbor);
    }

/**
 * 
 * 
 * 
 * @param map Our map
 * @param manager Our manager
 * @param key Seaway's unique ID
 * @param rows array of coordinates
 * @param columns array of coordinates
 */
    private static void initializeSeaway(Map map, ElementManager manager, int key, int [] rows , int [] columns){
        int columnsIndex = 0;
        ArrayList<Seaway> seaway = new ArrayList<Seaway>();
        for (int row: rows) {
            Block block = map.getBlock(row, columns[columnsIndex]);
            Seaway patch = new Seaway(block);
            seaway.add(patch);
            columnsIndex++;
        }
        manager.getSeaways().put(key, seaway);
    }


    /**
     *Creates a rectangle
     *
     *
     * @param map
     * @param manager
     * @param columnLength
     * @param rowLength
     * @param column
     * @param row
     */
    private static void initializeLand(Map map, ElementManager manager,int columnLength, int rowLength, int[] column, int[] row){
        for (int i = 0; i <rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                Block block = map.getBlock(row[i], column[j]);
                Land land = new Land(block);
                manager.getLands().add(land);
            }
        }
    }

    /**
     *
     * Cr�e la forme de cette allure :
     *
     *
     * 								*******
     * 								 ******
     * 								  *****
     * 								   ****
     * 							        ***
     * 								     **
     * 								      *
     *
     *
     *
     * @param map
     * @param manager
     * @param startingcolumn DOIT ETRE INFERIEUR A FINISHING COLUMN
     * @param finishingcolumn DOIT ETRE SUPERIEUR A STATRING COLUMN
     * @param startingrow DOIT ETRE IFERIEUR A FINISHINGROW
     * @param finishingrow DOIT ETRE SUPERIEUR A STARTINGROW
     */

    private static void initializeLandReverseUpStair(Map map, ElementManager manager,int startingcolumn, int finishingcolumn, int startingrow, int finishingrow){
        for(int i = startingrow; i <= finishingrow; i++) {
            for(int j= startingcolumn; j <= finishingcolumn; j++){
                Block block = map.getBlock(i, j);
                Land land = new Land(block);
                manager.getLands().add(land);
            }
            startingcolumn++;
        }
    }


    /**
     *
     *  Cr�e la forme de cette allure :
     *
     * 								     *
     * 									**
     * 							       ***
     * 								  ****
     * 							     *****
     * 								******
     * 							   *******
     *                            ********
     *
     *
     *
     * @param map
     * @param manager
     * @param startingcolumn DOIT ETRE INFERIEUR A FINISHING COLUMN
     * @param finishingcolumn DOIT ETRE SUPERIEUR A STARTING COLUMN
     * @param startingrow DOIT ETRE SUPERIEUR A FINISHINGROW
     * @param finishingrow DOIT ETRE INFERIEUR A STARTINGROW
     */
    private static void initializeLandUpStair(Map map, ElementManager manager,int startingcolumn, int finishingcolumn, int startingrow, int finishingrow){
        for(int i = startingrow; i >= finishingrow; i--) {
            for(int j= startingcolumn; j <= finishingcolumn; j++){
                Block block = map.getBlock(i, j);
                Land land = new Land(block);
                manager.getLands().add(land);
            }
            startingcolumn++;
        }
    }

    /**
     * Cr�e la forme de cette allure :
     *
     *
     * 								*
     * 								**
     * 								***
     * 								****
     * 								*****
     * 								******
     * 								*******
     * 								********
     *
     *
     *
     *
     * @param map
     * @param manager
     * @param startingcolumn DOIT ETRE SUPERIEUR A FINISHINGCOLUMN
     * @param finishingcolumn DOIT ETRE INFERIEUR A STARTINGCOLUMN
     * @param startingrow DOIT ETRE SUPERIEUR A FINISHINGROW
     * @param finishingrow DOIT ETRE INFERIEUR A STARTINGROW
     */
    private static void initializeLandDownStair(Map map, ElementManager manager, int startingcolumn,int finishingcolumn, int startingrow, int finishingrow){
        for(int i = startingrow; i >= finishingrow; i--) {
            for(int j= startingcolumn; j >= finishingcolumn; j--){
                Block block = map.getBlock(i, j);
                Land land = new Land(block);
                manager.getLands().add(land);
            }
            startingcolumn--;
        }
    }

    /**
     *
     * Cr�e la forme de cette allure :
     *
     *
     * 								***********
     * 								**********
     * 								*********
     *                              ********
     *                              *******
     *                              ******
     *                              *****
     *                              ****
     *                              ***
     *                              **
     *                              *
     *
     * @param map
     * @param manager
     * @param startingcolumn DOIT ETRE SUPERIEUR A FINISHINGCOLUMN
     * @param finishingcolumn 
     * @param startingrow DOIT ETRE SUPERIEUR A FINISHINGROW
     * @param finishingrow
     */
    private static void initializeLandReverseDownStair(Map map, ElementManager manager, int startingcolumn, int finishingcolumn, int startingrow, int finishingrow){
        for(int i = startingrow; i >= finishingrow; i--) {
            for(int j= startingcolumn; j >= finishingcolumn; j--){
                Block block = map.getBlock(i, j);
                Land land = new Land(block);
                manager.getLands().add(land);
            }
            startingcolumn++;
        }
    }

    
    
    

    
    
    
    /**
     * 
     * Initializes all our Islands
     * 
     * 
     * 
     * 
     * @param map Our maps
     * @param manager Our manager
     */
    private static void initializeIsle(Map map, ElementManager manager) {

        // ISLAND 1
        initializeLand(map, manager, GameConfiguration.LAND1_COLUMN.length, GameConfiguration.LAND1_ROW.length , GameConfiguration.LAND1_COLUMN, GameConfiguration.LAND1_ROW );   
        initializeLand(map, manager, GameConfiguration.LAND1Point1_COLUMN.length, GameConfiguration.LAND1Point1_ROW.length , GameConfiguration.LAND1Point1_COLUMN, GameConfiguration.LAND1Point1_ROW );
        initializeLand(map, manager, GameConfiguration.LAND1Point2_COLUMN.length, GameConfiguration.LAND1Point2_ROW.length , GameConfiguration.LAND1Point2_COLUMN, GameConfiguration.LAND1Point2_ROW );
        initializeLand(map, manager, GameConfiguration.LAND1Point3_COLUMN.length, GameConfiguration.LAND1Point3_ROW.length , GameConfiguration.LAND1Point3_COLUMN, GameConfiguration.LAND1Point3_ROW );
        initializeLand(map, manager, GameConfiguration.LAND1Point4_COLUMN.length, GameConfiguration.LAND1Point4_ROW.length , GameConfiguration.LAND1Point4_COLUMN, GameConfiguration.LAND1Point4_ROW );
        initializeLand(map, manager, GameConfiguration.LAND1Point4_COLUMN.length, GameConfiguration.LAND1Point4_ROW.length , GameConfiguration.LAND1Point4_COLUMN, GameConfiguration.LAND1Point4_ROW );


        //ISLAND 2


        initializeLandDownStair(map, manager, GameConfiguration.ISLAND2_STARTING_COLUMN, GameConfiguration.ISLAND2_FINISHING_COLUMN,GameConfiguration.ISLAND2_STARTING_ROW , GameConfiguration.ISLAND2_FINISHING_ROW);


        //ISLAND 3

        initializeLandReverseDownStair(map, manager,GameConfiguration.ISLAND3_STARTING_COLUMN,GameConfiguration.ISLAND3_FINISHING_COLUMN,GameConfiguration.ISLAND3_STARTING_ROW,GameConfiguration.ISLAND3_FINISHING_ROW);
        initializeLand(map, manager, GameConfiguration.ISLAND3Point1_COLUMN.length, GameConfiguration.ISLAND3Point1_ROW.length , GameConfiguration.ISLAND3Point1_COLUMN, GameConfiguration.ISLAND3Point1_ROW );   
        
        
        //ISLAND 4

        initializeLandUpStair(map, manager,GameConfiguration.ISLAND4_STARTING_COLUMN,GameConfiguration.ISLAND4_FINISHING_COLUMN,GameConfiguration.ISLAND4_STARTING_ROW,GameConfiguration.ISLAND4_FINISHING_ROW);

        //ISLAND 5

        initializeLandReverseUpStair(map, manager,GameConfiguration.ISLAND5_STARTING_COLUMN,GameConfiguration.ISLAND5_FINISHING_COLUMN,GameConfiguration.ISLAND5_STARTING_ROW,GameConfiguration.ISLAND5_FINISHING_ROW);
        initializeLandReverseDownStair(map, manager,GameConfiguration.ISLAND5Point1_STARTING_COLUMN,GameConfiguration.ISLAND5Point1_FINISHING_COLUMN,GameConfiguration.ISLAND5Point1_STARTING_ROW,GameConfiguration.ISLAND5Point1_FINISHING_ROW);

        // ISLAND 6

        initializeLandReverseUpStair(map, manager,GameConfiguration.ISLAND6_STARTING_COLUMN,GameConfiguration.ISLAND6_FINISHING_COLUMN,GameConfiguration.ISLAND6_STARTING_ROW,GameConfiguration.ISLAND6_FINISHING_ROW);
        initializeLand(map, manager, GameConfiguration.ISLAND6_POINT1_COLUMN.length, GameConfiguration.ISLAND6_POINT1_ROW.length , GameConfiguration.ISLAND6_POINT1_COLUMN, GameConfiguration.ISLAND6_POINT1_ROW );   
        initializeLand(map, manager, GameConfiguration.ISLAND6_POINT2_COLUMN.length, GameConfiguration.ISLAND6_POINT2_ROW.length , GameConfiguration.ISLAND6_POINT2_COLUMN, GameConfiguration.ISLAND6_POINT2_ROW );
        
        
        
        //ISLAND 7
        
       // initializeLandUpStair(map, manager,GameConfiguration.ISLAND7_STARTING_COLUMN,GameConfiguration.ISLAND7_FINISHING_COLUMN,GameConfiguration.ISLAND7_STARTING_ROW,GameConfiguration.ISLAND7_FINISHING_ROW);
        
       // initializeLandReverseDownStair(map, manager,GameConfiguration.ISLAND7point1_STARTING_COLUMN,GameConfiguration.ISLAND7point1_FINISHING_COLUMN,GameConfiguration.ISLAND7point1_STARTING_ROW,GameConfiguration.ISLAND7point1_FINISHING_ROW);
        
       
        
        
        
        initializeLand(map, manager, GameConfiguration.ISLAND7_BPOINT000_COLUMN.length, GameConfiguration.ISLAND7_BPOINT000_ROW.length , GameConfiguration.ISLAND7_BPOINT000_COLUMN, GameConfiguration.ISLAND7_BPOINT000_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_BPOINT00_COLUMN.length, GameConfiguration.ISLAND7_BPOINT00_ROW.length , GameConfiguration.ISLAND7_BPOINT00_COLUMN, GameConfiguration.ISLAND7_BPOINT00_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_BPOINT0_COLUMN.length, GameConfiguration.ISLAND7_BPOINT0_ROW.length , GameConfiguration.ISLAND7_BPOINT0_COLUMN, GameConfiguration.ISLAND7_BPOINT0_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_BPOINT1_COLUMN.length, GameConfiguration.ISLAND7_BPOINT1_ROW.length , GameConfiguration.ISLAND7_BPOINT1_COLUMN, GameConfiguration.ISLAND7_BPOINT1_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_BPOINT2_COLUMN.length, GameConfiguration.ISLAND7_BPOINT2_ROW.length , GameConfiguration.ISLAND7_BPOINT2_COLUMN, GameConfiguration.ISLAND7_BPOINT2_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_BPOINT3_COLUMN.length, GameConfiguration.ISLAND7_BPOINT3_ROW.length , GameConfiguration.ISLAND7_BPOINT3_COLUMN, GameConfiguration.ISLAND7_BPOINT3_ROW );
        
        
        
        
        initializeLand(map, manager, GameConfiguration.ISLAND7_TPOINT1_COLUMN.length, GameConfiguration.ISLAND7_TPOINT1_ROW.length , GameConfiguration.ISLAND7_TPOINT1_COLUMN, GameConfiguration.ISLAND7_TPOINT1_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_TPOINT2_COLUMN.length, GameConfiguration.ISLAND7_TPOINT2_ROW.length , GameConfiguration.ISLAND7_TPOINT2_COLUMN, GameConfiguration.ISLAND7_TPOINT2_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_TPOINT3_COLUMN.length, GameConfiguration.ISLAND7_TPOINT3_ROW.length , GameConfiguration.ISLAND7_TPOINT3_COLUMN, GameConfiguration.ISLAND7_TPOINT3_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_TPOINT4_COLUMN.length, GameConfiguration.ISLAND7_TPOINT4_ROW.length , GameConfiguration.ISLAND7_TPOINT4_COLUMN, GameConfiguration.ISLAND7_TPOINT4_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_TPOINT5_COLUMN.length, GameConfiguration.ISLAND7_TPOINT5_ROW.length , GameConfiguration.ISLAND7_TPOINT5_COLUMN, GameConfiguration.ISLAND7_TPOINT5_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_TPOINT6_COLUMN.length, GameConfiguration.ISLAND7_TPOINT6_ROW.length , GameConfiguration.ISLAND7_TPOINT6_COLUMN, GameConfiguration.ISLAND7_TPOINT6_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND7_TPOINT7_COLUMN.length, GameConfiguration.ISLAND7_TPOINT7_ROW.length , GameConfiguration.ISLAND7_TPOINT7_COLUMN, GameConfiguration.ISLAND7_TPOINT7_ROW );
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //ISLAND 8
        
        //initializeLand(map, manager, GameConfiguration.ISLAND8_COLUMN.length, GameConfiguration.ISLAND8_ROW.length , GameConfiguration.ISLAND8_COLUMN, GameConfiguration.ISLAND8_ROW );
        
        // LEFT SIDE
        
        initializeLand(map, manager, GameConfiguration.ISLAND8_LPOINT1_COLUMN.length, GameConfiguration.ISLAND8_LPOINT1_ROW.length , GameConfiguration.ISLAND8_LPOINT1_COLUMN, GameConfiguration.ISLAND8_LPOINT1_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_LPOINT2_COLUMN.length, GameConfiguration.ISLAND8_LPOINT2_ROW.length , GameConfiguration.ISLAND8_LPOINT2_COLUMN, GameConfiguration.ISLAND8_LPOINT2_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_LPOINT3_COLUMN.length, GameConfiguration.ISLAND8_LPOINT3_ROW.length , GameConfiguration.ISLAND8_LPOINT3_COLUMN, GameConfiguration.ISLAND8_LPOINT3_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_LPOINT4_COLUMN.length, GameConfiguration.ISLAND8_LPOINT4_ROW.length , GameConfiguration.ISLAND8_LPOINT4_COLUMN, GameConfiguration.ISLAND8_LPOINT4_ROW );
        
        
        // RIGHT SIDE
        
        initializeLand(map, manager, GameConfiguration.ISLAND8_RPOINT1_COLUMN.length, GameConfiguration.ISLAND8_RPOINT1_ROW.length , GameConfiguration.ISLAND8_RPOINT1_COLUMN, GameConfiguration.ISLAND8_RPOINT1_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_RPOINT2_COLUMN.length, GameConfiguration.ISLAND8_RPOINT2_ROW.length , GameConfiguration.ISLAND8_RPOINT2_COLUMN, GameConfiguration.ISLAND8_RPOINT2_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_RPOINT3_COLUMN.length, GameConfiguration.ISLAND8_RPOINT3_ROW.length , GameConfiguration.ISLAND8_RPOINT3_COLUMN, GameConfiguration.ISLAND8_RPOINT3_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_RPOINT4_COLUMN.length, GameConfiguration.ISLAND8_RPOINT4_ROW.length , GameConfiguration.ISLAND8_RPOINT4_COLUMN, GameConfiguration.ISLAND8_RPOINT4_ROW );
        
        
        // TOP SIDE
        
        
        initializeLand(map, manager, GameConfiguration.ISLAND8_TPOINT1_COLUMN.length, GameConfiguration.ISLAND8_TPOINT1_ROW.length , GameConfiguration.ISLAND8_TPOINT1_COLUMN, GameConfiguration.ISLAND8_TPOINT1_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_TPOINT2_COLUMN.length, GameConfiguration.ISLAND8_TPOINT2_ROW.length , GameConfiguration.ISLAND8_TPOINT2_COLUMN, GameConfiguration.ISLAND8_TPOINT2_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_TPOINT3_COLUMN.length, GameConfiguration.ISLAND8_TPOINT3_ROW.length , GameConfiguration.ISLAND8_TPOINT3_COLUMN, GameConfiguration.ISLAND8_TPOINT3_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_TPOINT4_COLUMN.length, GameConfiguration.ISLAND8_TPOINT4_ROW.length , GameConfiguration.ISLAND8_TPOINT4_COLUMN, GameConfiguration.ISLAND8_TPOINT4_ROW );
        
        
        // BOTTOM SIDE
        
        
        initializeLand(map, manager, GameConfiguration.ISLAND8_BPOINT1_COLUMN.length, GameConfiguration.ISLAND8_BPOINT1_ROW.length , GameConfiguration.ISLAND8_BPOINT1_COLUMN, GameConfiguration.ISLAND8_BPOINT1_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_BPOINT2_COLUMN.length, GameConfiguration.ISLAND8_BPOINT2_ROW.length , GameConfiguration.ISLAND8_BPOINT2_COLUMN, GameConfiguration.ISLAND8_BPOINT2_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_BPOINT3_COLUMN.length, GameConfiguration.ISLAND8_BPOINT3_ROW.length , GameConfiguration.ISLAND8_BPOINT3_COLUMN, GameConfiguration.ISLAND8_BPOINT3_ROW );
        initializeLand(map, manager, GameConfiguration.ISLAND8_BPOINT4_COLUMN.length, GameConfiguration.ISLAND8_BPOINT4_ROW.length , GameConfiguration.ISLAND8_BPOINT4_COLUMN, GameConfiguration.ISLAND8_BPOINT4_ROW );



    }
/**
 * 
 *  Initializes all our Harbors
 * 
 * 
 * 
 * 
 * @param map Our map
 * @param manager Our manager
 */
    public static void initializeHarbors(Map map, ElementManager manager){ ///////////////// NOUVEAU

        //HARBOR 1

        initializeHarbor(map, manager,GameConfiguration.STARTING_HARBOR,1, GameConfiguration.HARBOR1_STARTING_ROW, GameConfiguration.HARBOR1_FINISHING_ROW, GameConfiguration.HARBOR1_STARTING_COLUMN,GameConfiguration.HARBOR1_FINISHING_COLUMN, GameConfiguration.ALLY);

        //HARBOR 2

        initializeHarbor(map, manager,GameConfiguration.CONTINENT,2, GameConfiguration.HARBOR2_STARTING_ROW, GameConfiguration.HARBOR2_FINISHING_ROW, GameConfiguration.HARBOR2_STARTING_COLUMN,GameConfiguration.HARBOR2_FINISHING_COLUMN,!GameConfiguration.ALLY);

        // HARBOR 3

        initializeHarbor(map, manager,GameConfiguration.HAMMER,3, GameConfiguration.HARBOR3_STARTING_ROW, GameConfiguration.HARBOR3_FINISHING_ROW, GameConfiguration.HARBOR3_STARTING_COLUMN,GameConfiguration.HARBOR3_FINISHING_COLUMN,!GameConfiguration.ALLY);

        // HARBOR 4

        initializeHarbor(map, manager,GameConfiguration.TRIANGLE, 4, GameConfiguration.HARBOR4_STARTING_ROW, GameConfiguration.HARBOR4_FINISHING_ROW, GameConfiguration.HARBOR4_STARTING_COLUMN,GameConfiguration.HARBOR4_FINISHING_COLUMN,!GameConfiguration.ALLY);

        // HARBOR 5

        initializeHarbor(map, manager,GameConfiguration.FEET,5, GameConfiguration.HARBOR5_STARTING_ROW, GameConfiguration.HARBOR5_FINISHING_ROW, GameConfiguration.HARBOR5_STARTING_COLUMN,GameConfiguration.HARBOR5_FINISHING_COLUMN,!GameConfiguration.ALLY);


        // HARBOR 6

        initializeHarbor(map, manager,GameConfiguration.DEFORMED_SQUARE,6, GameConfiguration.HARBOR6_STARTING_ROW, GameConfiguration.HARBOR6_FINISHING_ROW, GameConfiguration.HARBOR6_STARTING_COLUMN,GameConfiguration.HARBOR6_FINISHING_COLUMN,!GameConfiguration.ALLY);

        // HARBOR 7

        initializeHarbor(map, manager,GameConfiguration.HOURGLASS,7, GameConfiguration.HARBOR7_STARTING_ROW, GameConfiguration.HARBOR7_FINISHING_ROW, GameConfiguration.HARBOR7_STARTING_COLUMN,GameConfiguration.HARBOR7_FINISHING_COLUMN, !GameConfiguration.ALLY);

        // HARBOR 8

        initializeHarbor(map, manager,GameConfiguration.COMPASS,8, GameConfiguration.HARBOR8_STARTING_ROW, GameConfiguration.HARBOR8_FINISHING_ROW, GameConfiguration.HARBOR8_STARTING_COLUMN,GameConfiguration.HARBOR8_FINISHING_COLUMN, !GameConfiguration.ALLY);

    }


    /*BUILD SEAWAYS*/
/**
 * 
 * 
 * Initializes
 * 
 * 
 * 
 * 
 * @param map Our map
 * @param manager Our manager
 */
    public static void initializeSeaways(Map map, ElementManager manager){


        initializeSeaway(map, manager, GameConfiguration.SEAWAY_ID1,GameConfiguration.SEAWAY1_ROWS, GameConfiguration.SEAWAY1_COLUMNS);

        initializeSeaway(map, manager, GameConfiguration.SEAWAY_ID2, GameConfiguration.SEAWAY2_ROWS, GameConfiguration.SEAWAY2_COLUMNS);

        initializeSeaway(map, manager, GameConfiguration.SEAWAY_ID3, GameConfiguration.SEAWAY3_ROWS, GameConfiguration.SEAWAY3_COLUMNS);

        initializeSeaway(map, manager, GameConfiguration.SEAWAY_ID4, GameConfiguration.SEAWAY4_ROWS, GameConfiguration.SEAWAY4_COLUMNS);

        initializeSeaway(map, manager, GameConfiguration.SEAWAY_ID5, GameConfiguration.SEAWAY5_ROWS, GameConfiguration.SEAWAY5_COLUMNS);

        initializeSeaway(map, manager, GameConfiguration.SEAWAY_ID6, GameConfiguration.SEAWAY6_ROWS, GameConfiguration.SEAWAY6_COLUMNS);

        initializeSeaway(map, manager, GameConfiguration.SEAWAY_ID7, GameConfiguration.SEAWAY7_ROWS, GameConfiguration.SEAWAY7_COLUMNS);
    }


    public static void initializeResources(Player player) {
    	
    	
    	initializeResource(player, GameConfiguration.COFFEE, GameConfiguration.PRICE_COFFEE);
    	
    	initializeResource(player, GameConfiguration.SUGAR, GameConfiguration.PRICE_SUGAR);
    	
    	initializeResource(player, GameConfiguration.SALT, GameConfiguration.PRICE_SALT);
    	
    	initializeResource(player, GameConfiguration.SPICES, GameConfiguration.PRICE_SPICES);
    	
    	initializeResource(player, GameConfiguration.GOLD, GameConfiguration.PRICE_GOLD);
    	
    	initializeResource(player, GameConfiguration.COTTON, GameConfiguration.PRICE_COTTON);
    	
    	initializeResource(player, GameConfiguration.SILK, GameConfiguration.PRICE_SILK);
    	
    	initializeResource(player, GameConfiguration.PAPER, GameConfiguration.PRICE_PAPER);
    	
    	initializeResource(player, GameConfiguration.TISSUE, GameConfiguration.PRICE_TISSUE);
    	
    	initializeResource(player, GameConfiguration.TOBACCO, GameConfiguration.PRICE_TOBACCO);
    	
    	
    }

	

    
}
