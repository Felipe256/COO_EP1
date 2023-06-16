import org.junit.*;

import static org.junit.Assert.*;

public class TestSpot {
    Spot s1;
    Spot s2;
    Spot s3;
    Piece p1;
    Piece p2;
    Position pos1;
    Position pos2;
    Position pos3;

    @Before
    public void setup() {
        p1 = new Piece(Color.RED, true); // mestre vermelho
        p2 = new Piece(Color.BLUE, false); // aluno azul
        pos1 = new Position(4, 2); // valida
        pos2 = new Position(1, 2); // valida
        pos3 = new Position(0, 5); // invalida
        s1 = new Spot(p1, pos1, Color.RED);
        s2 = new Spot(p2, pos2);
        s3 = new Spot(pos3);
    }

    @Test
    public void testePosicaoSpot() {
        assertTrue("A posicao deveria ser (4, 2)!", ((pos1.getRow() == s1.getPosition().getRow()) && (pos1.getCol() == s1.getPosition().getCol())));
        assertTrue("A posicao deveria ser (1, 2)!", ((pos2.getRow() == s2.getPosition().getRow()) && (pos2.getCol() == s2.getPosition().getCol())));
        assertTrue("A posicao deveria ser (0, 5)!", ((pos3.getRow() == s3.getPosition().getRow()) && (pos3.getCol() == s3.getPosition().getCol())));
    }

    @Test
    public void testeGetPiece() {
        assertTrue("A peca deveria ser o mestre vermelho!", ((s1.getPiece().getColor() == Color.RED) && s1.getPiece().isMaster()));
        assertTrue("A peca deveria ser um aluno azul!", ((s2.getPiece().getColor() == Color.BLUE) && (!s2.getPiece().isMaster())));
        assertNull("A peca deveria ser nula!", s3.getPiece());
    }

    @Test
    public void testeGetColor() {
        assertSame("A cor deveria valer RED!", s1.getColor(), Color.RED);
        assertSame("A cor deveria valer NONE!", s2.getColor(), Color.NONE);
        assertSame("A cor deveria valer NONE!", s3.getColor(), Color.NONE);
    }

    @Test
    public void testePosicaoValida() {
        assertTrue("A posicao deveria ser valida!", s1.isValid());
        assertTrue("A posicao deveria ser valida!", s2.isValid());
        assertFalse("A posicao deveria ser invalida!", s3.isValid());
    }

    @Test
    public void testeOccupySpot() {
        Piece aux = new Piece(Color.RED, false);
        Exception e = assertThrows(RuntimeException.class, () -> s1.occupySpot(aux));
        assertTrue("Excecao lancada deveria ser instancia de IllegalMovementException!", e instanceof IllegalMovementException);

        s2.occupySpot(aux);
        assertTrue("A peca deveria ser um aluno vermelho!", (s2.getPiece().getColor() == Color.RED) && (!s2.getPiece().isMaster()));

        s3.occupySpot(aux);
        assertTrue("A peca deveria ser um aluno vermelho!", (s3.getPiece().getColor() == Color.RED) && (!s3.getPiece().isMaster()));

    }

    @Test
    public void testeReleaseSpot() {
        s1.releaseSpot();
        assertNull("A peca deveria ser nula!", s1.getPiece());
        s2.releaseSpot();
        assertNull("A peca deveria ser nula!", s2.getPiece());
        s3.releaseSpot();
        assertNull("A peca deveria ser nula!", s3.getPiece());
    }
}
