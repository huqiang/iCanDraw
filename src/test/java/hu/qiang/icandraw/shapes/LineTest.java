/**
 *
 */
package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author huqiang
 *
 */
public class LineTest {
    private static final Logger logger = LoggerFactory.getLogger(LineTest.class);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Test method for
     * {@link hu.qiang.icandraw.shapes.Line#Line(int, int, int, int)}.
     */
    @Test
    public void testLine() {
        Line l = new Line(1, 1, 1, 8);
        assertNotNull(l);
        assertTrue(l.getX1() == 1
                && l.getY1() == 1
                && l.getX2() == 1
                && l.getY2() == 8);
    }

    @Test
    public void testLineWithNonPositiveInt() {
        this.exception.expect(InvalidCommandParamException.class);
        Line l = new Line(0, 1, 1, 8);
    }

    @Test
    public void testLineWithDiagnosed() {
        this.exception.expect(InvalidCommandParamException.class);
        Line l = new Line(2, 1, 1, 8);
    }

    @Test
    public void testLineWithSameEndingPoints() {
        this.exception.expect(InvalidCommandParamException.class);
        Line l = new Line(1, 1, 1, 1);
    }

    @Test
    public void testEquals() {
        Line line1 = new Line(1, 1, 1, 4);
        assertEquals(line1, line1);
        Line line2 = new Line(1, 4, 1, 1);
        assertFalse(line1 == line2);
        assertEquals(line1, line2);
        assertEquals(line1.hashCode(), line2.hashCode());
    }
}
