import org.junit.*;

import static org.junit.Assert.*;

public class TestPiece {
    Piece piece1, piece2;

    @Before
    public void setup() {
        piece1 = new Piece(Color.RED, true); // eh o mestre vermelho
        piece2 = new Piece(Color.BLUE, false); // eh uma peca qualquer azul
    }

    @Test
    public void testeGetColor() {
        assertSame("p1 deve ser RED!", Color.RED, piece1.getColor());
        assertSame("p2 deve ser BLUE!", Color.BLUE, piece2.getColor());
    }

    @Test
    public void testeIsMaster() {
        assertTrue("p1 deve ser mestre!", piece1.isMaster());
        assertTrue("p1 deve ser mestre!", piece1.isMaster());
    }

    @Test
    public void testeIsAlive(){
        assertTrue("p1 deveria esta viva!", piece1.isAlive());
        assertTrue("p2 deveria estar viva!", piece2.isAlive());
    }

    @Test
    public void testeDie() {
        piece1.die();
        piece2.die();
        assertFalse("p1 deve estar morta!", piece1.isAlive());
        assertFalse("p2 deve estar morta!", piece2.isAlive());
    }
}
