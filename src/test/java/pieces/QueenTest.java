package pieces;

import chess.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueenTest {
    private Board board;
    @Before
    public void setUp() {
        board = new Board();
    }
    @Test
    public void testIsValidMove() {
        Queen queen = new Queen(Piece.Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
                return false;
            }
        };

        assertTrue(queen.isValidMove(4,4,1,7));
        assertTrue(queen.isValidMove(4,4,4,7));
        assertTrue(queen.isValidMove(4,4,7,7));

        assertFalse(queen.isValidMove(4,4,5,1 ));

    }
//    @Test
//    public void testQueenMoveNotOnEdge() {
//        Piece queen = Piece.createBlackQueen();
//        board.placePieceAt(queen, "d4");
//
//
//        List<String> actualMoves = queen.getPossibleMoves("d4");
//        actualMoves.remove("d4");
//
//        List<String> expectedMoves = Arrays.asList(
//                "a1", "b2", "c3", "d1", "d2", "d3", "d5", "d6", "d7", "d8",
//                "e3", "e4", "e5", "f2", "f4", "f6", "g1", "g4", "g7", "h4", "h8"
//        );
//
//        Collections.sort(actualMoves);
//        Collections.sort(expectedMoves);
//
//        Assert.assertEquals(expectedMoves, actualMoves);
//    }
}
