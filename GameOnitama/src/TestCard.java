import org.junit.*;

import static org.junit.Assert.*;

public class TestCard {
	Card c;
	Position[] posC;
	String nameC;
	Color colorC;
	
	@Before
	public void setup() {
		posC = new Position[]{new Position(1,0), new Position(-1,0)};
		nameC = "Tiger";
		colorC = Color.BLUE;
		c = new Card(nameC, colorC, posC);
	}
	
	@Test
	public void testeGetName() {
		assertEquals("Deveria ser Tiger!", nameC, c.getName());
	}
	
	@Test
	public void testeGetColor() {
		assertSame("Deveria ser BLUE!", colorC, c.getColor());
	}
	
	@Test
	public void testeGetPositions() {
		Position[] got = c.getPositions();
		assertTrue("Row deveria valer 1 e -2!", (posC[0].getRow() == got[0].getRow())&&(posC[1].getRow() == got[1].getRow()));
		assertTrue("Col deveria valer 0 e 0!", (posC[0].getCol() == got[0].getCol())&&(posC[1].getCol() == got[1].getCol()));
	}
	
	@Test
	public void testeCreateCards() {
		Card[] cards = Card.createCards();
		assertEquals("Tamanho esperado é 5!", 5, cards.length);
        for(Card testingCard : cards)
			assertNotNull("Carta invalida!", testingCard);
	}
}
