package Business.pieces;

import GUI.board.ChessGameBoard;
import org.junit.Before;

public class RookTest {
    Rook rookBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        chessGameBoard=new ChessGameBoard();
        rookBlack=new Rook(chessGameBoard,0,0,0);//row=0; col=0,7; color=0 black
    }
}
