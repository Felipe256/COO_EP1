import org.junit.*;
import static org.junit.Assert.*;

public class TestGameImpl {
	Game[] games;
	String redPlayerName1;
	String bluePlayerName1;
	String redPlayerName2;
	String bluePlayerName2;
	Card cardTiger;
	Card cardDragon;
	Card cardFrog;
	Card cardRabbit;
	Card cardCrab;
	Card[] cardDeck;
	Color red;
	Color blue;
	Color none;
	Position[] positionTiger;
	Position[] positionDragon;
	Position[] positionFrog;
	Position[] positionRabbit;
	Position[] positionCrab;
	Position redSpot;
	Position blueSpot;
	String[] cardNames;
	
	
	
	
	@Before
	public void setup() {
		redPlayerName1 = "Maria";
		bluePlayerName1 = "Marta";
		redPlayerName2 = "Jaime";
		bluePlayerName2 = "Alexandre";
		positionTiger = new Position[]{new Position(+1, 0), new Position(-2, 0)};
        positionDragon = new Position[]{new Position(-1, -2), new Position(+1, -1), new Position(+1, +1), new Position(-1, +2)};
        positionFrog = new Position[]{new Position(0, -2), new Position(-1, -1), new Position(+1, +1)};
        positionRabbit = new Position[]{new Position(+1, -1), new Position(-1, +1), new Position(0, +2)};
        positionCrab = new Position[]{new Position(0, -2), new Position(-1, 0), new Position(0, +2)};
        cardNames = new String[]{"Tiger", "Dragon", "Frog", "Rabbit", "Crab"};
        red = Color.RED;
        blue = Color.BLUE;
        none = Color.NONE;
        cardTiger = new Card(cardNames[0], blue, positionTiger);
        cardDragon = new Card(cardNames[1], red, positionDragon);
        cardFrog = new Card(cardNames[2], red, positionFrog);
        cardRabbit = new Card(cardNames[3], blue, positionRabbit);
        cardCrab = new Card(cardNames[4], blue, positionCrab);
        cardDeck = new Card[]{cardTiger, cardDragon, cardFrog, cardRabbit, cardCrab};
        redSpot = new Position(4, 2);
        blueSpot = new Position(0, 2);
        Game game1 = new GameImpl();
		Game game2 = new GameImpl(redPlayerName1, bluePlayerName1);
		Game game3 = new GameImpl(redPlayerName2, bluePlayerName2, cardDeck);
		games = new Game[]{game1, game2, game3};
	}
	
	private boolean samePosition(Position pos1, Position pos2) {
		if(pos1 == pos2)
			return true;
		if(pos1.getRow() != pos2.getRow())
			return false;
		return pos1.getCol() == pos2.getCol();
	}
	
