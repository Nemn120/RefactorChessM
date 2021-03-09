package Business.pieces;

import Business.Service.Moves.Impl.CalculateNorthEastMoves;
import Business.Service.Moves.Impl.CalculateNorthWestMoves;
import Business.Service.Moves.Impl.CalculateSouthEastMoves;
import Business.Service.Moves.Impl.CalculateSouthWestMoves;
import Business.Service.Moves.ICalculateNorthEastMoves;
import Business.Service.Moves.ICalculateNorthWestMoves;
import Business.Service.Moves.ICalculateSouthEastMoves;
import Business.Service.Moves.ICalculateSouthWestMoves;
import GUI.board.ChessGameBoard;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Class to represent the Bishop piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Bishop extends ChessGamePiece {

    private ICalculateNorthWestMoves calculateNorthWestMoves;
    private ICalculateNorthEastMoves calculateNorthEastMoves;
    private ICalculateSouthWestMoves calculateSouthWestMoves;
    private ICalculateSouthEastMoves calculateSouthEastMoves;

    /**
     * Creates a new Bishop object.
     *
     * @param board board the board to create the bishop on
     * @param row   row location of the Bishop
     * @param col   col location of the Bishop
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Bishop(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);

    }

    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {

        this.calculateNorthWestMoves = new CalculateNorthWestMoves(pieceRow,pieceColumn);
        ArrayList<String> northWestMoves = calculateNorthWestMoves.invoke(board,8,isEnemy);

        this.calculateNorthEastMoves = new CalculateNorthEastMoves(pieceRow,pieceColumn);
        ArrayList<String> northEastMoves = this.calculateNorthEastMoves.invoke(board,8,isEnemy);

        this.calculateSouthWestMoves = new CalculateSouthWestMoves(pieceRow,pieceColumn);
        ArrayList<String> southWestMoves = calculateSouthWestMoves.invoke(board, 8,isEnemy);

        this.calculateSouthEastMoves = new CalculateSouthEastMoves(pieceRow,pieceColumn);
        ArrayList<String> southEastMoves = calculateSouthEastMoves.invoke(board, 8,isEnemy);

        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(northEastMoves);
        allMoves.addAll(northWestMoves);
        allMoves.addAll(southEastMoves);
        allMoves.addAll(southWestMoves);
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
                    getClass().getResource("/ChessImages/WhiteBishop.gif")
            );
        } else if (getColorOfPiece().getColor() == ChessGamePiece.BLACK) {
            return new ImageIcon(
                    getClass().getResource("/ChessImages/BlackBishop.gif")
            );
        } else {
            return new ImageIcon(
                    getClass().getResource("/ChessImages/BlackBishop.gif")
            );
        }
    }
}
