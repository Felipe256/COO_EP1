/**
 * Interface que contém métodos que serão chamados para a execução do jogo
 */
public interface Game {
    /**
     * M�todo que devolve a cor da posição do tabuleiro. Se possui uma cor, significa que é um templo. Caso contrário, é um espaço normal
     * @param position Posição do tabuleiro
     * @return O enum Color que representa a cor da posição
     */
    Color getSpotColor(Position position);

    /**
     * M�todo que devolve a peça que está na posição do tabuleiro
     * @param position Posição do tabuleiro
     * @return Um objeto Piece que representa a peça na posição indicada. Se não tiver peça, devolve null
     */
    Piece getPiece(Position position);

    /**
     * M�todo que devolve a carta que está na mesa, que será substituída após a próxima jogada
     * @return Um objeto Card que representa a carta na mesa
     */
    Card getTableCard();

    /**
     * M�todo que devolve as informações sobre o jogador com as peças vermelhas
     * @return Um objeto Player que representa o jogador vermelho
     */
    Player getRedPlayer();

    /**
     * M�todo que devolve as informações sobre o jogador com as peças azuis
     * @return Um objeto Player que representa o jogador azul
     */
    Player getBluePlayer();

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
    void makeMove(Card card, Position cardMove, Position currentPos) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException;

    /**
     * M�todo que confere se um jogador de uma determinada cor venceu o jogo. Crit�rios de vit�ria:
     * — Derrotou a peça de mestre advers�ria
     * — Posicionou o seu mestre na posição da base adversária
     * @param color Cor das peças do jogador que confere a condição de vitória
     * @return Um booleano true para caso esteja em condições de vencer e false caso contrário
     */
    boolean checkVictory(Color color);

    /**
     * M�todo que imprime o tabuleiro no seu estado atual
     * OBS: Esse m�todo � opcional n�o ser� utilizado na corre��o, mas serve para acompanhar os resultados parciais do jogo
     */
    void printBoard();
}
