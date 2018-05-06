/**
 *
 */
package hu.qiang.icandraw.shapes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
		List<Integer> points = new Random().ints(2,1, 9999).boxed().collect(Collectors.toList());
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
		List<Integer> points = new Random().ints(2,1, 9999).boxed().collect(Collectors.toList());
		logger.debug("Create Point({}, {})", points.get(0), points.get(1));
		Point p = new Point(points.get(0), points.get(1));
		assertTrue(points.get(1).equals(p.getY()));
	}

}