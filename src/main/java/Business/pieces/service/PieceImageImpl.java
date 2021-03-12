package Business.pieces.service;

import Business.pieces.ChessGamePiece;

import javax.swing.*;

public class PieceImageImpl implements IPieceImage {

    @Override
    public ImageIcon createImageByPieceType(String namePiece,int color){
        if ( color == ChessGamePiece.WHITE ){
            return new ImageIcon(
                    getClass().getResource("/ChessImages/White"+namePiece+".gif")
            );
        }
        else if ( color == ChessGamePiece.BLACK ){
            return new ImageIcon(
                    getClass().getResource("/ChessImages/Black"+namePiece+".gif" )
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
