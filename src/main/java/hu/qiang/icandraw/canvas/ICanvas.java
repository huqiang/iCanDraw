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

    char[][] getCanvasArray();

    String render();

    void setLineCharacter(char lineChar);

    char getLineCharacter();
}
