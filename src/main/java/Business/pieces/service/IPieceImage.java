package Business.pieces.service;

import javax.swing.*;

public interface IPieceImage {

    /**
     * Creates an icon for this piece depending on the piece's color and namePiece.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    ImageIcon createImageByPieceType(String namePiece,int color);


}