	@Test
	public void testGetSpotColor() {
		Position currentPosition;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				currentPosition = new Position(i, j);
				for(Game currentGame : games){
					Color currentColor = currentGame.getSpotColor(currentPosition);
					switch(currentColor) {
						case RED:
							assertTrue("Não deveria ser vermelho!", samePosition(currentPosition, redSpot));
							break;
						case BLUE:
							assertTrue("Não deveria ser azul!", samePosition(currentPosition, blueSpot));
							break;
						default:
							assertEquals("Deveria não ter cor!", currentColor, none);
					}
				}
			}
		}
	}
	
	@Test
	public void testGetPiece() {
		Position currentPosition;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				currentPosition = new Position(i, j);
				for(Game currentGame : games) {
					Piece currentPiece = currentGame.getPiece(currentPosition);
					if (i == 0) { // deve ter peças azuis
						assertEquals("Peça deveria ser BLUE!", blue, currentPiece.getColor());
						assertTrue("Peça deveria estar viva!", currentPiece.isAlive());
						if (j == 2) { // deve ser mestre
							assertTrue("Peça deveria ser o mestre!", currentPiece.isMaster());
						} else { // não pode ser mestre
							assertFalse("Peça não deveria ser o mestre!", currentPiece.isMaster());
						}
					} else if (i == 4) { // deve ter peças vermelhas
						assertEquals("Peça deveria ser RED!", red, currentPiece.getColor());
						assertTrue("Peça deveria estar viva!", currentPiece.isAlive());
						if (j == 2) { // deve ser mestre
							assertTrue("Peça deveria ser o mestre!", currentPiece.isMaster());
						} else { // não pode ser mestre
							assertFalse("Peça não deveria ser o mestre!", currentPiece.isMaster());
						}
					} else {
						assertNull("Peça não deveria existir!", currentPiece);
					}
				}
			}
		}
	}
	
	@Test
	public void testGetTableCard() {
		for(Game currentGame : games){
			Card tableCard = currentGame.getTableCard();
			assertNotNull("Carta inválida!", tableCard);
		}
	}

	@Test
	public void testGetRedPlayer() {
		String[] correctNames = {"Anonymous1", redPlayerName1, redPlayerName2};
		for(int i = 0; i < games.length; i++) {
			Player redPlayer = games[i].getRedPlayer();
			Card[] redPlayerCards = redPlayer.getCards();
			assertEquals("Nome do jogador vermelho esta errado", correctNames[i], redPlayer.getName());
			assertEquals("A cor deveria ser RED!", red, redPlayer.getPieceColor());
			assertNotNull("Carta 1 de Anonymous1 inválida!", redPlayerCards[0]);
			assertNotNull("Carta 2 de Anonymous1 inválida!", redPlayerCards[1]);
		}
	}

	@Test
	public void testGetBluePlayer() {
		String[] correctNames = {"Anonymous2", bluePlayerName1, bluePlayerName2};
		for(int i = 0; i < games.length; i++) {
			Player bluePlayer = games[i].getBluePlayer();
			Card[] bluePlayerCards = bluePlayer.getCards();
			assertEquals("Nome do jogador azul esta errado", correctNames[i], bluePlayer.getName());
			assertEquals("A cor deveria ser BLUE!", blue, bluePlayer.getPieceColor());
			assertNotNull("Carta 1 de Anonymous2 inválida!", bluePlayerCards[0]);
			assertNotNull("Carta 2 de Anonymous2 inválida!", bluePlayerCards[1]);
		}
	}

	@Test
	public void testExceptionConstrutor3() {
		Card[] teste = {cardTiger, cardDragon, cardFrog, cardRabbit};
		assertThrows(IllegalArgumentException.class, () -> new GameImpl("aaa", "bbb", teste));
	}
	
	@Test
	public void testMakeMoveHappyPath() {
		Position[] cardPosition = {new Position(+1, 0), new Position(-1, 0)};
		Card[] gameCards = new Card[5];
		for(int i = 0; i < 5; i++)
			gameCards[i] = new Card("Teste", red, cardPosition);
		String nameRedPlayer = "João";
		String nameBluePlayer = "Maria";
		GameImpl gameTest = new GameImpl(nameRedPlayer, nameBluePlayer, gameCards);
		gameTest.makeMove(gameCards[3], cardPosition[1], new Position(4, 2));
		Color turn = gameTest.getColorTurn();
		assertEquals("Deveria ser o turn do BLUE!",blue, turn);
		gameTest.makeMove(gameCards[1], cardPosition[0], new Position(0, 2));
		turn = gameTest.getColorTurn();
		assertEquals("Deveria ser o turn do RED!", red, turn);
	}
	
	@Test
	public void testMakeMoveUnhappyPath() {
		for(Game currentGame : games){
			// Pos atual não existe no tabuleiro
			assertThrows(InvalidPieceException.class, () -> currentGame.makeMove(cardTiger, new Position(0, 0), new Position(10, 10)));
			// Nenhuma peça na pos atual
			assertThrows(InvalidPieceException.class, () -> currentGame.makeMove(cardTiger, new Position(0, 0), new Position(3, 1)));
			// tentou jogar no turno errado
			Color currentTurn = currentGame.getTableCard().getColor();
			Position correctPosition;
			Position incorrectPosition;
			Position incorrectMove;
			Position incorrectNewCardMove;
			Position[] newCardMoves = {new Position(-1, -2), new Position(+1, -2)};
			Card newCard = new Card("NotInHand", red, newCardMoves);
			if(currentTurn.equals(red)) {
				incorrectPosition = new Position(0, 2);
				correctPosition = new Position(4, 2);
				incorrectMove = new Position(1, 1);
				incorrectNewCardMove = newCardMoves[0];
			}else {
				incorrectPosition = new Position(4, 2);
				correctPosition = new Position(0, 2);
				incorrectMove = new Position(-1, -1);
				incorrectNewCardMove = newCardMoves[1];
			}
			assertThrows(IncorrectTurnOrderException.class, () -> currentGame.makeMove(cardTiger, new Position(0, 0), incorrectPosition));

			// não escolheu nenhum movimento
			assertThrows(IllegalMovementException.class, () -> currentGame.makeMove(cardTiger, null, correctPosition));

			// nenhuma carta selecionada
			assertThrows(InvalidCardException.class, () -> currentGame.makeMove(null, new Position(0, 0), correctPosition));

			// Movimento inválido, pois peça ficará fora do tabuleiro
			assertThrows(IllegalMovementException.class, () -> currentGame.makeMove(cardFrog, incorrectMove, correctPosition));

			// Impossível mover para um spot ocupado por outra peça do mesmo jogador
			assertThrows(IllegalMovementException.class, () -> currentGame.makeMove(cardFrog, new Position(0, -2), correctPosition));

			// Movimento impossível com a carta usada
			assertThrows(IllegalMovementException.class, () -> currentGame.makeMove(cardFrog, new Position(-1, -2), correctPosition));

			// Carta não está com o jogador
			assertThrows(InvalidCardException.class, () -> currentGame.makeMove(newCard, incorrectNewCardMove, correctPosition));
		}
	}
	
	@Test
	public void testCheckVictory() {
		Position[] cardMoves = {new Position(+4, 0), new Position(-4, 0), new Position(+3, 0), new Position(-3, 0)};
		Card[] cards1 = new Card[5];
		Card[] cards2 = new Card[5];
		for(int i = 0; i < 5; i++) {
			cards1[i] = new Card("Teste", red, cardMoves);
			cards2[i] = new Card("Teste", blue, cardMoves);
		}
		String name1 = "João";
		String name2 = "Maria";
		Game gameTest1 = new GameImpl(name1, name2, cards1);
		Game gameTest2 = new GameImpl(name1, name2, cards2);
		Game gameTest3 = new GameImpl(name1, name2, cards1);
		Game gameTest4 = new GameImpl(name1, name2, cards2);
		games = new Game[]{gameTest1, gameTest2, gameTest3, gameTest4};
		// testes do mestre inimigo morreu
		gameTest1.makeMove(gameTest1.getRedPlayer().getCards()[0], cardMoves[1], new Position(4, 2));
		assertTrue("Vermelho deveria ter ganhado!", gameTest1.checkVictory(red));
		// azul
		gameTest2.makeMove(gameTest2.getBluePlayer().getCards()[0], cardMoves[0], new Position(0, 2));
		assertTrue("Azul deveria ter ganhado!", gameTest2.checkVictory(blue));
		
		// testes dominou templo inimigo
		// azul
		gameTest3.makeMove(gameTest3.getRedPlayer().getCards()[0], cardMoves[3], new Position(4, 2));
		gameTest3.makeMove(gameTest3.getBluePlayer().getCards()[0], cardMoves[0], new Position(0, 2));
		assertTrue("Azul deveria ter ganhado!", gameTest3.checkVictory(blue));
		gameTest4.makeMove(gameTest4.getBluePlayer().getCards()[0], cardMoves[2], new Position(0, 2));
		gameTest4.makeMove(gameTest4.getRedPlayer().getCards()[0], cardMoves[1], new Position(4, 2));
		assertTrue("Vermelho deveria ter ganhado!", gameTest4.checkVictory(red));
	}
}
