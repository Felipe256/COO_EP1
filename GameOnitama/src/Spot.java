/**
 * Classe contendo aÃ§Ãµes e informaÃ§Ãµes sobre cada espaÃ§o (quadrado) no tabuleiro
 */
public class Spot {

	private Piece peca;
	private final Position posicao;
	private final Color cor;
	
    /**
     * Construtor para espaÃ§os com peÃ§a e com cor
     * @param piece Peça que inicia nesse espaço do tabuleiro
     * @param pos Posiçã£o do espaço no tabuleiro
     * @param color Cor do espaço no tabuleiro (Templo)
     */
    public Spot(Piece piece, Position pos, Color color) {
    	peca = piece;
    	posicao = pos;
    	cor = color;
    }

    /**
     * Construtor para espaÃ§os com peÃ§a e sem cor
     * @param piece PeÃ§a que inicia nesse espaÃ§o do tabuleiro
     * @param pos PosiÃ§Ã£o do espaÃ§o no tabuleiro
     */
    public Spot(Piece piece, Position pos) {
    	peca = piece;
    	posicao = pos;
    	cor = Color.NONE;
    }

    /**
     * Construtor para espaÃ§os sem peÃ§a e sem cor
     * @param pos PosiÃ§Ã£o do espaÃ§o no tabuleiro
     */
    public Spot(Position pos) {
    	peca = null;
    	posicao = pos;
    	cor = Color.NONE;
    }

    /**
     * MÃ©todo que devolve a posiÃ§Ã£o (coordenadas) do espaÃ§o
     * @return Objeto Position contendo a posiÃ§Ã£o (coordenadas) do espaÃ§o
     */
    public Position getPosition() {
        return(posicao);
    }

    /**
     * MÃ©todo que devolve a peÃ§a contida neste espaÃ§o
     * @return Objeto Piece caso tenha uma peÃ§a ou null caso o espaÃ§o esteja vazio
     */
    public Piece getPiece() {
        return(peca);
    }

    /**
     * Método que devolve a cor do espaço
     * @return Enum Color com a cor do espaÃ§o. Caso o espaÃ§o nÃ£o tenha cor, o valor do enum será NONE
     */
    public Color getColor() {
        return(cor);
    }

    /**
     * Método que verifica se a posição é válida no tabuleiro
     * @return Um booleano que indica se o objeto representa uma posição válida no tabuleiro
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
     * @param piece A peÃ§a para ocupar este espaÃ§o
     * @exception IllegalMovementException Caso o espaÃ§o já esteja ocupado por uma peça da mesma cor
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
    		throw new IllegalMovementException("O espaço ocupado é por uma de suas pecas");
    	}
    }

    /**
     * MÃ©todo que "libera" o espaÃ§o atual, ou seja, deixa-o vazio
     */
    protected void releaseSpot() {
    	peca = null;
    }
}
