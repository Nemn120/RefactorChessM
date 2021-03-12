package Business.pieces;

import GUI.board.ChessGameBoard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KnightTest {

    Knight caballoBlack;
    Knight caballoWhite;

    @Before
    public void before(){
        caballoBlack=new Knight(new ChessGameBoard(),0,1,0);//row=0;col=1,6;color=0 black
        caballoWhite=new Knight(new ChessGameBoard(),1,1,1);//row=1,2,3...;col=1,6;color=1 white
    }

    @Test
    public void testCalculatePossibleMovesBlack(){
        System.out.println("caballoBlack: "+caballoBlack.calculatePossibleMoves(new ChessGameBoard()));
        assertNotNull(caballoBlack.calculatePossibleMoves(new ChessGameBoard()));
    }

    @Test
    public void testCalculatePossibleMovesWhite(){
        System.out.println("caballoWhite: "+caballoWhite.calculatePossibleMoves(new ChessGameBoard()));
        assertNotNull(caballoWhite.calculatePossibleMoves(new ChessGameBoard()));
    }
}
