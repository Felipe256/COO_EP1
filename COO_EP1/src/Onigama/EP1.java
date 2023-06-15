import java.util.Scanner;

public class EP1 {
	public static void main(String[] args){
		Position[] posicoes = {new Position(1,0), new Position(-1,0), new Position(0,+1), new Position(0,-1), new Position(1,1), new Position(1,-1), new Position(-1,-1), new Position(-1,1)};
		Card cartaRepetida = new Card("TorreSimples", Color.BLUE, posicoes)  ;
		Card vetor[] = {cartaRepetida, cartaRepetida, cartaRepetida, cartaRepetida, cartaRepetida};
		GameImpl gameTest = new GameImpl("Felipe", "Bruno", vetor);
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
			lastTurn = gameTest.getColorTurn();
			gameTest.makeMove(usableCard[idCard], new Position(posRow, posCol), new Position(pieceRow, pieceCol));
		}
		System.out.println("O jogador "+lastTurn+" ganhou!");
		in.close();
	}
}
