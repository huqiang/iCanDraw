/**
 *
 */
package hu.qiang.icandraw.canvas;

import hu.qiang.icandraw.exceptions.InvalidShapeException;
import hu.qiang.icandraw.shapes.BucketFill;
import hu.qiang.icandraw.shapes.IShape;
import hu.qiang.icandraw.shapes.Line;
import hu.qiang.icandraw.shapes.Rectangle;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huqiang
 *
 */
public class Canvas implements ICanvas {
    private static final String HORIZONTAL_EDGE_STR = "-";
    private static final char VERTICAL_EDGE_CHAR = '|';

    private final char[][] canvasArray;
    private final int width;
    private final int height;
    private final String horizontalEdge;

    private final Stack<IShape> shapes; // TO Support undo.

    private char LINE_CHAR = 'x';

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;

        this.canvasArray = new char[this.height][this.width];
        Arrays.stream(this.canvasArray).forEach(row -> Arrays.fill(row, ' '));
        this.horizontalEdge = Stream.generate(() -> HORIZONTAL_EDGE_STR)
                .limit(width + 2)
                .collect(Collectors.joining());
        this.shapes = new Stack<>();
    }

    @Override
    public void addShape(IShape shape) {
        switch (shape.getShapeName()) {
            case LINE:
                this.addLine((Line) shape);
                break;
            case RECTANGLE:
                this.addRectangle((Rectangle) shape);
                break;
            case BUCKET:
                this.addBucketFill((BucketFill) shape);
                break;
            default:
                throw new InvalidShapeException("Unsupported shape: " + shape.getShapeName());
        }
        this.shapes.push(shape);
    }

    @Override
    public char[][] getCanvasArray() {
        return this.canvasArray;
    }

    private void addBucketFill(BucketFill bucket) {
        bucket.render(this);
    }

    private void addRectangle(Rectangle rect) {
        rect.render(this);
    }

    private void addLine(Line line) {
        line.render(this);
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.horizontalEdge).append(System.lineSeparator());
        for (int i = 0; i < this.height; i++) {
            builder.append(VERTICAL_EDGE_CHAR);
            for (int j = 0; j < this.width; j++) {
                builder.append(this.canvasArray[i][j]);
            }
            builder.append(VERTICAL_EDGE_CHAR).append(System.lineSeparator());
        }
        builder.append(this.horizontalEdge);
        return builder.toString();
    }

    @Override
    public void setLineCharacter(char lineChar) {
        this.LINE_CHAR = lineChar;
    }

    @Override
    public char getLineCharacter() {
        return this.LINE_CHAR;
    }
}
