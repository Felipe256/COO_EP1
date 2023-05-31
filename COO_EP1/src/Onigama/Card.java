import java.util.Random;

/**
 * Classe que contém informações das cartas
 */
public class Card {
	
	private Color cor;
	private String nome;
	private Position[] posicoes;
	
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
        String[] nomes = {"Tiger", "Dragon", "Frog", "Rabbit", "Crab", "Elephant", "Goose", "Rooster"};
        Color[] cores = {Color.BLUE, Color.RED};
        Position[] posicoesTiger = {new Position(0, -1), new Position(0, 2)};
        Position[] posicoesDragon = {new Position(-2, 1), new Position(-1, -1), new Position(1, -1), new Position(2, 1)};
        Position[] posicoesFrog = {new Position(-2, 0), new Position(-1, 1), new Position(1, -1)};
        Position[] posicoesRabbit = {new Position(-1, -1), new Position(1, 1), new Position(2, 0)};
        Position[] posicoesCrab = {new Position(-2, 0), new Position(0, 1), new Position(2, 0)};
        Position[] posicoesElephant = {new Position(-1, 0), new Position(-1, 1), new Position(1, 0), new Position(1, 1)};
        Position[] posicoesGoose = {new Position(-1, 0), new Position(-1, 1), new Position(1, 0), new Position(1, -1)};
        Position[] posicoesRooster = {new Position(-1, 0), new Position(-1, -1), new Position(1, 0), new Position(1, 1)};
        Position[][] posicoesRelativas = {posicoesTiger, posicoesDragon, posicoesFrog, posicoesRabbit, posicoesCrab, posicoesElephant, posicoesGoose, posicoesRooster};
        Card[] cartasEscolhidas = new Card[5];
        Random gerador = new Random();
        for(int i = 0; i < 5; i++) {
        	int cartaAleatoria = gerador.nextInt(8);
        	int corAleatoria = gerador.nextInt(2);
        	cartasEscolhidas[i] = new Card(nomes[cartaAleatoria], cores[corAleatoria], posicoesRelativas[cartaAleatoria]);
        }
    	return(cartasEscolhidas);
    }
}
