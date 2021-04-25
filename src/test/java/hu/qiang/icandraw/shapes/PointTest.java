/**
 *
 */
package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.canvas.Canvas;
import hu.qiang.icandraw.canvas.ICanvas;
import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author huqiang
 *
 */
public class PointTest {
    private static final Logger logger = LoggerFactory.getLogger(PointTest.class);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Test method for {@link hu.qiang.icandraw.shapes.Point#Point(int, int)}.
     */
    @Test
    public void testPoint() {
        Point p = new Point(1, 1);
        assertNotNull(p);
        assertEquals(p.getShapeName(), IShape.ShapeName.POINT);

        this.exception.expect(InvalidCommandParamException.class);
        Point p2 = new Point(0, 1);
        assertNull(p2);
    }

    /**
     * Test method for {@link hu.qiang.icandraw.shapes.Point#getX()}.
     */
    @Test
    public void testGetX() {
        logger.debug("Start testGetX");
        List<Integer> points = new Random().ints(2, 1, 9999).boxed().collect(Collectors.toList());
        logger.debug("Create Point({}, {})", points.get(0), points.get(1));
        Point p = new Point(points.get(0), points.get(1));
        assertTrue(points.get(0).equals(p.getX()));
    }

    /**
     * Test method for {@link hu.qiang.icandraw.shapes.Point#getY()}.
     */
    @Test
    public void testGetY() {
        logger.debug("Start testGetY()");
        List<Integer> points = new Random().ints(2, 1, 9999).boxed().collect(Collectors.toList());
        logger.debug("Create Point({}, {})", points.get(0), points.get(1));
        Point p = new Point(points.get(0), points.get(1));
        assertTrue(points.get(1).equals(p.getY()));
    }

    @Test
    public void testEqual() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);

        assertFalse(p1 == p2);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testNotEqual() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 1);

        assertFalse(p1 == p2);
        assertNotEquals(p1, p2);
    }

    @Test
    public void testRender() {
        Random random = new Random();
        int height = random.nextInt(10) + 1;
        int width = random.nextInt(10) + 1;
        ICanvas canvas = new Canvas(width, height);
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                Point point = new Point(x, y);
                point.render(canvas);
                assertTrue(canvas.getCanvasArray()[y - 1][x - 1] == canvas.getLineCharacter());
            }
        }
    }

}
