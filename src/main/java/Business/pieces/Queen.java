package Business.pieces;

import Business.service.moves.cardinal.*;
import Business.service.moves.cardinal.Impl.*;
import Business.service.moves.pieces.CreateMoveService;
import Business.service.moves.pieces.PieceMove;
import GUI.board.ChessGameBoard;
import util.ColorOfPiece;

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
        pieceMove = new PieceMove(CreateMoveService.kingOrQeenMove(row,col,new ColorOfPiece(color)));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }

    @Override
    public void calculatePossibleMoves(ChessGameBoard board) {
        pieceMove = new PieceMove(CreateMoveService.kingOrQeenMove(pieceRow,pieceColumn,colorOfPiece));
        possibleMoves = pieceMove.calculateCardinalMoves(board,8);
    }


    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        if (getColorOfPiece().getColor() == ColorOfPiece.WHITE) {
            return new ImageIcon(
                    getClass().getResource("/ChessImages/WhiteQueen.gif")
            );
        } else if (getColorOfPiece().getColor() == ColorOfPiece.BLACK) {
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
