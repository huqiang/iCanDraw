package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RectangleTest {
    private static final Logger logger = LoggerFactory.getLogger(RectangleTest.class);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void create1() {
        Rectangle rect1 = new Rectangle(1, 2, 3, 4);
        assertEquals(IShape.ShapeName.RECTANGLE, rect1.getShapeName());
        Rectangle rect2 = new Rectangle(3, 4, 1, 2);
        assertFalse(rect1 == rect2);
        assertEquals(rect1, rect2);
        assertEquals(rect1.hashCode(), rect2.hashCode());
    }

    @Test
    public void create2() throws Exception {
        this.exception.expect(InvalidCommandParamException.class);
        Rectangle rect1 = new Rectangle(1, 2, 1, 3);
        Rectangle rect2 = new Rectangle(1, 2, 3, 2);
    }

    @Test
    public void create3() throws Exception {
        this.exception.expect(InvalidCommandParamException.class);
        new Rectangle(-1, 2, 1, 2);
    }

    @Test
    public void create4() throws Exception {
        this.exception.expect(InvalidCommandParamException.class);
        new Rectangle(1, -2, 1, 2);
    }

}
