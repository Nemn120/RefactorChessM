package Business.pieces;

import Business.game.ChessGameEngine;
import GUI.ChessPanel;
import GUI.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PawnTest {

    Pawn pawnBlack;
    Pawn pawnWhite;
    ChessPanel ChessPanel;

    @Before
    public void before(){

        ChessPanel=new ChessPanel();
        pawnBlack=new Pawn(ChessPanel.getGameBoard(),1,1,0);//row=1;col=[0,7];color=0 black
        pawnWhite=new Pawn(ChessPanel.getGameBoard(),6,1,1);//row=6;col=[0,7];color=1 white
    }

    @Test
    public void TestMovePawnBlack1(){

        pawnBlack.move(ChessPanel.getGameBoard(),3,1);
        pawnBlack.move(ChessPanel.getGameBoard(),4,1);
        pawnBlack.move(ChessPanel.getGameBoard(),5,1);
        ChessPanel.getGameBoard().clearCell(6,1);
        pawnBlack.move(ChessPanel.getGameBoard(),6,1);
        ChessPanel.getGameBoard().clearCell(7,1);

        Assert.assertTrue(pawnBlack.move(ChessPanel.getGameBoard(),7,1));

    }

    @Test
    public void TestMovePawnBlack2(){
        Assert.assertFalse(pawnBlack.move(ChessPanel.getGameBoard(),0,1));
    }

    @Test
    public void TestMovePawnWhite(){

        pawnWhite.move(ChessPanel.getGameBoard(),5,1);
        pawnWhite.move(ChessPanel.getGameBoard(),4,1);
        pawnWhite.move(ChessPanel.getGameBoard(),3,1);

        Assert.assertTrue(pawnWhite.move(ChessPanel.getGameBoard(),2,1));//enemigo black

    }

}
