package hu.qiang.icandraw.commands;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DrawRectangleCommandTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreate() {
        DrawRectangleCommand command = new DrawRectangleCommand("1,2,3,10".split(","));
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.DRAW_RECTANGLE);
        assertTrue(command.getX1() == 1);
        assertTrue(command.getY1() == 2);
        assertTrue(command.getX2() == 3);
        assertTrue(command.getY2() == 10);
    }

    @Test
    public void testCreateWithException1() {
        this.exception.expect(InvalidCommandParamException.class);
        DrawRectangleCommand command = new DrawRectangleCommand("1,2".split(","));
    }

    @Test
    public void testCreateWithException2() {
        this.exception.expect(InvalidCommandParamException.class);
        DrawRectangleCommand command = new DrawRectangleCommand("1,2,1,4".split(","));
    }

    @Test
    public void testCreateWithException3() {
        this.exception.expect(InvalidCommandParamException.class);
        DrawRectangleCommand command = new DrawRectangleCommand("-1,2,1,4".split(","));
    }

    @Test
    public void testCreateWithException4() {
        this.exception.expect(InvalidCommandParamException.class);
        DrawRectangleCommand command = new DrawRectangleCommand("1,2,#,$".split(","));
    }


}