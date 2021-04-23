/**
 * 
 */
package hu.qiang.icandraw.shapes;

/**
 * @author huqiang
 *
 */
public interface IShape {
    enum ShapeName {
        POINT, LINE, RECTANGLE, BUCKET
    }

    ShapeName getShapeName();
}
