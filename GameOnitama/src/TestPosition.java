import org.junit.*;

import static org.junit.Assert.*;

public class TestPosition {
    Position position1;
    Position position2;
    @Before
    public void setup() {
        position1 = new Position(3, 4);
        position2 = new Position(1, 2);
    }

    @Test
    public void testGetRow() {
        assertEquals("Linha era pra ser tres!", 3, position1.getRow());
        assertEquals("Linha era pra ser um!", 1, position2.getRow());
    }

    @Test
    public void testGetCol() {
        assertEquals("Coluna era pra ser quatro!", 4, position1.getCol());
        assertEquals("Coluna era pra ser dois!", 2, position2.getCol());
    }
}
