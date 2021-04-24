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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }
}
