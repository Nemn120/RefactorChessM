package Business.service.king;

import Business.pieces.ChessGamePiece;
import GUI.board.ChessGameBoard;

public interface IKingService {

    boolean isChecked(ChessGamePiece piece);
}
