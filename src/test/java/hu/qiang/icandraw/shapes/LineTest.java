/**
 *
 */
package hu.qiang.icandraw.shapes;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;

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

}
