import org.junit.*;

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
    public void testeGetRow() {
        assertEquals("Coluna era pra ser um!", 1, p2.getRow());
        assertEquals("Coluna era pra ser tres!", 3, p1.getRow());
    }

    @Test
    public void colunasDevemSerQuatroEDois() {
        assertEquals("Coluna era pra ser dois!", 2, p2.getCol());
        assertEquals("Coluna era pra ser quatro!", 4, p1.getCol());
    }
}
