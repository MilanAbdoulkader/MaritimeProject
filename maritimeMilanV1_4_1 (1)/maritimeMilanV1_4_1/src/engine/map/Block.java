package engine.map;
/**
 * 
 * 
 * 
 * 
 * Creates a Block with row column coordinates 
 * 
 * @author nbant
 *
 */
public class Block {
	private int row;
	private int column;

	
	/**
	 * 
	 * 
	 * 
	 * Block constructor
	 * 
	 * 
	 * @param row
	 * @param column
	 */
	public Block(int row, int column) {
		this.column = column;
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	@Override
	public String toString() {
		return "Block [row=" + row + ", column =" + column + "]";
	}

}
