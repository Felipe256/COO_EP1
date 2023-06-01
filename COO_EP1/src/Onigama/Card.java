import java.util.*;

/**
 * Classe que contém informações das cartas
 */
public class Card {
	
	private final Color cor;
	private final String nome;
	private final Position[] posicoes;
	
    /**
     * Construtor que define os principais atributos de uma cara
     * @param name Nome da carta
     * @param color Cor da carta
     * @param positions Todas as posições relativas de movimento
     */
    public Card(String name, Color color, Position[] positions) {
    	nome = name;
    	cor = color;
    	posicoes = positions;
    }

    /**
     * Método que devolve o nome da carta
     * @return String que contém o nome da carta
     */
    public String getName() {
        return(nome);
    }

    /**
     * Método que devolve a cor da carta
     * @return Enum Color que contém a cor da carta
     */
    public Color getColor() {
        return(cor);
    }

    /**
     * Método que devolve todas as possíveis posições relativas de movimento.
     * A posição atual da peça é o ponto de origem (0,0). Uma carta possui as possíveis posições de movimento em relação ao ponto de origem.
     * @return Um array de Position contendo todas as possíveis posições de movimento em relação ao ponto de origem
     */
    public Position[] getPositions() {
        return(posicoes);
    }

    /**
     * Método que cria todas as cartas do jogo, embaralha-as e devolve as 5 que serão utilizadas na partida.
     * @return Vetor de cartas com todas as cartas do jogo
     */
    public static Card[] createCards() {
        String[] allNames = {"Tiger", "Dragon", "Frog", "Rabbit", "Crab", "Elephant", "Goose", "Rooster"};
        Color[] allColors = {Color.BLUE, Color.RED};
        Position[] posicoesTiger = {new Position(0, 1), new Position(0, -2)};
        Position[] posicoesDragon = {new Position(-2, -1), new Position(-1, 1), new Position(1, 1), new Position(2, -1)};
        Position[] posicoesFrog = {new Position(-2, 0), new Position(-1, -1), new Position(1, 1)};
        Position[] posicoesRabbit = {new Position(-1, 1), new Position(1, -1), new Position(2, 0)};
        Position[] posicoesCrab = {new Position(-2, 0), new Position(0, -1), new Position(2, 0)};
        Position[] posicoesElephant = {new Position(-1, 0), new Position(-1, -1), new Position(1, 0), new Position(1, -1)};
        Position[] posicoesGoose = {new Position(-1, 0), new Position(-1, -1), new Position(1, 0), new Position(1, 1)};
        Position[] posicoesRooster = {new Position(-1, 0), new Position(-1, 1), new Position(1, 0), new Position(1, -1)};
        Position[][] allPositions = {posicoesTiger, posicoesDragon, posicoesFrog, posicoesRabbit, posicoesCrab, posicoesElephant, posicoesGoose, posicoesRooster};
        List<Card> allCards = new ArrayList<Card>();
        Random generator = new Random();
        for(int i = 0; i < allNames.length; i++) {
        	int randomColor = generator.nextInt(2);
        	allCards.add(new Card(allNames[i], allColors[randomColor], allPositions[i]));
        }
        shuffle(allCards, generator);
        getGameCards(allCards, 5);
    	return(allCards.toArray(new Card[0]));
    }
    
    private static void shuffle(List<Card> allCards, Random generator) {
    	for (int i = allCards.size(); i > 1; i--)
    		swap(allCards, i - 1, generator.nextInt(i));
    }
    
    private static <E> void swap(List<E> allCards, int id1, int id2) {
    	E auxiliar = allCards.get(id1);
    	allCards.set(id1, allCards.get(id2));
    	allCards.set(id2, auxiliar);
    }
    
    private static <E> List<E> getGameCards(List<E> allCards, int deleteNumber) {
    	int deckSize = allCards.size();
    	List<E> deletableCards = allCards.subList(deleteNumber, deckSize);
    	List<E> cartas = new ArrayList<E>(deletableCards);
    	deletableCards.clear();
    	return cartas;
    	}

}
