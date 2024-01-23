package pieces;

import chess.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pieces.Piece.Color.WHITE;

public class KingTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testValidMove() {
        Piece king = new King(WHITE);

        assertTrue(king.isValidMove(3,3,4,4));
        assertTrue(king.isValidMove(3,5,4,5));
        assertTrue(king.isValidMove(2,2,1,1));

        assertFalse(king.isValidMove(3,3,5,5));
    }

  @Test
    public void testKingMoveNotOnEdge() {
        Piece king = Piece.createBlackKing();
        int fromRank = 3;
        board.placePieceAt(king, Integer.parseInt("d3"), fromRank);

      List<String> actualMoves = king.getPossibleMoves("d3");

      List<String> expectedMoves = Arrays.asList("c4", "d4", "e4", "c3", "e3", "c2", "d2", "e2");

      Collections.sort(actualMoves);
      Collections.sort(expectedMoves);

      Assert.assertEquals(expectedMoves, actualMoves);
  }
}
