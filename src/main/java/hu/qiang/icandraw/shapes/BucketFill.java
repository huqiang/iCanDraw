/**
 *
 */
package hu.qiang.icandraw.shapes;

import com.google.common.base.Objects;
import hu.qiang.icandraw.canvas.ICanvas;
import hu.qiang.icandraw.utils.Validator;

import java.util.Stack;

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
    public void render(ICanvas canvas) {
        char[][] canvasArray = canvas.getCanvasArray();
        this.checkIsOutside(this.getX(), this.getY(), canvasArray);
        char selectedChar = canvasArray[y - 1][x - 1];
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(x, y));

        while (!stack.isEmpty()) {
            Point point = stack.pop();
            //Color the point if matches
            if (canvasArray[point.getY() - 1][point.getX() - 1] == selectedChar) {
                canvasArray[point.getY() - 1][point.getX() - 1] = this.getCharacter();
            }

            //left
            if (point.getX() - 2 >= 0 && canvasArray[point.getY() - 1][point.getX() - 2] == selectedChar) {
                stack.push(new Point(point.getX() - 1, point.getY()));
            }
            //up
            if (point.getY() - 2 >= 0 && canvasArray[point.getY() - 2][point.getX() - 1] == selectedChar) {
                stack.push(new Point(point.getX(), point.getY() - 1));
            }
            //right
            if (point.getX() < canvasArray[0].length && canvasArray[point.getY() - 1][point.getX()] == selectedChar) {
                stack.push(new Point(point.getX() + 1, point.getY()));
            }
            //down
            if (point.getY() < canvasArray.length && canvasArray[point.getY()][point.getX() - 1] == selectedChar) {
                stack.push(new Point(point.getX(), point.getY() + 1));
            }
        }
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
