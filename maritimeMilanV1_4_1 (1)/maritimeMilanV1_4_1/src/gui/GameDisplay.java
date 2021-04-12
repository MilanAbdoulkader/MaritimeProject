package gui;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.process.ElementManager;
import engine.staticElement.Harbor;
import engine.staticElement.Land;
import engine.staticElement.Seaway;


import javax.swing.*;
import java.awt.*;

public class GameDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map map;
    private ElementManager manager;
    private PaintStrategy paintStrategy = new PaintStrategy();


    public GameDisplay(Map map, ElementManager Manager){
        this.map = map;
        this.manager = Manager;
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        paintStrategy.paint(map,graphics);


        for (Land land : manager.getLands()){
            paintStrategy.paint(land, graphics);
        }



        for (int i = 1 ; i <= GameConfiguration.HARBOR_COUNT ; i++){

            for (Harbor part : manager.getHarbors().get(i)){

                if(part.getAlignment() == false) {

                    paintStrategy.paintEnemyHarbor(part, graphics);
                }
                else {

                    paintStrategy.paintAlliedHarbor(part, graphics);
                }

            }
        }





        for (int i = 1 ; i <= GameConfiguration.SEAWAY_COUNT ; i++){
            for (Seaway patch : manager.getSeaways().get(i+1)){
                if(GameConfiguration.STATE == true) {
                    paintStrategy.paint(patch, graphics);
                }
                else {
                    paintStrategy.paintHide(patch, graphics);
                }
            }
        }


        for (int fleetCount = 1 ; fleetCount <= GameConfiguration.FLEET_COUNT ; fleetCount++){
            paintStrategy.paint(manager.getFleets().get(fleetCount), graphics);
        }
        

        for (int pirateFleetCount = 1 ; pirateFleetCount < GameConfiguration.PIRATE_FLEET_COUNT ; pirateFleetCount++){
            if(!manager.getPirateFleets().get(pirateFleetCount).isSetPosition())
                paintStrategy.paint(manager.getPirateFleets().get(pirateFleetCount), graphics);
        }

    }

	  public Block getPosition(int x, int y) {
		int line = y / GameConfiguration.BLOCK_SIZE;
		int column = x / GameConfiguration.BLOCK_SIZE;
		return map.getBlock(line, column);
	}

}
