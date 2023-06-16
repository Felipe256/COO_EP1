import org.junit.*;

import static org.junit.Assert.*;

public class TestColor {
    Color red;
    Color blue;
    Color none;

    @Before
    public void setup() {
        red = Color.RED;
        blue = Color.BLUE;
        none = Color.NONE;
    }

    @Test
    public void testeEhRED() {
        assertSame("Devia ser RED!", red, Color.RED);
        assertNotSame("Nao devia ser RED mas BLUE!", blue, Color.RED);
        assertNotSame("Nao devia ser RED mas NONE!", none, Color.RED);
    }

    @Test
    public void testeEhBLUE() {
        assertNotSame("Nao devia ser BLUE mas RED!", red, Color.BLUE);
        assertSame("Devia ser BLUE!", blue, Color.BLUE);
        assertNotSame("Nao devia ser BLUE mas NONE!", none, Color.BLUE);
    }

    @Test
    public void testeEhNONE() {
        assertNotSame("Nao devia ser NONE mas RED!", red, Color.NONE);
        assertNotSame("Nao devia ser NONE mas BLUE!", blue, Color.NONE);
        assertSame("Devia ser NONE!", none, Color.NONE);
    }
}
