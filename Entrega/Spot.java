/**
 * Classe contendo ações e informações sobre cada espaço (quadrado) no tabuleiro
 */
public class Spot {

	private Piece peca;
	private final Position posicao;
	private final Color cor;
	
    /**
     * Construtor para espaços com peça e com cor
     * @param piece Peça que inicia nesse espaço do tabuleiro
     * @param pos Posição do espaço no tabuleiro
     * @param color Cor do espaço no tabuleiro (Templo)
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
     * Método que devolve a cor do espaço
     * @return Enum Color com a cor do espaço. Caso o espaço não tenha cor, o valor do enum será NONE
     */
    public Color getColor() {
        return(cor);
    }

    /**
     * Método que verifica se a posição é válida no tabuleiro
     * @return Um booleano que indica se o objeto representa uma posiçãoo válida no tabuleiro
     */
    public boolean isValid() {
        return(verificaValidadeDaCoordenada(posicao.getRow()) && verificaValidadeDaCoordenada(posicao.getCol()) );
    }
    
    /**
     * 
     * @param coordenada coordenada contida em uma posicao
     * @return Um booleano true para caso seja valido e false caso contrário
     */
    private boolean verificaValidadeDaCoordenada(int coordenada) {
    	return(coordenada >= 0 && coordenada <= 4);
    }

    /**
     * Método que ocupa o espaço atual com a peça passada
     * @param piece A peça para ocupar este espaço
     * @exception IllegalMovementException Caso o espaço já esteja ocupado por uma peça da mesma cor
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
    		throw new IllegalMovementException("O espaço está ocupado por uma de suas pecas");
    	}
    }

    /**
     * Método que "libera" o espaço atual, ou seja, deixa-o vazio
     */
    protected void releaseSpot() {
    	peca = null;
    }
}
