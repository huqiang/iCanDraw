/**
 * 
 */
package hu.qiang.icandraw.utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author huqiang
 *
 */
public class NumberUtilTest {

	@Test
	public void testIsAllPositiveNumbers() {
		assertTrue(NumberUtil.isAllPositiveNumbers(1,2,3));
		assertTrue(NumberUtil.isAllPositiveNumbers(1,1,1));
		assertTrue(NumberUtil.isAllPositiveNumbers(1));
		assertTrue(NumberUtil.isAllPositiveNumbers());
		
		assertFalse(NumberUtil.isAllPositiveNumbers(0,2,3));
		assertFalse(NumberUtil.isAllPositiveNumbers(0,-2,3));
	}

}
