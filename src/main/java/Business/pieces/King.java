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
 * Represents a King game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class King extends ChessGamePiece{

    private ICalculateNorthWestMoves calculateNorthWestMoves;
    private ICalculateNorthEastMoves calculateNorthEastMoves;
    private ICalculateSouthWestMoves calculateSouthWestMoves;
    private ICalculateSouthEastMoves calculateSouthEastMoves;

    /**
     * Create a new King object.
     *
     * @param board
     *            the board to create the king on
     * @param row
     *            the row to create the king on
     * @param col
     *            the column to create the king on
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public King( ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color, false );
    }
    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board
     *            the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){

        this.calculateNorthEastMoves = new CalculateNorthEastMoves(pieceRow,pieceColumn);
        ArrayList<String> northEastMoves = this.calculateNorthEastMoves.invoke(board,1,isEnemy);

        this.calculateNorthWestMoves = new CalculateNorthWestMoves(pieceRow,pieceColumn);
        ArrayList<String> northWestMoves = calculateNorthWestMoves.invoke(board,1,isEnemy);

        this.calculateSouthEastMoves = new CalculateSouthEastMoves(pieceRow,pieceColumn);
        ArrayList<String> southEastMoves = calculateSouthEastMoves.invoke(board, 1,isEnemy);

        this.calculateSouthWestMoves = new CalculateSouthWestMoves(pieceRow,pieceColumn);
        ArrayList<String> southWestMoves = calculateSouthWestMoves.invoke(board, 1,isEnemy);

        ArrayList<String> northMoves = calculateNorthMoves( board, 1 );
        ArrayList<String> southMoves = calculateSouthMoves( board, 1 );
        ArrayList<String> eastMoves = calculateEastMoves( board, 1 );
        ArrayList<String> westMoves = calculateWestMoves( board, 1 );
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll( northEastMoves );
        allMoves.addAll( northWestMoves );
        allMoves.addAll( southWestMoves );
        allMoves.addAll( southEastMoves );
        allMoves.addAll( northMoves );
        allMoves.addAll( southMoves );
        allMoves.addAll( westMoves );
        allMoves.addAll( eastMoves );
        return allMoves;
    }
    /**
     * Determines if this King is checked.
     *
     * @param board
     *            the board to check on
     * @return true if checked, false if not checked
     */
    public boolean isChecked( ChessGameBoard board ){
        return getCurrentAttackers( board ).size() > 0;
    }
    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType(){
        if ( getColorOfPiece().getColor() == ChessGamePiece.WHITE ){
            return new ImageIcon(
                getClass().getResource("/ChessImages/WhiteKing.gif")
            );
        }
        else if ( getColorOfPiece().getColor() == ChessGamePiece.BLACK ){
            return new ImageIcon(
                getClass().getResource("/ChessImages/BlackKing.gif" )
            );            
        }
        else
        {
            return new ImageIcon(
                getClass().getResource("/ChessImages/default-Unassigned.gif" )
            );            
        }
    }
}
