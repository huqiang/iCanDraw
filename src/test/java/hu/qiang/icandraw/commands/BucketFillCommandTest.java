package hu.qiang.icandraw.commands;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BucketFillCommandTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreate() {
        DrawCommand command = new BucketFillCommand("1,2,#".split(","));
        assertNotNull(command);
        assertEquals(command.getType(), ICommand.Command.FILL_BUCKET);

        BucketFillCommand bucketFillCommand = (BucketFillCommand) command;
        assertEquals(bucketFillCommand.getX(), 1);
        assertEquals(bucketFillCommand.getY(), 2);
        assertEquals(bucketFillCommand.getCharacter(), '#');
    }

    @Test
    public void testCreateWithException() {
        this.exception.expect(InvalidCommandParamException.class);
        new BucketFillCommand("1,2".split(","));
    }


    @Test
    public void testCreateWithException2() {
        this.exception.expect(InvalidCommandParamException.class);
        new BucketFillCommand("-1,2,#".split(","));
    }

    @Test
    public void testCreateWithException3() {
        this.exception.expect(InvalidCommandParamException.class);
        new BucketFillCommand("#,1,2".split(","));
    }

    @Test
    public void testCreateWithException4() {
        this.exception.expect(InvalidCommandParamException.class);
        new BucketFillCommand("1,2,#@#".split(","));
    }

    @Test
    public void testCreateWithException5() {
        this.exception.expect(InvalidCommandParamException.class);
        new BucketFillCommand("1,2,".split(","));
    }

    @Test
    public void testCreateWithException6() {
        this.exception.expect(InvalidCommandParamException.class);
        new BucketFillCommand("1,2,#,$".split(","));

    }
}