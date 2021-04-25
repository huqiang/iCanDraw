package hu.qiang.icandraw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AppTest {
    private App app;
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.app = new App();
    }

    @Test
    public void getHelp() {
        Assert.assertNotNull(this.app);
        Assert.assertNotNull(this.app.getHelp());
    }

}