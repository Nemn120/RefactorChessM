package Business.pieces.move.impl;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Business.pieces.ChessGamePiece;
import GUI.board.ChessGameBoard;

public abstract class GeneralMove {

	private boolean skipMoveGeneration;
	private int pieceColor;
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
	 * Represents a black piece as an int
	 */
	public static final int BLACK = 0;
	/**
	 * Represents a white piece as an int
	 */
	public static final int WHITE = 1;
	/**
	 * Represents a piece that has not been assigned a color
	 */
	public static final int UNASSIGNED = -1;

	public abstract ImageIcon createImageByPieceType();

	protected abstract ArrayList<String> calculatePossibleMoves(ChessGameBoard board);

	public GeneralMove(ChessGameBoard board, int row, int col, int pieceColor) {
		skipMoveGeneration = false;
		this.pieceColor = pieceColor;
		pieceImage = createImageByPieceType();
		pieceRow = row;
		pieceColumn = col;
		if (board.getCell(row, col) != null) {
			board.getCell(row, col).setPieceOnSquare(this);
		}
		possibleMoves = calculatePossibleMoves(board);
	}

	public GeneralMove(ChessGameBoard board, int row, int col, int pieceColor, boolean skipMoveGeneration) {
		this.skipMoveGeneration = skipMoveGeneration;
		this.pieceColor = pieceColor;
		pieceImage = this.createImageByPieceType();
		pieceRow = row;
		pieceColumn = col;
		if (board.getCell(row, col) != null) {
			board.getCell(row, col).setPieceOnSquare(this);
		}
		if (!this.skipMoveGeneration) {
			possibleMoves = calculatePossibleMoves(board);
		}
	}

	public boolean isOnScreen(int row, int col) {
		if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEnemy(ChessGameBoard board, int row, int col) {
        if (row > 7 || col > 7 || row < 0 || col < 0) {
            return false;
        }
        ChessGamePiece enemyPiece =
                board.getCell(row, col).getPieceOnSquare() == null
                        ? null
                        : board.getCell(row, col).getPieceOnSquare();
        if (enemyPiece == null
                || this.getColorOfPiece() == ChessGamePiece.UNASSIGNED
                || enemyPiece.getColorOfPiece() == ChessGamePiece.UNASSIGNED) {
            return false;
        }
        if (this.getColorOfPiece() == ChessGamePiece.WHITE) {
            if (enemyPiece.getColorOfPiece() == ChessGamePiece.BLACK) {
                return true;
            } else {
                return false;
            }
        } else {
            if (enemyPiece.getColorOfPiece() == ChessGamePiece.WHITE) {
                return true;
            } else {
                return false;
            }
        }
    }
	
	public int getColorOfPiece() {
        return pieceColor;
    }
	
	public ImageIcon getImage() {
        return pieceImage;
    }
	
	public boolean isPieceOnScreen() {
		return isOnScreen(pieceRow, pieceColumn);
	}

	public boolean isSkipMoveGeneration() {
		return skipMoveGeneration;
	}

	public void setSkipMoveGeneration(boolean skipMoveGeneration) {
		this.skipMoveGeneration = skipMoveGeneration;
	}

	public int getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(int pieceColor) {
		this.pieceColor = pieceColor;
	}

	public ImageIcon getPieceImage() {
		return pieceImage;
	}

	public void setPieceImage(ImageIcon pieceImage) {
		this.pieceImage = pieceImage;
	}

	public ArrayList<String> getPossibleMoves() {
		return possibleMoves;
	}

	public void setPossibleMoves(ArrayList<String> possibleMoves) {
		this.possibleMoves = possibleMoves;
	}

	public int getPieceRow() {
		return pieceRow;
	}

	public void setPieceRow(int pieceRow) {
		this.pieceRow = pieceRow;
	}

	public int getPieceColumn() {
		return pieceColumn;
	}

	public void setPieceColumn(int pieceColumn) {
		this.pieceColumn = pieceColumn;
	}

	public static int getBlack() {
		return BLACK;
	}

	public static int getWhite() {
		return WHITE;
	}

	public static int getUnassigned() {
		return UNASSIGNED;
	}

}
