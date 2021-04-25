package hu.qiang.icandraw.commands;

import hu.qiang.icandraw.exceptions.InvalidCommandException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {
    private CommandFactory factory;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        this.factory = new CommandFactory();
    }

    @Test
    public void getCommand() {
        assertEquals(factory.getCommand("c 20  5").getType(), ICommand.Command.CREATE_CANVAS);

        assertEquals(factory.getCommand("L 1 1  1 10").getType(), ICommand.Command.DRAW_LINE);

        assertEquals(factory.getCommand("r 1  1 5 5").getType(), ICommand.Command.DRAW_RECTANGLE);

        assertEquals(factory.getCommand("b 1  1   #").getType(), ICommand.Command.FILL_BUCKET);

        assertEquals(factory.getCommand("q").getType(), ICommand.Command.QUIT);
    }

    @Test
    public void getInvalidCommand() {
        this.exception.expect(InvalidCommandException.class);
        factory.getCommand("A");

    }
}