/**
 * Classe que contém informações das peças de jogo
 */
public class Piece {
	
	private Color cor;
	private boolean isMaster;
	private boolean isAlive;
	
    /**
     * Construtor que define a cor e o tipo da peça
     * @param color Cor da peça
     * @param isMaster Se o tipo da peça é mestre ou não
     */
    public Piece(Color color, boolean isMaster) {
    	cor = color;
    	this.isMaster = isMaster;
    	isAlive = true;
    }

    /**
     * Método que devolve a cor da peça
     * @return Enum Color com a cor da peça
     */
    public Color getColor() {
        return(cor);
    }

    /**
     * Método que devolve se é um mestre ou não
     * @return Booleano true para caso seja um mestre e false caso contrário
     */
    public boolean isMaster() {
        return(isMaster);
    }
    
    /**
     * Método que devolve se a peça ainda está em jogo ou não
     * @return Booleano true para caso esteja em jogo e false caso contrário
     */
    public boolean isAlive() {
        return(isAlive);
    }
    
    //N�o vai comentar mesmo??
    public void eliminaPeca(){
    	isAlive = false;
    }
}
