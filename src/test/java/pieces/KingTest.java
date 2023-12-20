package pieces;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static pieces.Piece.Color.WHITE;

public class KingTest {
    @Test
    public void testValidMove() {
        Piece king = new King(WHITE);

        assertTrue(king.isValidMove(3,3,4,4));
        assertTrue(king.isValidMove(3,5,4,5));
        assertTrue(king.isValidMove(2,2,1,1));

        assertFalse(king.isValidMove(3,3,5,5));

    }
}
