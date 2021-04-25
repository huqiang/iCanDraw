/**
 *
 */
package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.canvas.ICanvas;
import hu.qiang.icandraw.exceptions.InvalidShapeException;

/**
 * @author huqiang
 *
 */
public interface IShape {
    enum ShapeName {
        POINT, LINE, RECTANGLE, BUCKET
    }

    default void checkIsOutside(int x, int y, char[][] canvasArray) {
        if (x < 1 || x > canvasArray[0].length || y < 1 || y > canvasArray.length) {
            throw new InvalidShapeException("Point to fill is outside of canvas");
        }
    }

    void render(ICanvas canvas);

    ShapeName getShapeName();
}
