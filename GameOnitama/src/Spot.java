/**
 * Classe contendo ações e informações sobre cada espaço (quadrado) no tabuleiro
 */
public class Spot {

	private Piece peca;
	private final Position posicao;
	private final Color cor;
	
    /**
     * Construtor para espaços com peça e com cor
     * @param piece Pe�a que inicia nesse espa�o do tabuleiro
     * @param pos Posi��o do espa�o no tabuleiro
     * @param color Cor do espa�o no tabuleiro (Templo)
     */
    public Spot(Piece piece, Position pos, Color color) {
    	peca = piece;
    	posicao = pos;
    	cor = color;
    }

    /**
     * Construtor para espaços com peça e sem cor
     * @param piece Peça que inicia nesse espaço do tabuleiro
     * @param pos Posição do espaço no tabuleiro
     */
    public Spot(Piece piece, Position pos) {
    	peca = piece;
    	posicao = pos;
    	cor = Color.NONE;
    }

    /**
     * Construtor para espaços sem peça e sem cor
     * @param pos Posição do espaço no tabuleiro
     */
    public Spot(Position pos) {
    	peca = null;
    	posicao = pos;
    	cor = Color.NONE;
    }

    /**
     * Método que devolve a posição (coordenadas) do espaço
     * @return Objeto Position contendo a posição (coordenadas) do espaço
     */
    public Position getPosition() {
        return(posicao);
    }

    /**
     * Método que devolve a peça contida neste espaço
     * @return Objeto Piece caso tenha uma peça ou null caso o espaço esteja vazio
     */
    public Piece getPiece() {
        return(peca);
    }

    /**
     * M�todo que devolve a cor do espa�o
     * @return Enum Color com a cor do espaço. Caso o espaço não tenha cor, o valor do enum ser� NONE
     */
    public Color getColor() {
        return(cor);
    }

    /**
     * M�todo que verifica se a posi��o � v�lida no tabuleiro
     * @return Um booleano que indica se o objeto representa uma posi��o v�lida no tabuleiro
     */
    public boolean isValid() {
        return(verificaValidadeDaCoordenada(posicao.getRow()) && verificaValidadeDaCoordenada(posicao.getCol()) );
    }
    
    /**
     * 
     * @param coordenada coordenada contida em uma posicao
     * @return Um booleano true para caso seja valido e false caso contr�rio
     */
    private boolean verificaValidadeDaCoordenada(int coordenada) {
    	return(coordenada >= 0 && coordenada <= 4);
    }

    /**
     * M�todo que ocupa o espa�o atual com a pe�a passada
     * @param piece A peça para ocupar este espaço
     * @exception IllegalMovementException Caso o espaço j� esteja ocupado por uma pe�a da mesma cor
     */
    protected void occupySpot(Piece piece) throws IllegalMovementException {
    	if(this.peca == null) {
    		peca = piece;
    	}else if(this.peca.getColor() != piece.getColor()) {
    		if(this.peca != null) {
    			this.peca.die();
    		}
    		this.peca = piece;
    	}else {
    		throw new IllegalMovementException("O espa�o ocupado � por uma de suas pecas");
    	}
    }

    /**
     * Método que "libera" o espaço atual, ou seja, deixa-o vazio
     */
    protected void releaseSpot() {
    	peca = null;
    }
}
