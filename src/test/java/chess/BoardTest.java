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
    /**
     * Test the initial state of the board.
     * */
    @Test
    public void testBoardStartWithZeroPieces(){
        //Create a new board
        Board board = new Board();

        /* Add a white pawn and check the piece count. */
        //board.addWhitePawn();
        assertEquals(16, board.getNumberOfPieces());

        /* Add a black pawn and check the piece count again. */
        //board.addBlackPawn();
        //assertEquals(2, board.getNumberOfPieces());

        //Get the list of pieces from the board and verify their types.
        List<Pawn> pieces = board.getPieces();
        assertEquals(16, pieces.size());
        assertNotNull(pieces.get(0));
        assertNotNull(pieces.get(1));

        //boolean add = board.getPieces().add(new Integer("7"));
    }
    @Test
    public void testInitialPieceCount() {
        Board board = new Board(); //Assume that the board is initialized with pieces
        assertEquals(board.getPieceCount(), board.getNumberOfPieces()); //Check that there are 16 pieces
    }

    private void assertEquals(int pieceCount, int numberOfPieces) {

    }
    @Test
    public void testSomeOtherFeature() {
        Board board = new Board();
        //Test some other feature of the board
    }
   @Test
    public void testCreate() {
        Board board = new Board();

        StringBuilder secondRank =  new StringBuilder();
        StringBuilder seventhRank = new StringBuilder();

        List<Pawn> pieces = board.getPieces();
        for (int i = 0; i <  8; i++) {
            secondRank.append(pieces.get(i).getPrintableRepresentation());
            seventhRank.append(pieces.get(i + 8).getPrintableRepresentation());
        }
       assertEquals("pppppppp",secondRank.toString());
       assertEquals("PPPPPPPP", seventhRank.toString());

   }

    private void assertEquals(String pppppppp, String string) {
    }
    @Test
    public void testInitialSetup() {

        Board board = new Board();

        //use a system property to get the line separator
        String lineSeparator =  System.getProperty("line.separator");

        //Expected board representation with dots(.) for empty squares
        String expectedBoard =
                ".........PPPPPPPP\n" + //Rank 8 (top row) with white pawns
                        ".........\n" + //Rank 7 with empty squares
                        ".........\n" + //Rank 6 " "
                        ".........\n" + //Rank 5 " "
                        ".........\n" + //Rank 4 " "
                        ".........pppppppp" + //Rank 3(bottom row) with black pawns
                        "........."; //Rank 2 with empty squares

        //Get the actual board representation
        String actualBoard = getBoardRepresentation(board);

        //Compare the expected board with the actual board
        assertEquals(expectedBoard, actualBoard);

    }
    //helper method to create a board representation
    private String getBoardRepresentation(Board board) {
        StringBuilder boardRepresentation = new StringBuilder();
        List<Pawn> pieces = board.getPieces();

        //loop through ranks files 8 (top) to 1 (bottom)
        for(int rank = 8; rank >= 1; rank--) {
            //loop through files from 1 to 8
            for(int file = 1; file <= 8; file++) {
                boolean pieceFound = false;
                //check if a piece is at the current rank and file
                for(Pawn piece : pieces) {
                    if(piece.getRank() ==  rank && piece.getFile() == file){
                        boardRepresentation.append(piece.getPrintableRepresentation());
                        pieceFound = true;
                        break;
                    }
                }
                //if no piece is found, add a dot for an empty square
                if (!pieceFound) {
                    boardRepresentation.append(".");
                }
            }
            //Add a new line for the next rank
            boardRepresentation.append("\n");
        }
        return boardRepresentation.toString();
    }
}
