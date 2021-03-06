/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.pieces.move.impl;

import Business.pieces.move.IGeneralMove;
import GUI.board.ChessGameBoard;
import java.util.ArrayList;

/**
 *
 * @author FELIPE
 */
public class CruzMoveImpl {
    
    protected int pieceRow;
    protected int pieceColumn;
    IGeneralMove generalMove;
    
    public CruzMoveImpl(){
    }
    
    public ArrayList<String> calculateEastMoves(
            ChessGameBoard board,
            int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (generalMove.isPieceOnScreen()) {
            for (int i = pieceColumn + 1; i < 8 && count < numMoves; i++) {
                if ((board.getCell(pieceRow, i).getPieceOnSquare()
                        == null ||generalMove.isEnemy(board, pieceRow, i))) {
                    moves.add(pieceRow + "," + i);
                    count++;
                    if (generalMove.isEnemy(board, pieceRow, i)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }
    
    public ArrayList<String> calculateWestMoves(
            ChessGameBoard board,
            int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (generalMove.isPieceOnScreen()) {
            for (int i = pieceColumn - 1; i >= 0 && count < numMoves; i--) {
                if ((board.getCell(pieceRow, i).getPieceOnSquare()
                        == null || generalMove.isEnemy(board, pieceRow, i))) {
                    moves.add(pieceRow + "," + i);
                    count++;
                    if (generalMove.isEnemy(board, pieceRow, i)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }
    
    protected ArrayList<String> calculateSouthMoves(
            ChessGameBoard board,
            int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (generalMove.isPieceOnScreen()) {
            for (int i = pieceRow + 1; i < 8 && count < numMoves; i++) {
                if ((board.getCell(i, pieceColumn).getPieceOnSquare()
                        == null || generalMove.isEnemy(board, i, pieceColumn))) {
                    moves.add(i + "," + pieceColumn);
                    count++;
                    if (generalMove.isEnemy(board, i, pieceColumn)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }
    
    protected ArrayList<String> calculateNorthMoves(
            ChessGameBoard board,
            int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (generalMove.isPieceOnScreen()) {
            for (int i = pieceRow - 1; i >= 0 && count < numMoves; i--) {
                if ((board.getCell(i, pieceColumn).getPieceOnSquare()
                        == null || generalMove.isEnemy(board, i, pieceColumn))) {
                    moves.add(i + "," + pieceColumn);
                    count++;
                    if (generalMove.isEnemy(board, i, pieceColumn)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
