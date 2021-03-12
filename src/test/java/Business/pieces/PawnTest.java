package Business.pieces;

import GUI.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PawnTest {

    Pawn pawnBlack;
    Pawn pawnWhite;

    @Before
    public void before(){
        pawnBlack=new Pawn(new ChessGameBoard(),1,1,0);//row=1;col=1,2,..;color=0 black
        pawnWhite=new Pawn(new ChessGameBoard(),6,1,1);//row=6;col=1,2..,6;color=1 white
    }

    @Test
    public void TestMovePawnBlack(){
        System.out.println("pawnBlack: "+pawnBlack.move(new ChessGameBoard(),1,4));
        Assert.assertTrue(pawnBlack.move(new ChessGameBoard(),1,4));
    }

    @Test
    public void TestMovePawnBlack2(){
        System.out.println("pawnBlack2: "+pawnBlack.move(new ChessGameBoard(),1,4));
        Assert.assertFalse(pawnBlack.move(new ChessGameBoard(),1,4));
    }

    @Test
    public void TestMovePawnWhite(){
        System.out.println("pawnWhite: "+pawnWhite.move(new ChessGameBoard(),1,4));
        Assert.assertTrue(pawnWhite.move(new ChessGameBoard(),1,4));
    }
    @Test
    public void TestMovePawnWhite2(){
        System.out.println("pawnWhite2: "+pawnWhite.move(new ChessGameBoard(),1,4));
        Assert.assertFalse(pawnWhite.move(new ChessGameBoard(),1,4));
    }

}
