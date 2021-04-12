package engine.staticElement;


import engine.map.Block;


/**
 * 
 * 
 * Defines and implements abstract methods
 * 
 * 
 * 
 * 
 * @author nbant
 *
 */
public abstract class StaticElement {
		private Block position;

		public StaticElement(Block position) {
			this.position = position;
		}

		public Block getPosition() {
			return position;
		}

		public void setPosition(Block position) {
			this.position = position;
		}


}
