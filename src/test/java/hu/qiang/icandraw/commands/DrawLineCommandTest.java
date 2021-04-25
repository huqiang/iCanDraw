package hu.qiang.icandraw.commands;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DrawLineCommandTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreate() {
        DrawLineCommand command = new DrawLineCommand("1,2,1,10".split(","));
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.DRAW_LINE);
        assertTrue(command.getX1() == 1);
        assertTrue(command.getY1() == 2);
        assertTrue(command.getX2() == 1);
        assertTrue(command.getY2() == 10);
    }

    @Ignore
    @Test
    public void testCreate2() {
        DrawLineCommand command = new DrawLineCommand("1,2,2,3".split(","));
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.DRAW_LINE);
        assertTrue(command.getX1() == 1);
        assertTrue(command.getY1() == 2);
        assertTrue(command.getX2() == 2);
        assertTrue(command.getY2() == 3);
    }

    @Test
    public void testCreateWithException1() {
        this.exception.expect(InvalidCommandParamException.class);
        DrawLineCommand command = new DrawLineCommand("1,2".split(","));
    }

    @Test
    public void testCreateWithException2() {
        this.exception.expect(InvalidCommandParamException.class);
        DrawLineCommand command = new DrawLineCommand("1,2,2,3".split(","));
    }

    @Test
    public void testCreateWithException3() {
        this.exception.expect(InvalidCommandParamException.class);
        DrawLineCommand command = new DrawLineCommand("-1,2".split(","));
    }

    @Test
    public void testCreateWithException4() {
        this.exception.expect(InvalidCommandParamException.class);
        DrawLineCommand command = new DrawLineCommand("1,2,#,$".split(","));
    }
}