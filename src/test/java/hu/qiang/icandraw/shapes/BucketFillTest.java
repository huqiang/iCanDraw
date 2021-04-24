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
public class BucketFillTest {
    private static final Logger logger = LoggerFactory.getLogger(BucketFillTest.class);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void create() {
        BucketFill b = new BucketFill(1, 1, '$');
        assertNotNull(b);
    }

    @Test
    public void create2() throws Exception {
        this.exception.expect(InvalidCommandParamException.class);
        BucketFill b = new BucketFill(0, 1, '$');
    }

    @Test
    public void create3() throws Exception {
        this.exception.expect(InvalidCommandParamException.class);
        BucketFill b = new BucketFill(1, 0, '$');
    }

    @Test
    public void create4() throws Exception {
        this.exception.expect(InvalidCommandParamException.class);
        BucketFill b = new BucketFill(-1, 1, '$');
    }

    @Test
    public void create5() throws Exception {
        this.exception.expect(InvalidCommandParamException.class);
        BucketFill b = new BucketFill(1, -1, '$');
    }

    @Test
    public void testEqual() {
        BucketFill b1 = new BucketFill(1, 1, '#');
        BucketFill b2 = new BucketFill(1, 1, '#');
        assertFalse(b1 == b2);
        assertEquals(b1, b2);
        assertEquals(b1.hashCode(), b2.hashCode());
    }

    @Test
    public void testNotEqual() {
        BucketFill b1 = new BucketFill(1, 1, '#');
        BucketFill b2 = new BucketFill(1, 1, '$');
        assertFalse(b1 == b2);
        assertNotEquals(b1, b2);


        BucketFill b3 = new BucketFill(1, 2, '$');
        BucketFill b4 = new BucketFill(2, 1, '$');
        assertFalse(b1 == b2);
        assertNotEquals(b3, b4);
    }

}
