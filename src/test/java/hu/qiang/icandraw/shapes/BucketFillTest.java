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
public class BucketFillTest {
	private static final Logger logger = LoggerFactory.getLogger(BucketFillTest.class);
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void create() {
		BucketFill b = new BucketFill(1,1,'$');
		assertNotNull(b);
	}

	@Test
	public void create2() throws Exception {
		this.exception.expect(InvalidCommandParamException.class);
		BucketFill b = new BucketFill(0,1,'$');
	}

	@Test
	public void create3() throws Exception {
		this.exception.expect(InvalidCommandParamException.class);
		BucketFill b = new BucketFill(1,0,'$');
	}

	@Test
	public void create4() throws Exception {
		this.exception.expect(InvalidCommandParamException.class);
		BucketFill b = new BucketFill(-1,1,'$');
	}

	@Test
	public void create5() throws Exception {
		this.exception.expect(InvalidCommandParamException.class);
		BucketFill b = new BucketFill(1,-1,'$');
	}

}
