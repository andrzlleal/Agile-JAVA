package chess;

import org.junit.Before;
import org.junit.Test;
import pieces.Piece;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
        board.initializeBoard();
    }
    @Test
    public void testCreate() {
        assertEquals(32, board.getNumberOfPawns());

        assertEquals(16, Piece.getWhitePieceCount());
        assertEquals(16, Piece.getBlackPieceCount());

        String expectedBoard =
                """
                rnbqkbnr
                pppppppp
                ........
                ........
                ........
                ........
                PPPPPPPP
                RNBQKBNR""";

        //System.out.println("representation\n" + expectedBoard);

        String actualBoard = board.getBoardRepresentation();
        assertEquals(expectedBoard, actualBoard);
    }
}
