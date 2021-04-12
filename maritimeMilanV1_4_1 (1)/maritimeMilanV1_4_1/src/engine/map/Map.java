package engine.map;




/**
 * 
 * 
 * Creates a Map comprised of Block * BLock
 * 
 * 
 * 
 * @author nbant
 *
 */
public class Map {
	private Block[][] blocks;

	private int rowCount;
	private int columnCount;

	
	/**
	 * 
	 * 
	 * 
	 * Map constructor
	 *
	 * 
	 * @param rowCount Refers to the number of rows
	 * @param columnCount Refers to the number of columns
	 * 
	 * 
	 */
	public Map(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;

		blocks = new Block[rowCount][columnCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
				blocks[rowIndex][columnIndex] = new Block(rowIndex, columnIndex);
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}
	public Block getBlock(int row, int column) {
		return blocks[row][column];
	}

	public int getNumberOfRow() {
		return rowCount;
	}

	public int getNumberOfColumn() {
		return columnCount;
	}

}
