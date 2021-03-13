package Business.service.moves.pieces;

import Business.service.moves.cardinal.ICalculateCardinalKnightMove;
import GUI.board.ChessGameBoard;
import util.IsOnScreen;

import java.util.ArrayList;
import java.util.List;

public class KnightMove {

    List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves;

    public KnightMove(List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves) {
        this.calculateCardinalKnightMoves = calculateCardinalKnightMoves;
    }

    public List<String> calculatePossibleMoves(ChessGameBoard board, int row, int column) {
        ArrayList<String> moves = new ArrayList<>();
        if (IsOnScreen.invoke(row, column)) {
            calculateCardinalKnightMoves.forEach(cardinalKnightMove -> {
                moves.addAll(cardinalKnightMove.invoke(board));
            });
        }
        return moves;
    }

}
