package Business.service.moves.pieces;

import Business.service.moves.cardinal.CalculateCardinalMove;
import GUI.board.ChessGameBoard;

import java.util.ArrayList;
import java.util.List;

public class PieceMove {

    List<CalculateCardinalMove> calculateCardinalMoves;

    public PieceMove(List<CalculateCardinalMove> calculateCardinalMoves) {
        this.calculateCardinalMoves = calculateCardinalMoves;
    }

    public List<String> calculateCardinalMoves(ChessGameBoard board, int numMoves){
        List<String> allMoves = new ArrayList<>();
        calculateCardinalMoves.forEach(x -> {
            allMoves.addAll(this.calculateCardinalMove(x,board,numMoves));
        });
        return allMoves;
    }

    public List<CalculateCardinalMove> getCalculateCardinalMoves() {
        return calculateCardinalMoves;
    }

    public void setCalculateCardinalMoves(List<CalculateCardinalMove> calculateCardinalMoves) {
        this.calculateCardinalMoves = calculateCardinalMoves;
    }

    public List<String> calculateCardinalMove(CalculateCardinalMove cardinalMove, ChessGameBoard board, int numMoves){
        return cardinalMove.invoke(board,numMoves);
    }
}
