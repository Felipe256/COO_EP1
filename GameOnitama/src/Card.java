import java.util.*;

/**
 * Classe que contém informações das cartas
 */
public class Card {
	
	private final Color color;
	private final String name;
	private final Position[] posicoes;
	
    /**
     * Construtor que define os principais atributos de uma cara
     * @param name Nome da carta
     * @param color Cor da carta
     * @param positions Todas as posições relativas de movimento
     */
    public Card(String name, Color color, Position[] positions) {
    	this.name = name;
    	this.color = color;
    	this.posicoes = positions;
    }

    /**
     * Método que devolve o nome da carta
     * @return String que contém o nome da carta
     */
    public String getName() {
        return(this.name);
    }

    /**
     * Método que devolve a cor da carta
     * @return Enum Color que contém a cor da carta
     */
    public Color getColor() {
        return(this.color);
    }

    /**
     * Método que devolve todas as possíveis posições relativas de movimento.
     * A posição atual da peça é o ponto de origem (0,0). Uma carta possui as possíveis posições de movimento em relação ao ponto de origem.
     * @return Um array de Position contendo todas as possíveis posições de movimento em relação ao ponto de origem
     */
    public Position[] getPositions() {
        return(this.posicoes);
    }

    /**
     * Método que cria todas as cartas do jogo, embaralha-as e devolve as 5 que serão utilizadas na partida.
     * @return Vetor de cartas com todas as cartas do jogo
     */
    public static Card[] createCards() {
        String[] allNames = {"Tiger", "Dragon", "Frog", "Rabbit", "Crab", "Elephant", "Goose", "Rooster"};
        Color[] allColors = {Color.BLUE, Color.RED, Color.RED, Color.BLUE, Color.BLUE, Color.RED, Color.BLUE, Color.RED};
        Position[] posicoesTiger = {new Position(+1, 0), new Position(-2, 0)};
        Position[] posicoesDragon = {new Position(-1, -2), new Position(+1, -1), new Position(+1, +1), new Position(-1, +2)};
        Position[] posicoesFrog = {new Position(0, -2), new Position(-1, -1), new Position(+1, +1)};
        Position[] posicoesRabbit = {new Position(+1, -1), new Position(-1, +1), new Position(0, +2)};
        Position[] posicoesCrab = {new Position(0, -2), new Position(-1, 0), new Position(0, +2)};
        Position[] posicoesElephant = {new Position(0, -1), new Position(-1, -1), new Position(0, +1), new Position(-1, +1)};
        Position[] posicoesGoose = {new Position(0, -1), new Position(-1, -1), new Position(0, +1), new Position(+1, +1)};
        Position[] posicoesRooster = {new Position(0, -1), new Position(+1, -1), new Position(0, +1), new Position(-1, +1)};
        Position[][] allMoves = {posicoesTiger, posicoesDragon, posicoesFrog, posicoesRabbit, posicoesCrab, posicoesElephant, posicoesGoose, posicoesRooster};
        List<Card> allCards = new ArrayList<>();
        for(int i = 0; i < allNames.length; i++) {
        	allCards.add(new Card(allNames[i], allColors[i], allMoves[i]));
        }
        Collections.shuffle(allCards);
        List<Card> deckList = allCards.subList(0, 5);
        return(deckList.toArray(new Card[0]));
    }
}
