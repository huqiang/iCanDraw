/**
 *
 */
package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import hu.qiang.icandraw.utils.Validator;

/**
 * @author huqiang
 *
 */
public class Line implements IShape {
	private final int x1;
	private final int y1;
	private final int x2;
	private final int y2;

	public Line(int x1, int y1, int x2, int y2) {
		Validator.shouldAllPositiveNumbers(x1, y1, x2, y2);
		if (x1 != x2 && y1 != y2) {
			throw new InvalidCommandParamException("Oonly horizontal or vertical lines are supported");
		}

		if (x1 == x2 && y1 == y2) {
			throw new InvalidCommandParamException("Line pints should be different!");
		}
		if ((x1 == x2 && y1 > y2) || (y1 == y2 && x1 > x2)) {
			// Ensure (x1, y1) ->(x2, y2) is from top left to bottom right
			this.x1 = x2;
			this.y1 = y2;
			this.x2 = x1;
			this.y2 = y1;
		} else {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	public int getX1() {
		return this.x1;
	}

	public int getY1() {
		return this.y1;
	}

	public int getX2() {
		return this.x2;
	}

	public int getY2() {
		return this.y2;
	}

}
