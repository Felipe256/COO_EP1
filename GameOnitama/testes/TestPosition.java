import org.junit.Test;
import static org.junit.Assert.*;

public class TestPosition {
    Position p1;
    Position p2;
    @Before
    public void setup() {
        p1 = new Position(3, 4);
        p2 = new Position(1, 2);
    }

    @Test
    public void linhasDevemSerTresEUm() {
        assertTrue("Coluna era pra ser um!", p2.getRow() == 1);
        assertTrue("Coluna era pra ser tres!", p1.getRow() == 3);
    }

    @Test
    public void colunasDevemSerQuatroEDois() {
        assertTrue("Coluna era pra ser dois!", p2.getCol() == 2);
        assertTrue("Coluna era pra ser quatro!", p1.getCol() == 4);
    }
}
