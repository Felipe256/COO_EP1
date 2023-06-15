/**
 * Interface que cont√©m m√©todos que ser√£o chamados para a execu√ß√£o do jogo
 */
public interface Game {
    /**
     * MÈtodo que devolve a cor da posi√ß√£o do tabuleiro. Se possui uma cor, significa que √© um templo. Caso contr√°rio, √© um espa√ßo normal
     * @param position Posi√ß√£o do tabuleiro
     * @return O enum Color que representa a cor da posi√ß√£o
     */
    Color getSpotColor(Position position);

    /**
     * MÈtodo que devolve a pe√ßa que est√° na posi√ß√£o do tabuleiro
     * @param position Posi√ß√£o do tabuleiro
     * @return Um objeto Piece que representa a pe√ßa na posi√ß√£o indicada. Se n√£o tiver pe√ßa, devolve null
     */
    Piece getPiece(Position position);

    /**
     * MÈtodo que devolve a carta que est√° na mesa, que ser√° substitu√≠da ap√≥s a pr√≥xima jogada
     * @return Um objeto Card que representa a carta na mesa
     */
    Card getTableCard();

    /**
     * MÈtodo que devolve as informa√ß√µes sobre o jogador com as pe√ßas vermelhas
     * @return Um objeto Player que representa o jogador vermelho
     */
    Player getRedPlayer();

    /**
     * MÈtodo que devolve as informa√ß√µes sobre o jogador com as pe√ßas azuis
     * @return Um objeto Player que representa o jogador azul
     */
    Player getBluePlayer();

    /**
     * MÈtodo que move uma peÁa
     * @param card A carta de movimento que ser· usada
     * @param cardMove A posiÁ„o da carta para onde a peÁa ir· se mover
     * @param currentPos A posiÁ„o da peÁa que ir· se mover
     * @exception IncorrectTurnOrderException Caso n„o seja a vez de um jogador fazer um movimento
     * @exception IllegalMovementException Caso uma peÁa seja movida para fora do tabuleiro ou para uma posiÁ„o onde j· tem uma peÁa da mesma cor
     * @exception InvalidCardException Caso uma carta que n„o est· na m„o do jogador seja usada
     * @exception InvalidPieceException Caso uma peÁa que n„o est· no tabuleiro seja usada
     */
    void makeMove(Card card, Position cardMove, Position currentPos) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException;

    /**
     * MÈtodo que confere se um jogador de uma determinada cor venceu o jogo. CritÈrios de vitÛria:
     * ‚Äî Derrotou a pe√ßa de mestre advers·ria
     * ‚Äî Posicionou o seu mestre na posi√ß√£o da base advers√°ria
     * @param color Cor das pe√ßas do jogador que confere a condi√ß√£o de vit√≥ria
     * @return Um booleano true para caso esteja em condi√ß√µes de vencer e false caso contr√°rio
     */
    boolean checkVictory(Color color);

    /**
     * MÈtodo que imprime o tabuleiro no seu estado atual
     * OBS: Esse mÈtodo È opcional n„o ser· utilizado na correÁ„o, mas serve para acompanhar os resultados parciais do jogo
     */
    void printBoard();
}
