package Business.pieces;

import GUI.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KnightTest {

    Knight caballoBlack;
    ChessGameBoard chessGameBoard;

    @Before
    public void before(){
        chessGameBoard=new ChessGameBoard();
        caballoBlack=new Knight(chessGameBoard,0,1,0);//row=0; col=1,6; color=0 black
    }


    @Test
    public void testCalculatePossibleMovesBlack(){
        ArrayList<String> esperado=new ArrayList<>();
        esperado.add("2,2");
        esperado.add("2,0");
        ArrayList<String> actual=caballoBlack.calculatePossibleMoves(chessGameBoard);
        System.out.println("esperadoCaballoBlack: "+esperado);
        System.out.println("actualCaballoBlack: "+actual);

        Assert.assertArrayEquals(esperado.toArray(),actual.toArray());
    }

}
