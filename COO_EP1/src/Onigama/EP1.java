
public class EP1 {
	public static void main(String[] args) throws IllegalMovementException{
		GameImpl gameTest = new GameImpl();
		Card[] testeCartas = Card.createCards();
		for(Card x : testeCartas) {
			System.out.println(x);
		}
		gameTest.printBoard();
	}
}
