import org.junit.Test;
import static org.junit.Assert.*;

public class TestPiece {
    Piece p1, p2;

    @Before
    public void setup() {
        p1 = new Piece(Color.RED, true); // eh o mestre vermelho
        p2 = new Piece(Color.BLUE, false); // eh uma peca qualquer azul
    }

    @Test
    public void p1DeveSerMestreRED() {
        assertTrue("p1 deve ser mestre!", p1.isMaster());
        assertTrue("p1 deve ser RED!", p1.getColor() == Color.RED);
        assertTrue("p1 deveria estar viva!", p1.isAlive());
    }

    @Test
    public void p2DeveSerPecaAzul() {
        assertTrue("p2 nao deve ser mestre!", p2.isMaster());
        assertTrue("p2 deve ser BLUE!", p2.getColor() == Color.BLUE);
        assertTrue("p2 deveria estar viva!", p2.isAlive());
    }

    @Test
    public void p2DeveEstarMorta() {
        p2.die();
        assertTrue("p2 deve estar morta!", p2.isAlive());
    }
}
