/**
 * 
 */
package hu.qiang.icandraw.shapes;

import com.google.common.base.Objects;
import hu.qiang.icandraw.utils.Validator;

/**
 * @author huqiang
 *
 */
public class BucketFill implements IShape {
	private final int x;
	private final int y;
	private final char character;

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


	@Override
	public ShapeName getShapeName() {
		return ShapeName.BUCKET;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BucketFill that = (BucketFill) o;
		return x == that.x && y == that.y && character == that.character;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(x, y, character);
	}
}
