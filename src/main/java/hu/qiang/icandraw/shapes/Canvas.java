/**
 *
 */
package hu.qiang.icandraw.shapes;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hu.qiang.icandraw.exceptions.InvalidShapeException;

/**
 * @author huqiang
 *
 */
public class Canvas implements ICanvas {
	private static final String HORIZONTAL_EDGE_STR = "-";
	private static final char VERTICAL_EDGE_CHAR = '|';
	private static final char LINE_CHAR = 'x';

	private final char[][] canvasArray;
	private final int width;
	private final int height;
	private String horizontalEdge;

	private Stack<IShape> shapes; // TO Support undo.

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
		switch (shape.getShapeName()){
			case LINE:
				this.addLine((Line)shape);
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

	private void addBucketFill(BucketFill bucket) {
		if (this.isOutside(bucket.getX(), bucket.getY())) {
			throw new InvalidShapeException("Select point to fill is outside of canvas");
		}
		this.fillBucket(bucket.getX(), bucket.getY(), bucket.getCharacter());
	}

	private void addRectangle(Rectangle rect) {
		if (this.isOutside(rect.getX1(), rect.getY1())
				|| this.isOutside(rect.getX2(), rect.getY2())) {
			throw new InvalidShapeException("Rectangle is outside of canvas");
		}
		this.drawRectangle(rect.getX1(), rect.getY1(), rect.getX2(), rect.getY2());

	}

	private void addLine(Line line) {
		// System.out.println(String.format("%d %d %d %d %d %d", this.width,
		// this.height, line.getX1(), line.getY1(),line.getX2(), line.getY2()));
		if (this.isOutside(line.getX1(), line.getY1())
				|| this.isOutside(line.getX2(), line.getY2())) {
			throw new InvalidShapeException("Line is outside of canvas");
		}
		this.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
	}

	private void drawLine(int x1, int y1, int x2, int y2) {
		// row
		for (int row = y1 - 1; row <= y2 - 1 && row < this.height; row++) {
			// column
			for (int col = x1 - 1; col <= x2 - 1 && col < this.width; col++) {
				this.canvasArray[row][col] = Canvas.LINE_CHAR;
			}
		}
	}

	private void drawRectangle(int x1, int y1, int x2, int y2) {
		// top
		this.drawLine(x1, y1, x2, y1);
		// left
		this.drawLine(x1, y1, x1, y2);
		// right
		this.drawLine(x2, y1, x2, y2);
		// bottom
		this.drawLine(x1, y2, x2, y2);
	}

	private void fillBucket(int x, int y, char color) {
		char selectedChar = this.canvasArray[y - 1][x - 1];
		Stack<Point> stack = new Stack<>();
		stack.add(new Point(y, x));

		while(!stack.isEmpty()) {
			Point point = stack.pop();
			//Color the point if matches
			if(this.canvasArray[point.getX() - 1][point.getY() - 1] == selectedChar) {
				this.canvasArray[point.getX() - 1][point.getY() - 1] = color;
			}

			//left
			if(point.getX() - 2 >= 0  && this.canvasArray[point.getX() - 2][point.getY() - 1] == selectedChar) {
				stack.push(new Point(point.getX() - 1, point.getY()));
			}
			//up
			if(point.getY() - 2 >= 0  && this.canvasArray[point.getX() - 1][point.getY() - 2] == selectedChar) {
				stack.push(new Point(point.getX(), point.getY() - 1));
			}
			//right
			if(point.getX() < this.height  && this.canvasArray[point.getX()][point.getY() - 1] == selectedChar) {
				stack.push(new Point(point.getX() + 1, point.getY()));
			}
			//down
			if(point.getY() < this.width  && this.canvasArray[point.getX() - 1][point.getY()] == selectedChar) {
				stack.push(new Point(point.getX(), point.getY() + 1));
			}

		}
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

	private boolean isOutside(int x, int y) {
		return x < 1 || x > this.width || y < 1 || y > this.height;
	}
}
