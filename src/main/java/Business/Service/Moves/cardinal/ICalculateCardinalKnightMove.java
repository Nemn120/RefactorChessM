package Business.service.moves.cardinal;

import GUI.board.ChessGameBoard;

import java.util.ArrayList;

public interface ICalculateCardinalKnightMove {

    ArrayList<String> invoke(ChessGameBoard board);

}
