package chess;

import org.junit.Before;
import org.junit.Test;

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

        String expectedBoard =
                """
                rnbqkbnr
                PPPPPPPP
                ........
                ........
                ........
                ........
                pppppppp
                RNBQKBNR""";

        String actualBoard = board.getBoardRepresentation();
        assertEquals(expectedBoard, actualBoard);
    }
}
