package business.pieces;

import util.ColorOfPiece;
import gui.board.ChessGameBoard;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {

    private Queen queen;

    @Before
    public void setUp(){
        ChessGameBoard chessGameBoard = new ChessGameBoard();
        queen = new Queen(chessGameBoard,0,0, ColorOfPiece.WHITE);
    }


    @Test
    public void imageNotNullTest(){

        ImageIcon imageResult = queen.createImageByPieceType();
        assertNotNull(imageResult);
        assertNotNull(imageResult.getImage());
    }


}