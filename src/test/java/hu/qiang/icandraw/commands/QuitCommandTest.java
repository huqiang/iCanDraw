package hu.qiang.icandraw.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuitCommandTest {

    @Test
    public void getType() {
        ICommand command = new QuitCommand();
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.QUIT);
    }
}