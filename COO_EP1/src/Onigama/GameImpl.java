import java.util.*;

public class GameImpl implements Game{
	
	private Spot board[][];
	private final Player playerBlue;
	private final Player playerRed;
	private Piece[] bluePieces;
	private Piece[] redPieces;
	private Card tableCard;
	private Color turn;
	
	public GameImpl() {
		startBoard();
		Card gameCards[] = Card.createCards();
		tableCard = gameCards[0];
		turn = tableCard.getColor();
		playerBlue = new Player("Anonymous1", Color.BLUE, gameCards[1], gameCards[2]);
		playerRed = new Player("Anonymous2", Color.RED, gameCards[3], gameCards[4]);
	}
	
	public GameImpl(String namePlayerRed, String namePlayerBlue) {
		startBoard();
		Card gameCards[] = Card.createCards();
		tableCard = gameCards[0];
		turn = tableCard.getColor();
		playerBlue = new Player(namePlayerBlue, Color.BLUE, gameCards[1], gameCards[2]);
		playerRed = new Player(namePlayerRed, Color.RED, gameCards[3], gameCards[4]);
	}
	
	public GameImpl(String namePlayerRed, String namePlayerBlue, Card[] deck) {
		startBoard();
		List<Card> deckList = Arrays.asList(deck);
		Collections.shuffle(deckList);
		deckList = Card.getGameCards(deckList, 5);
		Card[] gameCards = deckList.toArray(new Card[0]);
		tableCard = gameCards[0];
		turn = tableCard.getColor();
		playerBlue = new Player(namePlayerBlue, Color.BLUE, gameCards[1], gameCards[2]);
		playerRed = new Player(namePlayerRed, Color.RED, gameCards[3], gameCards[4]);
	}
	
	private void startBoard(){
		bluePieces = new Piece[5];
		redPieces = new Piece[5];
		bluePieces[0] = new Piece(Color.BLUE, true);
		redPieces[0] = new Piece(Color.RED, true);
		for(int i = 1; i < 5; i++) {
			bluePieces[i] = new Piece(Color.BLUE, false);
			redPieces[i] = new Piece(Color.RED, false);
		}
		board = new Spot[5][5];
		board[0][2] = new Spot(bluePieces[0], new Position(0, 2), Color.BLUE);
		board[4][2] = new Spot(redPieces[0], new Position(4, 2), Color.RED);
		for(int i = 0; i <= 1; i++) {
			board[0][i] = new Spot(bluePieces[i+1], new Position(0, i));
			board[4][i] = new Spot(redPieces[i+1], new Position(4, i));
			board[0][4 - i] = new Spot(bluePieces[i+1], new Position(0, 4 - i));
			board[4][4 - i] = new Spot(redPieces[i+1], new Position(4, 4 - i));
		}
		for(int i = 0; i < 5; i++) {
			board[1][i] = new Spot(new Position(1, i));
			board[2][i] = new Spot(new Position(2, i));
			board[3][i] = new Spot(new Position(3 , i));
		}
	}
	
	/**
     * Método que devolve a cor da posição do tabuleiro. Se possui uma cor, significa que é um templo. Caso contrário, é um espaço normal
     * @param position Posição do tabuleiro
     * @return O enum Color que representa a cor da posição
     */
    public Color getSpotColor(Position position) {
    	int idRow = position.getRow() + 2;
    	int idCol = position.getCol() + 2;
    	return(board[idRow][idCol].getColor());
    }

    /**
     * Método que devolve a peça que está na posição do tabuleiro
     * @param position Posição do tabuleiro
     * @return Um objeto Piece que representa a peça na posição indicada. Se não tiver peça, devolve null
     */
    public Piece getPiece(Position position) {
    	int idRow = position.getRow() + 2;
    	int idCol = position.getCol() + 2;
    	return(board[idRow][idCol].getPiece());
    }

    /**
     * Método que devolve a carta que está na mesa, que será substituída após a próxima jogada
     * @return Um objeto Card que representa a carta na mesa
     */
    public Card getTableCard() {
    	return(tableCard);
    }

    /**
     * Método que devolve as informações sobre o jogador com as peças vermelhas
     * @return Um objeto Player que representa o jogador vermelho
     */
    public Player getRedPlayer() {
    	return(playerRed);
    }

    /**
     * Método que devolve as informações sobre o jogador com as peças azuis
     * @return Um objeto Player que representa o jogador azul
     */
    public Player getBluePlayer() {
    	return(playerBlue);
    }

