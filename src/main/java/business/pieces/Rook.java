package business.pieces;

import business.service.moves.ICalculateEastMoves;
import business.service.moves.ICalculateNorthMoves;
import business.service.moves.ICalculateSouthMoves;
import business.service.moves.ICalculateWestMoves;
import GUI.board.ChessGameBoard;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Represents a Rook game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Rook extends ChessGamePiece {

    // private ArrayList<String> possibleMoves;

    private ICalculateSouthMoves calculateSouthMoves;
    private ICalculateNorthMoves calculateNorthMoves;
    private ICalculateWestMoves calculateWestMoves;
    private ICalculateEastMoves calculateEastMoves;

    /**
     * Create a new Rook object.
     *
     * @param board the board to create the rook on
     * @param row   the row to create the rook on
     * @param col   the column to create the rook on
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Rook(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Calculates the possible moves for this Rook.
     *
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {

        this.calculateSouthMoves = new CalculateSouthMoves(pieceRow, pieceColumn);
        this.calculateNorthMoves = new CalculateNorthMoves(pieceRow, pieceColumn);
        this.calculateEastMoves = new CalculateEastMoves(pieceRow, pieceColumn);
        this.calculateWestMoves = new CalculateWestMoves(pieceRow, pieceColumn);
        ArrayList<String> northMoves = calculateNorthMoves.invoke(board, 8, isEnemy);
        ArrayList<String> southMoves = calculateSouthMoves.invoke(board, 8, isEnemy);
        ArrayList<String> westMoves = calculateWestMoves.invoke(board, 8, isEnemy);
        ArrayList<String> eastMoves = calculateEastMoves.invoke(board, 8, isEnemy);
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(northMoves);
        allMoves.addAll(southMoves);
        allMoves.addAll(westMoves);
        allMoves.addAll(eastMoves);
        return allMoves;
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        String nameClass = this.getClass().getName();
        return ChessGamePiece.getImageIcon(nameClass,getColorOfPiece().getColor());
    }
}