import java.util.Scanner;

public class EP1 {
	public static void main(String[] args) throws IllegalMovementException{
		GameImpl gameTest = new GameImpl();
		Color lastTurn = (gameTest.getColorTurn() == Color.BLUE ? Color.RED : Color.BLUE);
		Scanner in = new Scanner(System.in);
		while(gameTest.checkVictory(lastTurn) != true) {
			gameTest.printEverything();
			Card[] usableCard = (gameTest.getColorTurn() == Color.BLUE ? gameTest.getBluePlayer().getCards() : gameTest.getRedPlayer().getCards());
			int pieceRow = in.nextInt();
			int pieceCol = in.nextInt();
			int idCard = in.nextInt();
			int posRow = in.nextInt();
			int posCol = in.nextInt();
			gameTest.makeMove(usableCard[idCard], new Position(posRow, posCol), new Position(pieceRow, pieceCol));
			lastTurn = gameTest.getColorTurn();
			gameTest.changeTurn();
		}
		System.out.println("O jogador "+lastTurn+" ganhou!");
		in.close();
	}
}
