package Business.pieces;

import GUI.board.ChessGameBoard;
import org.junit.Before;

public class KingTest {
    King kingBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        chessGameBoard=new ChessGameBoard();
        kingBlack=new King(chessGameBoard,0,4,0);//row=0; col=4; color=0 black
    }
}
