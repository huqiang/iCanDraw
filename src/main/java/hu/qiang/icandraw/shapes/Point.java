/**
 * 
 */
package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.utils.Validator;

/**
 * @author huqiang
 *
 */
public class Point implements IShape {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		Validator.shouldAllPositiveNumbers(x, y);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public ShapeName getShapeName() {
		return ShapeName.POINT;
	}
}
