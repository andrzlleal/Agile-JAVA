package pieces;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueenTest {
    @Test
    public void testIsValidMove() {
        Queen queen = new Queen(Piece.Color.WHITE);

        assertTrue(queen.isValidMove(4,4,1,7));
        assertTrue(queen.isValidMove(4,4,4,7));
        assertTrue(queen.isValidMove(4,4,7,7));

        assertFalse(queen.isValidMove(4,4,5,1 ));
    }

}
