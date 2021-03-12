
import Business.pieces.Bishop;
import Business.pieces.ChessGamePiece;
import Business.pieces.Rook;
import GUI.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessGamePieceTest {

    ChessGamePiece chessGamePiece;
    ChessGamePiece chessGamePiece2;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        chessGameBoard=new ChessGameBoard();
        chessGamePiece=new Bishop(chessGameBoard, 0, 1, 0);
        chessGamePiece2=new Rook(chessGameBoard, 0, 1,1);

    }

    @Test
    public void Test1(){

        //Assert.assertEquals(0,chessGamePiece.g);
    }

    @Test
    public void Test2(){

    }

}
