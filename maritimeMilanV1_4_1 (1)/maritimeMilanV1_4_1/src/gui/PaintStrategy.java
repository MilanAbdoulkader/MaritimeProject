package gui;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobileElement.Fleet;
import engine.staticElement.Harbor;
import engine.staticElement.Land;
import engine.staticElement.Seaway;

import java.awt.*;

public class PaintStrategy{
    public void paint(Map map, Graphics graphics) {
        int blockSize = GameConfiguration.BLOCK_SIZE;
        Block[][] blocks = map.getBlocks();

        for (int rowIndex = 0; rowIndex < map.getNumberOfRow(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < map.getNumberOfColumn(); columnIndex++) {
                Block block = blocks[rowIndex][columnIndex];
                
                graphics.setColor(new Color(40,145,238));
                graphics.fillRect(block.getColumn() * blockSize, block.getRow() * blockSize, blockSize, blockSize); ////////////// ATTENTIONNNN
            }
        }
    }

    public void paint(Fleet fleet, Graphics graphics) {
        Block position = fleet.getPosition();
        int x = position.getColumn();
        int y = position.getRow();

        int blockSize = GameConfiguration.BLOCK_SIZE; // /2 ?
        if (fleet.getAlignement()){
            graphics.setColor(new Color(88, 41, 0));
        }
        else {
            graphics.setColor(new Color(255, 0, 0));
        }

        graphics.drawLine(x * blockSize + blockSize / 2, y * blockSize, x * blockSize, (y + 1) * blockSize);
        graphics.drawLine(x * blockSize + blockSize / 2, y * blockSize, (x + 1) * blockSize, (y + 1) * blockSize);
        graphics.drawLine(x * blockSize + blockSize / 2, y * blockSize, x * blockSize + blockSize / 2, (y + 1) * blockSize);
        graphics.fillRect(x * blockSize, y * blockSize+blockSize, blockSize, blockSize/2);

    }


    ////////////////////////////////////////////////////////////////////////////////// DE la
    public void paintEnemyHarbor(Harbor harbor, Graphics graphics){
        Block position = harbor.getPosition();
        int blockSize = GameConfiguration.BLOCK_SIZE;

        int x = position.getColumn();
        int y = position.getRow();

        graphics.setColor(new Color(71,71,71));
        graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
    }



    public void paintAlliedHarbor(Harbor harbor, Graphics graphics){
        Block position = harbor.getPosition();
        int blockSize = GameConfiguration.BLOCK_SIZE;

        int x = position.getColumn();
        int y = position.getRow();

        graphics.setColor(new Color(2,100,0));
        graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
    }
    /////////////////////////// A la

    public void paint(Land land, Graphics graphics){
        Block position = land.getPosition();
        int blockSize = GameConfiguration.BLOCK_SIZE;

        int x = position.getColumn();
        int y = position.getRow();

        graphics.setColor(new Color(133,75,25));
        graphics.fill3DRect(x * blockSize, y * blockSize, blockSize, blockSize, true);
    }

    /////////////////////// NOUVEAU
    public void paint(Seaway seaway , Graphics graphics){
        Block position = seaway.getPosition();
        int blockSize = GameConfiguration.BLOCK_SIZE;

        int x = position.getColumn();
        int y = position.getRow();

        graphics.setColor(new Color(112, 123, 124));
        graphics.fill3DRect(x * blockSize, y * blockSize, blockSize/2, blockSize/2, true);
    }


    public void paintHide(Seaway seaway , Graphics graphics){
        Block position = seaway.getPosition();
        int blockSize = GameConfiguration.BLOCK_SIZE;

        int x = position.getColumn();
        int y = position.getRow();

        graphics.setColor(new Color(40, 145, 238));
        graphics.fillRect(x * blockSize, y * blockSize, blockSize/2, blockSize/2);
    }

}
