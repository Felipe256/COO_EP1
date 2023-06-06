/**
 * Classe que contém informações e ações básicas relacionadas aos jogadores
 */
public class Player {
	
	private String name;
	private Color color;
	private Card card1;
	private Card card2;
	
    /**
     * Construtor que define informações básicas do jogador
     * @param name Nome do jogador
     * @param pieceColor Cor das peças do jogador
     * @param cards Cartas na mão do jogador
     */
    public Player(String name, Color pieceColor, Card[] cards) {
    	this.name = name;
    	color = pieceColor;
    	card1 = cards[0];
    	card2 = cards[1];
    }

    /**
     * Construtor que define informações básicas do jogador
     * @param name Nome do jogador
     * @param pieceColor Cor das peças do jogador
     * @param card1 A primeira carta na mão do jogador
     * @param card2 A segunda carta na mão do jogador
     */
    public Player(String name, Color pieceColor, Card card1, Card card2) {
    	this.name = name;
    	color = pieceColor;
    	this.card1 = card1;
    	this.card2 = card2;
    }

    /**
     * Método que devolve o nome do jogador(a)
     * @return String com o nome do jogador(a)
     */
    public String getName() {
        return(name);
    }

    /**
     * Método que devolve a cor das peças do jogador
     * @return Enum Color com a cor das peças do jogador
     */
    public Color getPieceColor() {
        return(color);
    }

    /**
     * Método que devolve as cartas da mão do jogador
     * @return Booleano true para caso seja um mestre e false caso contrário
     */
    public Card[] getCards() {
    	Card cartasNaMao[] = {card1, card2};
        return(cartasNaMao);
    }

    /**
     * Método que troca uma carta da mão por outra carta (idealmente da mesa)
     * @param oldCard A carta que será substituída
     * @param newCard A carta que irá substituir
     * @exception InvalidCardException Caso a carta não esteja na mão do jogador e/ou na mesa
     */
    protected void swapCard(Card oldCard, Card newCard) throws InvalidCardException {
    	if(oldCard != card1 && oldCard != card2) {
        	throw new InvalidCardException("A carta escolhida n�o est� na m�o do jogador");
    	}
    	if(oldCard == card1) {
    		card1 = newCard;
    	}else {
    		card2 = newCard;
    	}
    }
}
