package Business.service.moves.pieces;

import Business.service.moves.cardinal.CalculateCardinalMove;
import Business.service.moves.cardinal.Impl.*;
import util.ColorOfPiece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateMoveService {

    public static List<CalculateCardinalMove> kingOrQeenMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        List<CalculateCardinalMove> addAllMove = new ArrayList<>();
        addAllMove.addAll(CreateMoveService.bishopMove(pieceRow,pieceColumn,color));
        addAllMove.addAll(CreateMoveService.rookMove(pieceRow,pieceColumn,color));
        return addAllMove;
    }

    public static List<CalculateCardinalMove> bishopMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateNorthEastMoves(pieceRow,pieceColumn,color),
                new CalculateNorthWestMoves(pieceRow,pieceColumn,color),
                new CalculateSouthEastMoves(pieceRow,pieceColumn,color),
                new CalculateSouthWestMoves(pieceRow,pieceColumn,color));
    }

    public static List<CalculateCardinalMove> rookMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateSouthMoves(pieceRow,pieceColumn,color),
                new CalculateNorthMoves(pieceRow,pieceColumn,color),
                new CalculateEastMoves(pieceRow,pieceColumn,color),
                new CalculateWestMoves(pieceRow,pieceColumn,color));
    }
}
