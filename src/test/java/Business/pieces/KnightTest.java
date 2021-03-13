package Business.pieces;

import GUI.board.ChessGameBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    Knight caballoBlack;
    ChessGameBoard chessGameBoard;
    Logger logger;

    @Before
    public void before(){
        logger = Logger.getLogger(KnightTest.class.getName());
        chessGameBoard=new ChessGameBoard();
        caballoBlack=new Knight(chessGameBoard,0,1,0);//row=0; col=1,6; color=0 black
    }


    @Test
    public void testCalculatePossibleMovesBlack(){
        List<String> esperado=new ArrayList<>();
        esperado.add("2,2");
        esperado.add("2,0");

        caballoBlack.calculatePossibleMoves(chessGameBoard);
        logger.info("esperadoCaballoBlack: "+esperado);
        logger.info("actualCaballoBlack: "+caballoBlack.getPossibleMoves());

        assertArrayEquals(esperado.toArray(),caballoBlack.getPossibleMoves().toArray());
    }

}
