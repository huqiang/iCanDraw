/**
 *
 */
package hu.qiang.icandraw.canvas;

import hu.qiang.icandraw.shapes.IShape;

/**
 * @author huqiang
 *
 */
public interface ICanvas {
    void addShape(IShape shape);

    String render();
}
