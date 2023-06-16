import org.junit.*;

import static org.junit.Assert.*;

public class TestPlayer {
	Card c1;
	Card c2;
	Card c3;
	Card c4;
	Card[] c5;
	Card[] c6;
	Position[] p1;
	Position[] p2;
	Position[] p3;
	Position[] p4;
	String nc1;
	String nc2;
	String nc3;
	String nc4;
	String n1;
	String n2;
	Color red;
	Color blue;
	Player pl1;
	Player pl2;
	
	@Before
	public void setup() {
		p1 = new Position[]{new Position(+1, 0), new Position(-2, 0)};
        p2 = new Position[]{new Position(-1, -2), new Position(+1, -1), new Position(+1, +1), new Position(-1, +2)};
        p3 = new Position[]{new Position(0, -2), new Position(-1, -1), new Position(+1, +1)};
        p4 = new Position[]{new Position(+1, -1), new Position(-1, +1), new Position(0, +2)};
        nc1 = "Tiger";
        nc2 = "Dragon";
        nc3 = "Frog";
        nc4 = "Rabbit";
        red = Color.RED;
        blue = Color.BLUE;
		c1 = new Card(nc1, blue, p1);
		c2 = new Card(nc2, red, p2);
		c3 = new Card(nc3, red, p3);
		c4 = new Card(nc4, blue, p4);
		c5 = new Card[]{c3, c4};
		c6 = new Card[]{c1, c2};
		n1 = "Mané";
		n2 = "Bobão";
		pl1 = new Player(n1, red, c1, c2);
		pl2 = new Player(n2, blue, c5);
	}
	
	@Test
	public void testeGetName() {
		assertEquals("Deveria der Mané!", pl1.getName(), n1);
		assertEquals("Deveria der Bobão!", pl2.getName(), n2);
	}
	
	@Test
	public void testeGetPieceColor() {
		assertEquals("Deveria ser RED!", pl1.getPieceColor(), red);
		assertEquals("Deveria ser BLUE!", pl2.getPieceColor(), blue);
	}
	
	private boolean sameCard(Card a, Card b) {
		if(a == b)
			return true;
		if(!a.getName().equals(b.getName()))
			return false;
		if(!a.getColor().equals(b.getColor()))
			return false;
		Position[] c = a.getPositions();
		Position[] d = b.getPositions();
		if(c.length != d.length)
			return false;
		for(int i = 0; i < c.length; i++)
			if(c[i].getRow() != d[i].getRow() || c[i].getCol() != d[i].getCol())
				return false;
		return true;
	}
	
	@Test
	public void testeGetCardsDeveSerC1C2C5() {
		Card[] ret1 = pl1.getCards();
		Card[] ret2 = pl2.getCards();
		assertEquals("Número de cartas diferentes em pl1!", 2, ret1.length);
		assertEquals("Número de cartas diferentes em pl2!", 2, ret2.length);
		for(int i = 0; i < ret1.length; i++) {
			assertTrue("Carta errada!", sameCard(ret1[i], c6[i]));
			assertTrue("Carta errada!", sameCard(ret2[i], c5[i]));
		}
	}
	
	@Test
	public void testeSwapCardDeveSerC3C4C1C2() {
		pl1.swapCard(c1, c3);
		pl1.swapCard(c2, c4);
		pl2.swapCard(c3, c1);
		pl2.swapCard(c4, c2);
		Card[] ret1 = pl1.getCards();
		Card[] ret2 = pl2.getCards();
		for(int i = 0; i < ret1.length; i++) {
			assertTrue("Carta errada!", sameCard(ret1[i], c5[i]));
			assertTrue("Carta errada!", sameCard(ret2[i], c6[i]));
		}
	}
}
