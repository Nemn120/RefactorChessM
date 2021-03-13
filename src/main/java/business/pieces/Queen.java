package business.pieces;

import business.service.moves.*;
import gui.board.ChessGameBoard;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Represents a Queen game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Queen extends ChessGamePiece {

    private ICalculateNorthWestMoves calculateNorthWestMoves;
    private ICalculateNorthEastMoves calculateNorthEastMoves;
    private ICalculateSouthWestMoves calculateSouthWestMoves;
    private ICalculateSouthEastMoves calculateSouthEastMoves;
    private ICalculateSouthMoves calculateSouthMoves;
    private ICalculateEastMoves calculateEastMoves;
    private ICalculateWestMoves calculateWestMoves;
    private ICalculateNorthMoves calculateNorthMoves;

    /**
     * Create a new Queen object.
     *
     * @param board the board the queen is on
     * @param row   the row location of the queen
     * @param col   the column location of the queen
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Calculates the possible moves for this Queen.
     *
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {

        this.calculateNorthEastMoves = new CalculateNorthEastMoves(pieceRow,pieceColumn);
        ArrayList<String> northEastMoves = this.calculateNorthEastMoves.invoke(board,8,isEnemy);

        this.calculateNorthWestMoves = new CalculateNorthWestMoves(pieceRow,pieceColumn);
        ArrayList<String> northWestMoves = calculateNorthWestMoves.invoke(board,8,isEnemy);

        this.calculateSouthEastMoves = new CalculateSouthEastMoves(pieceRow,pieceColumn);
        ArrayList<String> southEastMoves = calculateSouthEastMoves.invoke(board, 8,isEnemy);

        this.calculateSouthWestMoves = new CalculateSouthWestMoves(pieceRow,pieceColumn);
        ArrayList<String> southWestMoves = calculateSouthWestMoves.invoke(board, 8,isEnemy);

        this.calculateSouthMoves = new CalculateSouthMoves(pieceRow, pieceColumn);
        ArrayList<String> southMoves = calculateSouthMoves.invoke(board, 8,isEnemy);

        this.calculateNorthMoves = new CalculateNorthMoves(pieceRow, pieceColumn);
        ArrayList<String> northMoves = calculateNorthMoves.invoke(board, 8,isEnemy);

        this.calculateEastMoves = new CalculateEastMoves(pieceRow, pieceColumn);
        ArrayList<String> eastMoves = calculateEastMoves.invoke(board, 8,isEnemy);

        this.calculateWestMoves = new CalculateWestMoves(pieceRow, pieceColumn);
        ArrayList<String> westMoves = calculateWestMoves.invoke(board, 8,isEnemy);

        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(northEastMoves);
        allMoves.addAll(northWestMoves);
        allMoves.addAll(southWestMoves);
        allMoves.addAll(southEastMoves);
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
