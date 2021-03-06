package Business.pieces;

import GUI.board.ChessGameBoard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {

    Queen queen;
    @Before
    public void setUp(){
        ChessGameBoard chessGameBoard = new ChessGameBoard();
        queen = new Queen(chessGameBoard,0,0,1);


    }


    @Test
    public void calculatePossibleMoves(){


    }


}