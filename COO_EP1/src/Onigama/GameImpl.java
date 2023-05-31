public class GameImpl implements Game{
	
	private Spot board[][];
	private final Player playerBlue;
	private final Player playerRed;
	private Piece[] bluePieces;
	private Piece[] redPieces;
	private Card tableCard;
	
	public GameImpl(String namePlayerBlue, String namePlayerRed) {
		startBoard();
		Card gameCards[] = Card.createCards();
		tableCard = gameCards[0];
		playerBlue = new Player(namePlayerBlue, Color.BLUE, gameCards[1], gameCards[2]);
		playerRed = new Player(namePlayerRed, Color.RED, gameCards[3], gameCards[4]);
	}
	
	private void startBoard(){
		bluePieces[0] = new Piece(Color.BLUE, true);
		redPieces[0] = new Piece(Color.RED, true);
		for(int i = 1; i < 5; i++) {
			bluePieces[i] = new Piece(Color.BLUE, false);
			redPieces[i] = new Piece(Color.RED, false);
		}
		board[0][2] = new Spot(bluePieces[0], new Position(-2, 0), Color.BLUE);
		board[4][2] = new Spot(redPieces[0], new Position(2, 0), Color.RED);
		for(int i = 0; i <= 1; i++) {
			board[0][i] = new Spot(bluePieces[i+1], new Position(-2, -2 + i));
			board[4][i] = new Spot(redPieces[i+1], new Position(2, -2 + i));
			board[0][i] = new Spot(bluePieces[i+1], new Position(-2, 1 + i));
			board[4][i] = new Spot(redPieces[i+1], new Position(2, 1 + i));
		}
		for(int i = 0; i < 5; i++) {
			board[1][i] = new Spot(new Position(-1, i));
			board[2][i] = new Spot(new Position(0, i));
			board[3][i] = new Spot(new Position(1, i));
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
     * Método que move uma peça
     * @param piece A peça que irá mover
     * @param card A carta de movimento que será usada
     * @param position A posição da carta para onde a peça irá se mover
     * @exception IncorrectTurnOrderException Caso não seja a vez de um jogador fazer um movimento
     * @exception IllegalMovementException Caso uma peça seja movida para fora do tabuleiro ou para uma posição onde já tem uma peça da mesma cor
     * @exception InvalidCardException Caso uma carta que não está na mão do jogador seja usada
     * @exception InvalidPieceException Caso uma peça que não está no tabuleiro seja usada
     */
    public void makeMove(Piece piece, Card card, Position position) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException{
    	
    }

    /**
     * Método que confere se um jogador de uma determinada cor venceu o jogo. Critérios de vitória:
     * — Derrotou a peça de mestre adversária
     * — Posicionou o seu mestre na posição da base adversária
     * @param color Cor das peças do jogador que confere a condição de vitória
     * @return Um booleano true para caso esteja em condições de vencer e false caso contrário
     */
    public boolean checkVictory(Color color) {
    	return(false);
    }

    /**
     * Método que imprime o tabuleiro no seu estado atual
     * OBS: Esse método é opcional não será utilizado na correção, mas serve para acompanhar os resultados parciais do jogo
     */
    public void printBoard() {
    	
    }
}