    /**
     * M�todo que move uma pe�a
     * @param card A carta de movimento que ser� usada
     * @param cardMove A posi��o da carta para onde a pe�a ir� se mover
     * @param currentPos A posi��o da pe�a que ir� se mover
     * @exception IncorrectTurnOrderException Caso n�o seja a vez de um jogador fazer um movimento
     * @exception IllegalMovementException Caso uma pe�a seja movida para fora do tabuleiro ou para uma posi��o onde j� tem uma pe�a da mesma cor
     * @exception InvalidCardException Caso uma carta que n�o est� na m�o do jogador seja usada
     * @exception InvalidPieceException Caso uma pe�a que n�o est� no tabuleiro seja usada
     */
    public void makeMove(Card card, Position cardPosition, Position currentPosition) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException{
    	Spot oldSpot = new Spot(currentPosition);
    	Spot newSpot = new Spot(cardPosition);
    	if(oldSpot.isValid() == false) {
    		throw new InvalidPieceException("Nao ha peca na posicao selecionada ja que a posicao nao existe");
    	}
    	int linPiece = currentPosition.getRow();
    	int colPiece = currentPosition.getCol();
    	Piece piece = board[linPiece][colPiece].getPiece();
    	if(piece == null) {
    		throw new InvalidPieceException("Nenhuma peca foi selecionada para ser movida");
    	}
    	Color pieceMovedColor = piece.getColor();
    	if(turn != pieceMovedColor) {
    		throw new IncorrectTurnOrderException("A jogada n�o deve ser realizada pelo jogador " + pieceMovedColor);
    	}
    	if(cardPosition == null) {
    		throw new IllegalMovementException("Nenhum movimento foi realizado na peca");
    	}
    	if(newSpot.isValid() == false) {
    		throw new IllegalMovementException("A peca esta sendo movida para fora do tabuleiro");
    	}
    	int selectedRow = cardPosition.getRow();
    	int selectedCol = cardPosition.getCol();
    	Piece piecePositioned = board[selectedRow][selectedCol].getPiece();
    	if(piecePositioned != null) {
    		Color piecePositionedColor = piecePositioned.getColor();
        	if(pieceMovedColor == piecePositionedColor) {
        		throw new IllegalMovementException("A posicao esta ocupada por uma de suas pe�as");
        	}
    	}
    	if(card == null) {
    		throw new InvalidCardException("Nenhuma carta foi selecionada para mover uma peca");
    	}
    	Card playerCards[];
    	Piece[] playerPieces;
    	if(pieceMovedColor == Color.BLUE) {
    		playerCards = playerBlue.getCards();
    		playerPieces = bluePieces;
    	}else {//if color is RED
    		playerCards = playerRed.getCards();
    		playerPieces = redPieces;
    	}
    	if(card != playerCards[0] && card != playerCards[1]) {
			throw new InvalidCardException("A carta utilizada nao esta na mao do jogador " + pieceMovedColor);
		}
		boolean pieceValid = false;
		for(Piece singlePiece : playerPieces) {
			if(singlePiece == piece) {
				pieceValid = true;
			}
		}
		if(pieceValid == false) {
			throw new InvalidPieceException("A peca nao esta no tabuleiro");
		}
    	boolean validMovement = false;
    	Position[] possibleMoves = card.getPositions();
    	for(Position attemptMove : possibleMoves) {
    		int attemptRow = attemptMove.getRow() + currentPosition.getRow();
    		int attemptCol = attemptMove.getCol() + currentPosition.getRow();
    		if(attemptRow == selectedRow && attemptCol == selectedRow) {
    			validMovement = true;
    			break;
    		}
    	}
    	if(validMovement == false) {
    		throw new IllegalMovementException("O movimento desejado nao pode ser realizado pela carta "+card.getName());
    	}
    	if(piecePositioned != null) {
    		piecePositioned.die();
    	}
        board[selectedRow][selectedCol].occupySpot(piece);
    	board[currentPosition.getRow()][currentPosition.getCol()].releaseSpot();
    }

    /**
     * Método que confere se um jogador de uma determinada cor venceu o jogo. Critérios de vitória:
     * — Derrotou a peça de mestre adversária
     * — Posicionou o seu mestre na posição da base adversária
     * @param color Cor das peças do jogador que confere a condição de vitória
     * @return Um booleano true para caso esteja em condições de vencer e false caso contrário
     */
    public boolean checkVictory(Color color) {
    	if(color == Color.BLUE) {
    		Piece redMaster = redPieces[0];
    		if(!redMaster.isAlive()) {
    			return(true);
    		}
    		Piece blueWinCondition2 = board[4][2].getPiece();
    		if(blueWinCondition2 != null) {
    			if(blueWinCondition2.isMaster() && blueWinCondition2.getColor() == Color.BLUE) {
    				return(true);
    			}
    		}
    	}else {//if color is RED
    		Piece blueMaster = bluePieces[0];
    		if(blueMaster.isAlive()) {
    			return(true);
    		}
    		Piece redWinCondition2 = board[0][2].getPiece();
    		if(redWinCondition2.isMaster() && redWinCondition2.getColor() == Color.RED) {
    			return(true);
    		}
    	}
    	return(false);
    }

    /**
     * Método que imprime o tabuleiro no seu estado atual
     * OBS: Esse método é opcional não será utilizado na correção, mas serve para acompanhar os resultados parciais do jogo
     */
    public void printBoard() {
    	for(int i = 0; i < 5; i++) {
    		for(int j = 0; j < 5; j++) {
    			Piece currentPiece = board[i][j].getPiece();
    			if(currentPiece == null) {
    				System.out.print(" 0");
    			}else if(currentPiece.isMaster()) {
    				System.out.print(" M");
    			}else {
    				System.out.print(" P");
    			}
    		}
    		System.out.println("");
    	}
    }
}
