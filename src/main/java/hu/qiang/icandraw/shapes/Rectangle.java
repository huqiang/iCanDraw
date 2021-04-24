/**
 *
 */
package hu.qiang.icandraw.shapes;

import com.google.common.base.Objects;
import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import hu.qiang.icandraw.utils.Validator;

/**
 * @author huqiang
 *
 */
public class Rectangle implements IShape {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        Validator.shouldAllPositiveNumbers(x1, y1, x2, y2);
        if (x1 == x2 || y1 == y2) {
            throw new InvalidCommandParamException("Two pints should be in different line!");
        }
        if (x1 > x2 || y1 > y2) {
            //Ensure (x1, y1) at top left and (x2, y2) at bottom right
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


    @Override
    public ShapeName getShapeName() {
        return ShapeName.RECTANGLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return x1 == rectangle.x1 && y1 == rectangle.y1 && x2 == rectangle.x2 && y2 == rectangle.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x1, y1, x2, y2);
    }
}
