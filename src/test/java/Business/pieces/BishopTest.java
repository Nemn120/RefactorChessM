package Business.pieces;

import GUI.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BishopTest {

    Bishop bishopBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        chessGameBoard=new ChessGameBoard();
        bishopBlack=new Bishop(chessGameBoard,0,2,0);//row=0; col=2,5; color=0 black
    }

}
