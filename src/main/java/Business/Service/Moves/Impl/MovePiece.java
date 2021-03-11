package Business.Service.Moves.Impl;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Business.Service.Moves.IConfigurationPieceMove;
import Business.Service.Moves.IMovePiece;
import Business.game.ChessGameEngine;
import GUI.ChessGraveyard;
import GUI.ChessPanel;
import GUI.board.ChessGameBoard;
import util.ColorOfPiece;
import util.IsEnemy;

public abstract class MovePiece implements IMovePiece {
	
	public IsEnemy isEnemy;
	private boolean skipMoveGeneration;
    private ColorOfPiece colorOfPiece;
    private ImageIcon pieceImage;
    public int pieceRow;
    public int pieceColumn;
    public ArrayList<String> possibleMoves;
    private IConfigurationPieceMove configurationPieceMoveService;
    
    
    public MovePiece(ChessGameBoard board, int row, int col, int pieceColor) {
        skipMoveGeneration = false;
        this.colorOfPiece = new ColorOfPiece(pieceColor);
        this.isEnemy=new IsEnemy(pieceColor);
        pieceImage = createImageByPieceType();
        pieceRow = row;
        pieceColumn = col;
        if (board.getCell(row, col) != null) {
            board.getCell(row, col).setPieceOnSquare(this);
        }
        possibleMoves = calculatePossibleMoves(board);
    }
    
    public MovePiece(ChessGameBoard board, int row, int col, int pieceColor, boolean skipMoveGeneration) {
        this.skipMoveGeneration = skipMoveGeneration;
        this.colorOfPiece = new ColorOfPiece(pieceColor);
        this.isEnemy = new IsEnemy(pieceColor);
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
    
    public static ImageIcon getImageIcon(String namePiece,int colorOfPiece){
        namePiece = namePiece.substring(16);
        if ( colorOfPiece == ColorOfPiece.WHITE ){
            return new ImageIcon(
                MovePiece.class.getResource("/ChessImages/White"+namePiece+".gif")
            );
        }
        else if ( colorOfPiece == ColorOfPiece.BLACK ){
            return new ImageIcon(
            	MovePiece.class.getResource("/ChessImages/Black"+namePiece+".gif")
            );
        }
        else
        {
            return new ImageIcon(
            	MovePiece.class.getResource("/ChessImages/default-Unassigned.gif")
            );
        }
    }
    
    public abstract ArrayList<String> calculatePossibleMoves(ChessGameBoard board);
    public abstract ImageIcon createImageByPieceType();

    public ImageIcon getImage() {
        return pieceImage;
    }
    
	@Override
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
            	configurationPieceMoveService.updatePossibleMoves(board);
            }
            return true;
        } else {
            return false;
        }
	}

	@Override
	public boolean canMove(ChessGameBoard board, int row, int col) {
		configurationPieceMoveService.updatePossibleMoves(board);
        if (possibleMoves.indexOf(row + "," + col) > -1) {
            return configurationPieceMoveService.testMoveForKingSafety(board, row, col);
        }
        return false;
	}
	
	public void setPieceLocation(int row, int col) {
        pieceRow = row;
        pieceColumn = col;
    }

	public IsEnemy getIsEnemy() {
		return isEnemy;
	}

	public void setIsEnemy(IsEnemy isEnemy) {
		this.isEnemy = isEnemy;
	}

	public boolean isSkipMoveGeneration() {
		return skipMoveGeneration;
	}

	public void setSkipMoveGeneration(boolean skipMoveGeneration) {
		this.skipMoveGeneration = skipMoveGeneration;
	}

	public ColorOfPiece getColorOfPiece() {
		return colorOfPiece;
	}

	public void setColorOfPiece(ColorOfPiece colorOfPiece) {
		this.colorOfPiece = colorOfPiece;
	}

	public ImageIcon getPieceImage() {
		return pieceImage;
	}

	public void setPieceImage(ImageIcon pieceImage) {
		this.pieceImage = pieceImage;
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

	public ArrayList<String> getPossibleMoves() {
		return possibleMoves;
	}

	public void setPossibleMoves(ArrayList<String> possibleMoves) {
		this.possibleMoves = possibleMoves;
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
    
    @Override
    public String toString() {
        return this.getClass().toString().substring(6) + " @ (" + pieceRow
                + ", " + pieceColumn + ")";
    }

	public IConfigurationPieceMove getConfigurationPieceMoveService() {
		return configurationPieceMoveService;
	}

	public void setConfigurationPieceMoveService(IConfigurationPieceMove configurationPieceMoveService) {
		this.configurationPieceMoveService = configurationPieceMoveService;
	}

}
