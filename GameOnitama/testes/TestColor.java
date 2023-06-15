import org.junit.Test;
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
        assertTrue("Devia ser RED!", red == Color.RED);
        assertFalse("Nao devia ser RED mas BLUE!", blue == Color.RED);
        assertFalse("Nao devia ser RED mas NONE!", none == Color.RED);
    }

    @Test
    public void testeEhBLUE() {
        assertFalse("Nao devia ser BLUE mas RED!", red == Color.BLUE);
        assertTrue("Devia ser BLUE!", blue == Color.BLUE);
        assertFalse("Nao devia ser BLUE mas NONE!", none == Color.BLUE);
    }

    @Test
    public void testeEhNONE() {
        assertFalse("Nao devia ser NONE mas RED!", red == Color.NONE);
        assertFalse("Nao devia ser NONE mas BLUE!", blue == Color.NONE);
        assertTrue("Devia ser NONE!", none == Color.NONE);
    }
}
