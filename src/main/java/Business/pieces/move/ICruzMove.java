/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.pieces.move;

import GUI.board.ChessGameBoard;
import java.util.ArrayList;

/**
 *
 * @author FELIPE
 */
public interface ICruzMove {
    public ArrayList<String> calculateNorthMoves(
            ChessGameBoard board,
            int numMoves);
    public ArrayList<String> calculateSouthMoves(
            ChessGameBoard board,
            int numMoves);
    public ArrayList<String> calculateEastMoves(
            ChessGameBoard board,
            int numMoves);
    public ArrayList<String> calculateWestMoves(
            ChessGameBoard board,
            int numMoves);
}
