import org.junit.*;

import static org.junit.Assert.*;

public class TestCard {
	Card card1;
	Card card2;
	Position[] posCard1;
	Position[] posCard2;
	String nameCard1;
	String nameCard2;
	Color colorCard1;
	Color colorCard2;
	
	@Before
	public void setup() {
		posCard1 = new Position[]{new Position(1,0), new Position(-2,0)};
		nameCard1 = "Tiger";
		colorCard1 = Color.BLUE;
		card1 = new Card(nameCard1, colorCard1, posCard1);
		posCard2 = new Position[]{new Position(3, 3), new Position(1, 4)};
		nameCard2 = "Elephant";
		colorCard2 = Color.RED;
		card2 = new Card(nameCard2,colorCard2, posCard2);
	}
	
	@Test
	public void testeGetName() {
		assertEquals("Deveria ser Tiger!", nameCard1, card1.getName());
		assertEquals("Deveria ser Elephant!", nameCard2, card2.getName());
	}
	
	@Test
	public void testeGetColor() {
		assertSame("Deveria ser BLUE!", colorCard1, card1.getColor());
		assertSame("Deveria ser RED!", colorCard2, card2.getColor());
	}
	
	@Test
	public void testeGetPositions() {
		Position[] currentPosCard1 = card1.getPositions();
		Position[] currentPosCard2 = card2.getPositions();
		assertTrue("Row deveria valer 1 e -2!", (posCard1[0].getRow() == currentPosCard1[0].getRow())&&(posCard1[1].getRow() == currentPosCard1[1].getRow()));
		assertTrue("Col deveria valer 0 e 0!", (posCard1[0].getCol() == currentPosCard1[0].getCol())&&(posCard1[1].getCol() == currentPosCard1[1].getCol()));
		assertTrue("Row deveria valer 3 e 1!", (posCard1[0].getRow() == currentPosCard1[0].getRow())&&(posCard1[1].getRow() == currentPosCard1[1].getRow()));
		assertTrue("Col deveria valer 3 e 4!", (posCard2[0].getCol() == currentPosCard2[0].getCol())&&(posCard2[1].getCol() == currentPosCard2[1].getCol()));
	}
	
	@Test
	public void testeCreateCards() {
		Card[] cards = Card.createCards();
		assertEquals("Tamanho esperado é 5!", 5, cards.length);
        for(Card testingCard : cards)
			assertNotNull("Carta invalida!", testingCard);
	}
}
