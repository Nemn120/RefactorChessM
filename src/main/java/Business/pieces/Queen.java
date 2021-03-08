package Business.pieces;

import Business.Service.Moves.CalculateNorthEastMoves;
import Business.Service.Moves.CalculateNorthWestMoves;
import Business.Service.Moves.CalculateSouthEastMoves;
import Business.Service.Moves.CalculateSouthWestMoves;
import Business.Service.Moves.ICalculateNorthEastMoves;
import Business.Service.Moves.ICalculateNorthWestMoves;
import Business.Service.Moves.ICalculateSouthEastMoves;
import Business.Service.Moves.ICalculateSouthWestMoves;
import GUI.board.ChessGameBoard;

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
        ArrayList<String> southEastMoves = calculateSouthEastMoves.invoke(board, 1,isEnemy);

        this.calculateSouthWestMoves = new CalculateSouthWestMoves(pieceRow,pieceColumn);
        ArrayList<String> southWestMoves = calculateSouthWestMoves.invoke(board, 8,isEnemy);

        ArrayList<String> northMoves = calculateNorthMoves(board, 8);
        ArrayList<String> southMoves = calculateSouthMoves(board, 8);
        ArrayList<String> eastMoves = calculateEastMoves(board, 8);
        ArrayList<String> westMoves = calculateWestMoves(board, 8);
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
        if (getColorOfPiece().getColor() == ChessGamePiece.WHITE) {
            return new ImageIcon(
                    getClass().getResource("/ChessImages/WhiteQueen.gif")
            );
        } else if (getColorOfPiece().getColor() == ChessGamePiece.BLACK) {
            return new ImageIcon(
                    getClass().getResource("/ChessImages/BlackQueen.gif")
            );
        } else {
            return new ImageIcon(
                    getClass().getResource("/ChessImages/default-Unassigned.gif")
            );
        }
    }
}
