package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.commands.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShapeFactoryTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getShape() {
        ShapeFactory factory = new ShapeFactory();
        assertNotNull(factory);
    }

    @Test
    public void testDrawLine() {
        ShapeFactory factory = new ShapeFactory();
        DrawCommand command = new DrawLineCommand("1,1,1,5".split(","));
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.DRAW_LINE);
        IShape line = factory.getShape(command);
        assertNotNull(line);
        assertEquals(line.getShapeName(), IShape.ShapeName.LINE);
    }

    @Test
    public void testDrawRectangle() {
        ShapeFactory factory = new ShapeFactory();
        DrawCommand command = new DrawRectangleCommand("1,1,3,5".split(","));
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.DRAW_RECTANGLE);
        IShape rectangle = factory.getShape(command);
        assertNotNull(rectangle);
        assertEquals(rectangle.getShapeName(), IShape.ShapeName.RECTANGLE);
    }

    @Test
    public void testDrawBucketFill() {
        ShapeFactory factory = new ShapeFactory();
        DrawCommand command = new BucketFillCommand("1,1,#".split(","));
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.FILL_BUCKET);
        IShape bucketFill = factory.getShape(command);
        assertNotNull(bucketFill);
        assertEquals(bucketFill.getShapeName(), IShape.ShapeName.BUCKET);
    }

    @Test
    public void testInvalidParamException() {
        ShapeFactory factory = new ShapeFactory();
        this.exception.expect(InvalidParameterException.class);
        IShape shape = factory.getShape(new DrawCommand() {

            @Override
            public Command getType() {
                return Command.QUIT;
            }
        });
    }
}