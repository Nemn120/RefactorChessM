package Business.Service.Moves.Impl;

import java.awt.Color;
import java.util.ArrayList;

import Business.Service.Moves.IConfigurationPieceMove;
import Business.game.ChessGameEngine;
import Business.pieces.ChessGamePiece;
import GUI.ChessPanel;
import GUI.board.ChessGameBoard;
import util.ColorOfPiece;
import util.IsEnemy;
import util.IsOnScreen;

public class ConfigurationPieceMove implements IConfigurationPieceMove {

	public ArrayList<String> possibleMoves;
	private MovePiece movePiece;
	public int pieceRow;
    public int pieceColumn;
    private IsEnemy isEnemy;
	
	@Override
	public void updatePossibleMoves(ChessGameBoard board) {
		possibleMoves = movePiece.calculatePossibleMoves(board);
		
	}

	@Override
	public boolean testMoveForKingSafety(ChessGameBoard board, int row, int col) {
		updatePossibleMoves(board);
        MovePiece oldPieceOnOtherSquare =
                board.getCell(row, col).getPieceOnSquare();
        ChessGameEngine engine =
                ((ChessPanel) board.getParent()).getGameEngine();
        int oldRow = pieceRow;
        int oldColumn = pieceColumn;
        board.clearCell(pieceRow, pieceColumn); // move us off
        movePiece.setPieceLocation(row, col); // move us to the new location
        board.getCell(row, col).setPieceOnSquare(movePiece);;
        boolean retVal = !engine.isKingInCheck(true); // is the current
        // king still in check?
        movePiece.setPieceLocation(oldRow, oldColumn); // move us back
        board.getCell(oldRow, oldColumn).setPieceOnSquare(movePiece);;
        board.clearCell(row, col); // ^ move the other piece back
        // to where it was
        board.getCell(row, col).setPieceOnSquare(oldPieceOnOtherSquare);
        return retVal;
	}

	@Override
	public void showLegalMoves(ChessGameBoard board) {
		updatePossibleMoves(board);
        if (IsOnScreen.invoke(pieceRow, pieceColumn)) {
            for (String locStr : possibleMoves) {
                String[] currCoords = locStr.split(",");
                int row = Integer.parseInt(currCoords[0]);
                int col = Integer.parseInt(currCoords[1]);
                if (movePiece.canMove(board, row, col)) // only show legal moves
                {
                    if (isEnemy.invoke(board, row, col)) {
                        board.getCell(row, col).setBackground(
                                Color.YELLOW);
                    } else {
                        board.getCell(row, col).setBackground(Color.PINK);
                    }
                }
            }
        }
		
	}

	@Override
	public boolean hasLegalMoves(ChessGameBoard board) {
		updatePossibleMoves(board);
        if (IsOnScreen.invoke(pieceRow, pieceColumn)) {
            for (String locStr : possibleMoves) {
                String[] currCoords = locStr.split(",");
                int row = Integer.parseInt(currCoords[0]);
                int col = Integer.parseInt(currCoords[1]);
                if (movePiece.canMove(board, row, col)) // only show legal moves
                {
                    return true;
                }
            }
            return false;
        }
        return false;
	}

	@Override
	public ArrayList<MovePiece> getCurrentAttackers(ChessGameBoard board) {
		ArrayList<MovePiece> attackers = new ArrayList<MovePiece>();
        int enemyColor =
                (movePiece.getColorOfPiece().getColor() == ColorOfPiece.BLACK)
                        ? ColorOfPiece.WHITE
                        : ColorOfPiece.BLACK;
        this.updatePossibleMoves(board);
        for (int i = 0; i < board.getCells().length; i++) {
            for (int j = 0; j < board.getCells()[0].length; j++) {
                MovePiece currPiece =
                        board.getCell(i, j).getPieceOnSquare();
                if (currPiece != null
                        && currPiece.getColorOfPiece().getColor() == enemyColor) {
                	updatePossibleMoves(board);
                    if (currPiece.canMove(board, pieceRow, pieceColumn)) {
                        attackers.add(currPiece);
                    }
                }
            }
        }
        return attackers;
	}

}
