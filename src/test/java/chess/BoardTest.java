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
    public void testInitialNumberOfPawns() {
        assertEquals(16, board.getNumberOfPawns());
        assertEquals("PPPPPPPP", board.getRanks().get(1));
        assertEquals("pppppppp", board.getRanks().get(6));
    }
    @Test
    public void testBoardRepresentation() {
        String expectedRepresentation =
                """
                ........
                PPPPPPPP
                ........
                ........
                ........
                ........
                pppppppp
                ........""";

        String actualRepresentation = board.getBoardRepresentation();
        System.out.println("Board actual: " + actualRepresentation);
        assertEquals(expectedRepresentation, actualRepresentation);
    }
}
