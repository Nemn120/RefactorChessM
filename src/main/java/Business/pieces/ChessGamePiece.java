package Business.pieces;

import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;
import Business.game.ChessGameEngine;
import GUI.ChessGraveyard;
import GUI.ChessPanel;
import GUI.board.ChessGameBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Abstract class that is used to represent a game piece on the chess board.
 * Classes to extend this piece are Rook, Bishop, Knight, Queen, King and Pawn.
 * Also contains a large number of methods to determine information about cells
 * around this piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public abstract class ChessGamePiece {
    private boolean skipMoveGeneration;
    private ColorOfPiece colorOfPiece;
    protected IsEnemy isEnemy;
    private ImageIcon pieceImage;
    /**
     * The list of possible moves for this piece. Updated when actions involving
     * this piece occur. (created, moved, selected, etc)
     */
    protected ArrayList<String> possibleMoves;
    /**
     * The game piece's row.
     */
    protected int pieceRow;
    /**
     * The game piece's column.
     */
    protected int pieceColumn;

    /**
     * Create a new GamePiece object.
     *
     * @param board      the board to create this piece on
     * @param row        row of the GamePiece
     * @param col        column of the GamePiece
     * @param pieceColor either GamePiece.WHITE, BLACK, or UNASSIGNED
     */

    /**
     * Create a new GamePiece object. This constructor is used for special
     * pieces like pawn, which require other actions to occur before moves are
     * generated. (the pawn can move twice on its initialization, for example)
     *
     * @param board              the board to place the piece on
     * @param row                the row to place the piece on
     * @param col                the column to place the piece on
     * @param skipMoveGeneration if true, moves will not be generated in the constructor
     * @param pieceColor         either GamePiece.BLACK, WHITE, or UNASSIGNED
     */

    /**
     * Generates and returns a list of Strings that represent possible move
     * locations for the piece, in the following format: ["xloc_0,yloc_0",
     * "xloc_1,yloc_1", ...] It is recommended to use the helper methods below
     * to implement this method. (calculateNorth, calculateWest, ...)
     *
     * @param board the board to check moves on
     * @return ArrayList<String> the list of moves
     */
    

    @Override
    public String toString() {
        return this.getClass().toString().substring(6) + " @ (" + pieceRow
                + ", " + pieceColumn + ")";
    }
}
