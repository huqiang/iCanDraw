package hu.qiang.icandraw.shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hu.qiang.icandraw.exceptions.InvalidShapeException;

public class CanvasTest {
	private Canvas canvas;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		this.canvas = new Canvas(20, 5);
	}

	@Test
	public void test() {
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|                    |\n" +
						"|                    |\n" +
						"|                    |\n" +
						"|                    |\n" +
						"|                    |\n" +
						"----------------------");
	}

	@Test
	public void test2() {
		Line l = new Line(1, 1, 1, 4);
		this.canvas.addShape(l);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|x                   |\n" +
						"|x                   |\n" +
						"|x                   |\n" +
						"|x                   |\n" +
						"|                    |\n" +
						"----------------------");
	}

	@Test
	public void test3() {
		Line l = new Line(1, 1, 4, 1);
		this.canvas.addShape(l);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|xxxx                |\n" +
						"|                    |\n" +
						"|                    |\n" +
						"|                    |\n" +
						"|                    |\n" +
						"----------------------");
	}

	@Test
	public void test4() {
		Rectangle r = new Rectangle(1, 1, 4, 4);
		this.canvas.addShape(r);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|xxxx                |\n" +
						"|x  x                |\n" +
						"|x  x                |\n" +
						"|xxxx                |\n" +
						"|                    |\n" +
						"----------------------");
	}

	public void test5() {
		Rectangle r = new Rectangle(1, 1, 4, 4);
		this.canvas.addShape(r);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|xxxx                |\n" +
						"|x  x                |\n" +
						"|x  x                |\n" +
						"|xxxx                |\n" +
						"|                    |\n" +
						"----------------------");
		BucketFill b = new BucketFill(1, 1, '$');
		this.canvas.addShape(b);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|$$$$                |\n" +
						"|$  $                |\n" +
						"|$  $                |\n" +
						"|$$$$                |\n" +
						"|                    |\n" +
						"----------------------");
	}

	@Test
	public void test6() {
		Line l = new Line(1, 1, 1, 5);
		this.canvas.addShape(l);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|x                   |\n" +
						"|x                   |\n" +
						"|x                   |\n" +
						"|x                   |\n" +
						"|x                   |\n" +
						"----------------------");
	}

	@Test
	public void test7() {
		Line l = new Line(1, 1, 1, 6);
		this.exception.expect(InvalidShapeException.class);
		this.canvas.addShape(l);
	}

	@Test
	public void test8() {
		Line l1 = new Line(5, 1, 5, 4);
		this.canvas.addShape(l1);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|    x               |\n" +
						"|    x               |\n" +
						"|    x               |\n" +
						"|    x               |\n" +
						"|                    |\n" +
						"----------------------");
		Line l2 = new Line(6, 4, 10, 4);
		this.canvas.addShape(l2);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|    x               |\n" +
						"|    x               |\n" +
						"|    x               |\n" +
						"|    xxxxxx          |\n" +
						"|                    |\n" +
						"----------------------");

		Rectangle r1 = new Rectangle(11, 2, 16, 5);
		this.canvas.addShape(r1);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|    x               |\n" +
						"|    x     xxxxxx    |\n" +
						"|    x     x    x    |\n" +
						"|    xxxxxxx    x    |\n" +
						"|          xxxxxx    |\n" +
						"----------------------");

		BucketFill b1 = new BucketFill(3, 2, '$');
		this.canvas.addShape(b1);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|$$$$x               |\n" +
						"|$$$$x     xxxxxx    |\n" +
						"|$$$$x     x    x    |\n" +
						"|$$$$xxxxxxx    x    |\n" +
						"|$$$$$$$$$$xxxxxx    |\n" +
						"----------------------");

		BucketFill b2 = new BucketFill(13, 4, '^');
		this.canvas.addShape(b2);
		assertEquals(this.canvas.render(),
				"----------------------\n" +
						"|$$$$x               |\n" +
						"|$$$$x     xxxxxx    |\n" +
						"|$$$$x     x^^^^x    |\n" +
						"|$$$$xxxxxxx^^^^x    |\n" +
						"|$$$$$$$$$$xxxxxx    |\n" +
						"----------------------");
	}
}
