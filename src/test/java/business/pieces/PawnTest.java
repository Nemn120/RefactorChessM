package business.pieces;

import business.service.moves.IPieceMoveService;
import business.service.moves.impl.PieceMoveServiceImpl;
import gui.ChessPanel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {

    Pawn pawnBlack;
    Pawn pawnWhite;
    ChessPanel chessPanel;
    IPieceMoveService pieceMoveService;

    @Before
    public void setUp(){

        chessPanel=new ChessPanel();
        pawnBlack=new Pawn(chessPanel.getGameBoard(),1,1,0);//row=1;col=[0,7];color=0 black
        pawnWhite=new Pawn(chessPanel.getGameBoard(),6,1,1);//row=6;col=[0,7];color=1 white
        pieceMoveService = new PieceMoveServiceImpl();
    }
/*
    @Test
    public void TestMovePawnBlack(){
        Assert.assertTrue(pawnBlack.move(chessPanel.getGameBoard(),3,0));
    }
*/

    @Test
    public void TestMovePawnBlack1(){
        assertTrue(pieceMoveService.move(chessPanel.getGameBoard(),pawnBlack,3,1));
        assertTrue(pieceMoveService.move(chessPanel.getGameBoard(),pawnBlack,4,1));
        assertTrue(pieceMoveService.move(chessPanel.getGameBoard(),pawnBlack,5,1));
        assertFalse(pieceMoveService.move(chessPanel.getGameBoard(),pawnBlack,6,1));



        //pawnBlack.move(chessPanel.getGameBoard(),3,1);
        //pawnBlack.move(chessPanel.getGameBoard(),4,1);
        //pawnBlack.move(chessPanel.getGameBoard(),5,1);
        //chessPanel.getGameBoard().clearCell(6,1);
        //pawnBlack.move(chessPanel.getGameBoard(),6,1);
        //chessPanel.getGameBoard().clearCell(7,1);

       // Assert.assertTrue(pawnBlack.move(chessPanel.getGameBoard(),7,1));

    }
/*
    @Test
    public void TestMovePawnBlack2(){
        Assert.assertFalse(pawnBlack.move(chessPanel.getGameBoard(),0,1));
    }

    @Test
    public void TestMovePawnWhite(){
        
        pawnWhite.move(chessPanel.getGameBoard(),5,1);
        pawnWhite.move(chessPanel.getGameBoard(),4,1);
        pawnWhite.move(chessPanel.getGameBoard(),3,1);

        Assert.assertTrue(pawnWhite.move(chessPanel.getGameBoard(),2,1));//enemigo black

    }
*/
}
