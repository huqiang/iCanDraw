package hu.qiang.icandraw.shapes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;

public class RectangleTest {
	private static final Logger logger = LoggerFactory.getLogger(RectangleTest.class);
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void create1() {
		new Rectangle(1, 2, 3, 4);
	}

	@Test
	public void create2() throws Exception {
		this.exception.expect(InvalidCommandParamException.class);
		Rectangle rect1 = new Rectangle(1, 2, 1, 3);
		Rectangle line2 = new Rectangle(1, 2, 3, 2);
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
