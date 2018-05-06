/**
 * 
 */
package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.utils.Validator;

/**
 * @author huqiang
 *
 */
public class BucketFill implements IShape {
	private int x;
	private int y;
	private char character;

	public BucketFill(int x, int y, char character) {
		Validator.shouldAllPositiveNumbers(x, y);
		this.x = x;
		this.y = y;
		this.character = character;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getCharacter() {
		return character;
	}
	
	
}
