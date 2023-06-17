import org.junit.*;

import static org.junit.Assert.*;

public class TestPlayer {
	Card card1;
	Card card2;
	Card card3;
	Card card4;
	Card[] expectedPlayer1CardsAfterSwap;
	Card[] expectedPlayer2CardsAfterSwap;
	Position[] positionCard1;
	Position[] positionCard2;
	Position[] positionCard3;
	Position[] positionCard4;
	String nameCard1;
	String nameCard2;
	String nameCard3;
	String nameCard4;
	String namePlayer1;
	String namePlayer2;
	Color red;
	Color blue;
	Player player1;
	Player player2;
	
	@Before
	public void setup() {
		positionCard1 = new Position[]{new Position(+1, 0), new Position(-2, 0)};
        positionCard2 = new Position[]{new Position(-1, -2), new Position(+1, -1), new Position(+1, +1), new Position(-1, +2)};
        positionCard3 = new Position[]{new Position(0, -2), new Position(-1, -1), new Position(+1, +1)};
        positionCard4 = new Position[]{new Position(+1, -1), new Position(-1, +1), new Position(0, +2)};
        nameCard1 = "Tiger";
        nameCard2 = "Dragon";
        nameCard3 = "Frog";
        nameCard4 = "Rabbit";
        red = Color.RED;
        blue = Color.BLUE;
		card1 = new Card(nameCard1, blue, positionCard1);
		card2 = new Card(nameCard2, red, positionCard2);
		card3 = new Card(nameCard3, red, positionCard3);
		card4 = new Card(nameCard4, blue, positionCard4);
		expectedPlayer1CardsAfterSwap = new Card[]{card3, card4};
		expectedPlayer2CardsAfterSwap = new Card[]{card1, card2};
		namePlayer1 = "Mané";
		namePlayer2 = "Bobão";
		player1 = new Player(namePlayer1, red, card1, card2);
		player2 = new Player(namePlayer2, blue, expectedPlayer1CardsAfterSwap);
	}
	
	@Test
	public void testGetName() {
		assertEquals("Deveria der Mané!", player1.getName(), namePlayer1);
		assertEquals("Deveria der Bobão!", player2.getName(), namePlayer2);
	}
	
	@Test
	public void testGetPieceColor() {
		assertEquals("Deveria ser RED!", player1.getPieceColor(), red);
		assertEquals("Deveria ser BLUE!", player2.getPieceColor(), blue);
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
	public void testGetCardsDeveSerC1C2C5() {
		Card[] player1Cards = player1.getCards();
		Card[] player2Cards = player2.getCards();
		assertEquals("Número de cartas diferentes em pl1!", 2, player1Cards.length);
		assertEquals("Número de cartas diferentes em pl2!", 2, player2Cards.length);
		for(int i = 0; i < player1Cards.length; i++) {
			assertTrue("Carta errada!", sameCard(player1Cards[i], expectedPlayer2CardsAfterSwap[i]));
			assertTrue("Carta errada!", sameCard(player2Cards[i], expectedPlayer1CardsAfterSwap[i]));
		}
	}
	
	@Test
	public void testSwapCardDeveSerC3C4C1C2() {
		player1.swapCard(card1, card3);
		player1.swapCard(card2, card4);
		player2.swapCard(card3, card1);
		player2.swapCard(card4, card2);
		Card[] currentPlayer1Cards = player1.getCards();
		Card[] currentPlayer2Cards = player2.getCards();
		for(int i = 0; i < currentPlayer1Cards.length; i++) {
			assertTrue("Carta errada!", sameCard(currentPlayer1Cards[i], expectedPlayer1CardsAfterSwap[i]));
			assertTrue("Carta errada!", sameCard(currentPlayer2Cards[i], expectedPlayer2CardsAfterSwap[i]));
		}
		assertThrows(InvalidCardException.class, () -> player1.swapCard(card1, card4));
		assertThrows(InvalidCardException.class, () -> player2.swapCard(card3, card2));
	}
}
