package hu.qiang.icandraw.commands;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CreateCanvasCommandTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreate() {
        CreateCanvasCommand command = new CreateCanvasCommand("10,20".split(","));
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.CREATE_CANVAS);
        assertTrue(command.getHeight() == 20);
        assertTrue(command.getWidth() == 10);
    }

    @Test
    public void testMissingParam() {
        this.exception.expect(InvalidCommandParamException.class);
        new CreateCanvasCommand("10,".split(","));
    }

    @Test
    public void testNegativeSize() {
        this.exception.expect(InvalidCommandParamException.class);
        new CreateCanvasCommand("10,-20".split(","));
    }

    @Test
    public void testNegativeSize2() {
        this.exception.expect(InvalidCommandParamException.class);
        new CreateCanvasCommand("-10,20".split(","));
    }

    @Test
    public void testNegativeSize3() {
        this.exception.expect(InvalidCommandParamException.class);
        new CreateCanvasCommand("-10,-20".split(","));
    }

    @Test
    public void testInvalidSize() {
        this.exception.expect(InvalidCommandParamException.class);
        new CreateCanvasCommand("10,#".split(","));
    }

    @Test
    public void testInvalidSize2() {
        this.exception.expect(InvalidCommandParamException.class);
        new CreateCanvasCommand("10,bc".split(","));
    }
}