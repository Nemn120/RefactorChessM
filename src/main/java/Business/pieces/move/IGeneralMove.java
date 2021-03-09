/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.pieces.move;

import Business.pieces.ChessGamePiece;
import GUI.board.ChessGameBoard;

/**
 *
 * @author FELIPE
 */
public interface IGeneralMove {
    public boolean isOnScreen(int row, int col);
    public boolean isPieceOnScreen();
    public boolean isEnemy(ChessGameBoard board, int row, int col);
}
