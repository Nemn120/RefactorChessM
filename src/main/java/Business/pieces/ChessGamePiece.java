package Business.pieces;

import util.ColorOfPiece;
import util.IResourceOfPiece;
import util.IsEnemy;
import util.IsOnScreen;
import util.ResourceOfPiece;
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
    protected IResourceOfPiece resourceOfPiece;
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
    public ChessGamePiece(ChessGameBoard board, int row, int col, int pieceColor) {
        skipMoveGeneration = false;
        this.colorOfPiece = new ColorOfPiece(pieceColor);
        this.isEnemy=new IsEnemy(pieceColor);
        this.resourceOfPiece = new ResourceOfPiece(pieceColor);
        pieceImage = createImageByPieceType();
        pieceRow = row;
        pieceColumn = col;
        if (board.getCell(row, col) != null) {
            board.getCell(row, col).setPieceOnSquare(this);
        }
        possibleMoves = calculatePossibleMoves(board);
    }

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
    public ChessGamePiece(ChessGameBoard board, int row, int col, int pieceColor, boolean skipMoveGeneration) {
        this.skipMoveGeneration = skipMoveGeneration;
        this.colorOfPiece = new ColorOfPiece(pieceColor);
        this.isEnemy = new IsEnemy(pieceColor);
        this.resourceOfPiece = new ResourceOfPiece(pieceColor);
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

    /**
     * Generates and returns a list of Strings that represent possible move
     * locations for the piece, in the following format: ["xloc_0,yloc_0",
     * "xloc_1,yloc_1", ...] It is recommended to use the helper methods below
     * to implement this method. (calculateNorth, calculateWest, ...)
     *
     * @param board the board to check moves on
     * @return ArrayList<String> the list of moves
     */
    protected abstract ArrayList<String> calculatePossibleMoves(ChessGameBoard board);

    /**
     * Creates the ImageIcon by the color of the piece.
     *
     * @return ImageIcon the image that represents this game piece, different
     * for each piece.
     */
    public abstract ImageIcon createImageByPieceType();

    /**
     * Return the ImageIcon as an Image.
     *
     * @return ImageIcon The ImageIcon as an Image
     */
    public ImageIcon getImage() {
        return pieceImage;
    }

    public ColorOfPiece getColorOfPiece(){
        return colorOfPiece;
    }

    /**
     * Update this piece's position.
     *
     * @param board the game board to move on
     * @param row   the row to move to
     * @param col   the column to move to
     * @return boolean true if the move was successful, false otherwise
     */
    public boolean move(ChessGameBoard board, int row, int col) {
        if (canMove(board, row, col)) {
            String moveLog = this.toString() + " -> ";
            board.clearCell(pieceRow, pieceColumn);
            if (isEnemy.invoke(board, row, col)) {
                ChessGraveyard graveyard;
                ChessGameEngine gameEngine =
                        ((ChessPanel) board.getParent()).getGameEngine();
                if (gameEngine.getCurrentPlayer() == 1) {
                    graveyard =
                            ((ChessPanel) board.getParent()).getGraveyard(2);
                } else {
                    graveyard =
                            ((ChessPanel) board.getParent()).getGraveyard(1);
                }
                graveyard.addPiece(
                        board.getCell(row, col).getPieceOnSquare());
            }
            setPieceLocation(row, col);
            moveLog += " (" + row + ", " + col + ")";
            ((ChessPanel) board.getParent()).getGameLog().addToLog(moveLog);
            board.getCell(row, col).setPieceOnSquare(this);
            if (!skipMoveGeneration) {
                updatePossibleMoves(board);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determines if this piece can move to the specified row and column. Also
     * checks if the current player's king would be put in check by this move.
     *
     * @param board the board to move on
     * @param row   the row to move to
     * @param col   the column to move to
     * @return boolean true if this piece can make the move, false if it cannot
     */
    public boolean canMove(ChessGameBoard board, int row, int col) {
        updatePossibleMoves(board);
        if (possibleMoves.indexOf(row + "," + col) > -1) {
            return testMoveForKingSafety(board, row, col);
        }
        return false;
    }

    /**
     * Checks if the move that is about to be made would cause the current
     * player's King to be put in check (which is an illegal move).
     *
     * @param board the game board to check on
     * @param row   the row to move to
     * @param col   the column to move to
     * @return boolean true if the move is safe, false if it is not
     */
    private boolean testMoveForKingSafety(ChessGameBoard board, int row, int col) {
        updatePossibleMoves(board);
        ChessGamePiece oldPieceOnOtherSquare =
                board.getCell(row, col).getPieceOnSquare();
        ChessGameEngine engine =
                ((ChessPanel) board.getParent()).getGameEngine();
        int oldRow = pieceRow;
        int oldColumn = pieceColumn;
        board.clearCell(pieceRow, pieceColumn); // move us off
        this.setPieceLocation(row, col); // move us to the new location
        board.getCell(row, col).setPieceOnSquare(this);
        boolean retVal = !engine.isKingInCheck(true); // is the current
        // king still in check?
        this.setPieceLocation(oldRow, oldColumn); // move us back
        board.getCell(oldRow, oldColumn).setPieceOnSquare(this);
        board.clearCell(row, col); // ^ move the other piece back
        // to where it was
        board.getCell(row, col).setPieceOnSquare(oldPieceOnOtherSquare);
        return retVal;
    }

    /**
     * Re-calculates the possible moves for this piece. This is called whenever
     * new moves need to be made.
     *
     * @param board the board to calculate moves on
     */
    protected void updatePossibleMoves(ChessGameBoard board) {
        possibleMoves = calculatePossibleMoves(board);
    }

    /**
     * Sets the internal piece location.
     *
     * @param row the new row of the piece
     * @param col the new column of the piece
     */
    public void setPieceLocation(int row, int col) {
        pieceRow = row;
        pieceColumn = col;
    }

    /**
     * Returns this piece's row location.
     *
     * @return int the row
     */
    public int getRow() {
        return pieceRow;
    }

    /**
     * Returns this piece's column.
     *
     * @return int the column
     */
    public int getColumn() {
        return pieceColumn;
    }

    /**
     * Shows the legal move locations for this GamePiece.
     *
     * @param board The board to show the move locations on
     */
    public void showLegalMoves(ChessGameBoard board) {
        updatePossibleMoves(board);
        if (IsOnScreen.invoke(pieceRow, pieceColumn)) {
            for (String locStr : possibleMoves) {
                String[] currCoords = locStr.split(",");
                int row = Integer.parseInt(currCoords[0]);
                int col = Integer.parseInt(currCoords[1]);
                if (canMove(board, row, col)) // only show legal moves
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

    /**
     * Determines if this piece has legal moves to make.
     *
     * @param board the game board to check
     * @return true if there are legal moves, false if there are not
     */
    public boolean hasLegalMoves(ChessGameBoard board) {
        updatePossibleMoves(board);
        if (IsOnScreen.invoke(pieceRow, pieceColumn)) {
            for (String locStr : possibleMoves) {
                String[] currCoords = locStr.split(",");
                int row = Integer.parseInt(currCoords[0]);
                int col = Integer.parseInt(currCoords[1]);
                if (canMove(board, row, col)) // only show legal moves
                {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Gets a list of GamePieces that can currently attack this game piece.
     *
     * @param board the game board to check on
     * @return ArrayList<GamePiece> the list of attackers
     */
    public ArrayList<ChessGamePiece> getCurrentAttackers(ChessGameBoard board) {
        ArrayList<ChessGamePiece> attackers = new ArrayList<ChessGamePiece>();
        int enemyColor =
                (this.getColorOfPiece().getColor() == ColorOfPiece.BLACK)
                        ? ColorOfPiece.WHITE
                        : ColorOfPiece.BLACK;
        this.updatePossibleMoves(board);
        for (int i = 0; i < board.getCells().length; i++) {
            for (int j = 0; j < board.getCells()[0].length; j++) {
                ChessGamePiece currPiece =
                        board.getCell(i, j).getPieceOnSquare();
                if (currPiece != null
                        && currPiece.getColorOfPiece().getColor() == enemyColor) {
                    currPiece.updatePossibleMoves(board);
                    if (currPiece.canMove(board, pieceRow, pieceColumn)) {
                        attackers.add(currPiece);
                    }
                }
            }
        }
        return attackers;
    }

    /**
     * Returns a string representation of this piece. Includes piece type and
     * location.
     *
     * @return String the string representation
     */
    @Override
    public String toString() {
        return this.getClass().toString().substring(6) + " @ (" + pieceRow
                + ", " + pieceColumn + ")";
    }
}
