import org.junit.*;

import static org.junit.Assert.*;

public class TestPiece {
    Piece p1, p2;

    @Before
    public void setup() {
        p1 = new Piece(Color.RED, true); // eh o mestre vermelho
        p2 = new Piece(Color.BLUE, false); // eh uma peca qualquer azul
    }

    @Test
    public void testeGetColor() {
        assertSame("p1 deve ser RED!", Color.RED, p1.getColor());
        assertSame("p2 deve ser BLUE!", Color.BLUE, p2.getColor());
    }

    @Test
    public void testeIsMaster() {
        assertTrue("p1 deve ser mestre!", p1.isMaster());
        assertTrue("p1 deve ser mestre!", p1.isMaster());
    }

    @Test
    public void testeIsAlive(){
        assertTrue("p1 deveria esta viva!", p1.isAlive());
        assertTrue("p2 deveria estar viva!", p2.isAlive());
    }

    @Test
    public void testeDie() {
        p1.die();
        p2.die();
        assertFalse("p1 deve estar morta!", p1.isAlive());
        assertFalse("p2 deve estar morta!", p2.isAlive());
    }
}
