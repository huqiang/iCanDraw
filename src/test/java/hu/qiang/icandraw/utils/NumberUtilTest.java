/**
 *
 */
package hu.qiang.icandraw.utils;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author huqiang
 *
 */
public class NumberUtilTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testIsAllPositiveNumbers() {
        assertTrue(NumberUtil.isAllPositiveNumbers(1, 2, 3));
        assertTrue(NumberUtil.isAllPositiveNumbers(1, 1, 1));
        assertTrue(NumberUtil.isAllPositiveNumbers(1));
        assertTrue(NumberUtil.isAllPositiveNumbers());

        assertFalse(NumberUtil.isAllPositiveNumbers(0, 2, 3));
        assertFalse(NumberUtil.isAllPositiveNumbers(0, -2, 3));
    }

    @Test
    public void testStringToPositiveInt() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer num = random.nextInt(9999 - 1) + 1;

            assertTrue(NumberUtil.stringToPositiveInt(num.toString()) == num);
        }
    }

    @Test
    public void testWithException() {
        this.exception.expect(InvalidCommandParamException.class);
        NumberUtil.stringToPositiveInt("-1");
    }

    @Test
    public void testWithException2() {
        this.exception.expect(InvalidCommandParamException.class);
        NumberUtil.stringToPositiveInt("#");
    }

    @Test
    public void testWithException3() {
        this.exception.expect(InvalidCommandParamException.class);
        NumberUtil.stringToPositiveInt("$");
    }

    @Test
    public void testAllPositiveNumbers() {
        assertTrue(NumberUtil.isAllPositiveNumbers(1));
        assertTrue(NumberUtil.isAllPositiveNumbers(1, 2));
        assertTrue(NumberUtil.isAllPositiveNumbers(333333333));

        assertFalse(NumberUtil.isAllPositiveNumbers(0));
        assertFalse(NumberUtil.isAllPositiveNumbers(-1));
        assertFalse(NumberUtil.isAllPositiveNumbers(-3333333));
    }
}
