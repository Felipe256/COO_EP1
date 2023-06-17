import org.junit.*;

import static org.junit.Assert.*;

public class TestSpot {
    Spot spot1;
    Spot spot2;
    Spot spot3;
    Piece piece1;
    Piece piece2;
    Position position1;
    Position position2;
    Position position3;

    @Before
    public void setup() {
        piece1 = new Piece(Color.RED, true); // mestre vermelho
        piece2 = new Piece(Color.BLUE, false); // aluno azul
        position1 = new Position(4, 2); // valida
        position2 = new Position(1, 2); // valida
        position3 = new Position(0, 5); // invalida
        spot1 = new Spot(piece1, position1, Color.RED);
        spot2 = new Spot(piece2, position2);
        spot3 = new Spot(position3);
    }

    @Test
    public void testGetPosition() {
        assertTrue("A posicao deveria ser (4, 2)!", ((position1.getRow() == spot1.getPosition().getRow()) && (position1.getCol() == spot1.getPosition().getCol())));
        assertTrue("A posicao deveria ser (1, 2)!", ((position2.getRow() == spot2.getPosition().getRow()) && (position2.getCol() == spot2.getPosition().getCol())));
        assertTrue("A posicao deveria ser (0, 5)!", ((position3.getRow() == spot3.getPosition().getRow()) && (position3.getCol() == spot3.getPosition().getCol())));
    }

    @Test
    public void testGetPiece() {
        assertTrue("A peca deveria ser o mestre vermelho!", ((spot1.getPiece().getColor() == Color.RED) && spot1.getPiece().isMaster()));
        assertTrue("A peca deveria ser um aluno azul!", ((spot2.getPiece().getColor() == Color.BLUE) && (!spot2.getPiece().isMaster())));
        assertNull("A peca deveria ser nula!", spot3.getPiece());
    }

    @Test
    public void testGetColor() {
        assertSame("A cor deveria valer RED!", spot1.getColor(), Color.RED);
        assertSame("A cor deveria valer NONE!", spot2.getColor(), Color.NONE);
        assertSame("A cor deveria valer NONE!", spot3.getColor(), Color.NONE);
    }

    @Test
    public void testIsValid() {
        assertTrue("A posicao deveria ser valida!", spot1.isValid());
        assertTrue("A posicao deveria ser valida!", spot2.isValid());
        assertFalse("A posicao deveria ser invalida!", spot3.isValid());
    }

    @Test
    public void testOccupySpot() {
        Piece notMasterPiece = new Piece(Color.RED, false);
        assertThrows(IllegalMovementException.class, () -> spot1.occupySpot(notMasterPiece));

        spot2.occupySpot(notMasterPiece);
        assertTrue("A peca deveria ser um aluno vermelho!", (spot2.getPiece().getColor() == Color.RED) && (!spot2.getPiece().isMaster()));

        spot3.occupySpot(notMasterPiece);
        assertTrue("A peca deveria ser um aluno vermelho!", (spot3.getPiece().getColor() == Color.RED) && (!spot3.getPiece().isMaster()));

    }

    @Test
    public void testReleaseSpot() {
        spot1.releaseSpot();
        assertNull("A peca deveria ser nula!", spot1.getPiece());
        spot2.releaseSpot();
        assertNull("A peca deveria ser nula!", spot2.getPiece());
        spot3.releaseSpot();
        assertNull("A peca deveria ser nula!", spot3.getPiece());
    }
}
