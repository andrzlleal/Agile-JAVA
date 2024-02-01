package pieces;

import chess.Board;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
    @Test
    public void testPawnIsValidMove() {

        Board board = new Board();
        Piece whitePawn = new Pawn(Piece.Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return toFile == fromFile && toRank == fromRank + 1;
            }
        };

        whitePawn.setFile(3);
        whitePawn.setRank(1);

        assertTrue(whitePawn.isValidMove(3, 1, 3, 2));

        assertFalse(whitePawn.isValidMove(3,1,4,2));

        whitePawn.setRank(2);

        assertTrue(whitePawn.isValidMove(3,2,3,3));
    }

    @Test
    public void testPawnRepresentation() {
        Piece whitePawn = new Pawn(Piece.Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };

        assertEquals(1.0, Pawn.getPieceValue(), 0.01);
    }
    @Test
    public void testPawnAddPointsForSameColumnPawn() {
        Piece whitePawn = new Pawn(Piece.Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };

       whitePawn.addPointsForSameColumnPawn();

        assertEquals(0.5, whitePawn.getStrength(), 0.01);
    }
    @Test
    public void testPawnMove() {
        Pawn whitePawn = new Pawn(Piece.Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };

        whitePawn.move();

        assertTrue(whitePawn.hasMoved());
    }


}
