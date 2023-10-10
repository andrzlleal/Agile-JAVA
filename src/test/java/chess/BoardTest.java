package chess;

import org.junit.Test;
import pieces.Pawn;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test class for the chess.Board class.
 * This class contains test methods to verify the functionality of the chess.Board class.
 * including adding pawns, checking piece counts, and verifying pawn objects.
 * */

public class BoardTest {

    public void setUp() {
        Board board = new Board();
    }
    /**
     * Test the initial state of the board.
     * */
    @Test
    public void testBoardStartWithZeroPieces(){
        //Create a new board
        Board board = new Board();

        //Add a white pawn and check the piece count.
        board.addWhitePawn();
        assertEquals(1, board.getNumberOfPieces());

        /* Add a black pawn and check the piece count again. */
        board.addBlackPawn();
        assertEquals(2, board.getNumberOfPieces());

        //Get the list of pieces from the board and verify their types.
        List<Pawn> pieces = board.getPieces();
        assertEquals(2, pieces.size());
        assertNotNull(pieces.get(0));
        assertNotNull(pieces.get(1));

        //boolean add = board.getPieces().add(new Integer("7"));
    }
    
}
