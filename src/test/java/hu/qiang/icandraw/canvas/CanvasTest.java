package hu.qiang.icandraw.canvas;

import hu.qiang.icandraw.exceptions.InvalidShapeException;
import hu.qiang.icandraw.shapes.BucketFill;
import hu.qiang.icandraw.shapes.Line;
import hu.qiang.icandraw.shapes.Point;
import hu.qiang.icandraw.shapes.Rectangle;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CanvasTest {
    private Canvas canvas;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.canvas = new Canvas(20, 5);
    }

    @Test
    public void testRenderNormal() {
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    public void testVerticalLineNormal() {
        Line l = new Line(1, 1, 1, 4);
        this.canvas.addShape(l);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|x                   |\n" +
                        "|x                   |\n" +
                        "|x                   |\n" +
                        "|x                   |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    public void testHorizontalLineNormal() {
        Line l = new Line(1, 1, 4, 1);
        this.canvas.addShape(l);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|xxxx                |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    public void testRectangleNormal() {
        Rectangle r = new Rectangle(1, 1, 4, 4);
        this.canvas.addShape(r);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|xxxx                |\n" +
                        "|x  x                |\n" +
                        "|x  x                |\n" +
                        "|xxxx                |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    public void testBuckFillNormal() {
        Rectangle r = new Rectangle(1, 1, 4, 4);
        this.canvas.addShape(r);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|xxxx                |\n" +
                        "|x  x                |\n" +
                        "|x  x                |\n" +
                        "|xxxx                |\n" +
                        "|                    |\n" +
                        "----------------------");
        BucketFill b = new BucketFill(1, 1, '$');
        this.canvas.addShape(b);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|$$$$                |\n" +
                        "|$  $                |\n" +
                        "|$  $                |\n" +
                        "|$$$$                |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

    @Test
    public void testLineByEdgeNormal() {
        Line l = new Line(1, 1, 1, 5);
        this.canvas.addShape(l);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|x                   |\n" +
                        "|x                   |\n" +
                        "|x                   |\n" +
                        "|x                   |\n" +
                        "|x                   |\n" +
                        "----------------------");
    }

    @Test
    public void testLineOutOfBoundary() {
        Line l = new Line(1, 1, 1, 6);
        this.exception.expect(InvalidShapeException.class);
        this.canvas.addShape(l);
    }

    @Test
    public void testShapeCombinations() {
        Line l1 = new Line(5, 1, 5, 4);
        this.canvas.addShape(l1);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|    x               |\n" +
                        "|    x               |\n" +
                        "|    x               |\n" +
                        "|    x               |\n" +
                        "|                    |\n" +
                        "----------------------");
        Line l2 = new Line(6, 4, 10, 4);
        this.canvas.addShape(l2);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|    x               |\n" +
                        "|    x               |\n" +
                        "|    x               |\n" +
                        "|    xxxxxx          |\n" +
                        "|                    |\n" +
                        "----------------------");

        Rectangle r1 = new Rectangle(11, 2, 16, 5);
        this.canvas.addShape(r1);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|    x               |\n" +
                        "|    x     xxxxxx    |\n" +
                        "|    x     x    x    |\n" +
                        "|    xxxxxxx    x    |\n" +
                        "|          xxxxxx    |\n" +
                        "----------------------");

        BucketFill b1 = new BucketFill(3, 2, '$');
        this.canvas.addShape(b1);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|$$$$x               |\n" +
                        "|$$$$x     xxxxxx    |\n" +
                        "|$$$$x     x    x    |\n" +
                        "|$$$$xxxxxxx    x    |\n" +
                        "|$$$$$$$$$$xxxxxx    |\n" +
                        "----------------------");

        BucketFill b2 = new BucketFill(13, 4, '^');
        this.canvas.addShape(b2);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|$$$$x               |\n" +
                        "|$$$$x     xxxxxx    |\n" +
                        "|$$$$x     x^^^^x    |\n" +
                        "|$$$$xxxxxxx^^^^x    |\n" +
                        "|$$$$$$$$$$xxxxxx    |\n" +
                        "----------------------");
    }

    @Test
    public void testAddInvalidShape() {
        this.exception.expect(InvalidShapeException.class);
        Point point = new Point(2, 3);
        this.canvas.addShape(point);
    }

    @Test
    public void testBucketFillOutOfBoundary() {
        this.exception.expect(InvalidShapeException.class);
        BucketFill bucket = new BucketFill(1, 6, '$');
        this.canvas.addShape(bucket);
    }

    @Test
    public void testAddRectangleOutOfBoundary() {
        this.exception.expect(InvalidShapeException.class);
        Rectangle rectangle1 = new Rectangle(1, 1, 6, 6);
        this.canvas.addShape(rectangle1);
    }

    @Test
    public void testLineCharacter() {
        // default line character
        assertTrue(this.canvas.getLineCharacter() == 'x');

        this.canvas.setLineCharacter('#');
        Line l = new Line(1, 1, 1, 4);
        this.canvas.addShape(l);
        assertEquals(this.canvas.render(),
                "----------------------\n" +
                        "|#                   |\n" +
                        "|#                   |\n" +
                        "|#                   |\n" +
                        "|#                   |\n" +
                        "|                    |\n" +
                        "----------------------");
    }
}
