package chess;

import org.junit.Before;
import org.junit.Test;
import pieces.Piece;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testInitializeBoard() {
        System.out.println(board.getBoardRepresentation());

        assertEquals(0, board.getNumberOfPieces());

        String expectedEmptyBoard =
                """
                        ........
                        ........
                        ........
                        ........
                        ........
                        ........
                        ........
                        ........""";

        assertEquals(expectedEmptyBoard, board.getBoardRepresentation().replaceAll(" ", ""));
    }
    @Test
    public void testBoardWithPieces() {
        board.initializeBoard();

        assertEquals(32, board.getNumberOfPieces());
        assertEquals(16, board.whitePieceCount());
        assertEquals(16, board.blackPieceCount());

        String expectedBoard =
                """
                RNBQKBNR
                PPPPPPPP
                ........
                ........
                ........
                ........
                pppppppp
                rnbqkbnr""";

        assertEquals(expectedBoard, board.getBoardRepresentation().replaceAll(" ", ""));
    }

    @Test
    public void testCountPieces() {

        board.initializeBoard();

        int whitePawnCount = board.countPieces(Piece.Color.WHITE, 'p');
        assertEquals(8, whitePawnCount);

        int blackPawnCount = board.countPieces(Piece.Color.BLACK, 'P');
        assertEquals(8, blackPawnCount);

        int whiteRookCount = board.countPieces(Piece.Color.WHITE, 'r');
        assertEquals(2, whiteRookCount);

        int blackRookCount = board.countPieces(Piece.Color.BLACK, 'R');
        assertEquals(2, blackRookCount);

        int whiteKnightCount = board.countPieces(Piece.Color.WHITE, 'n');
        assertEquals(2, whiteKnightCount);

        int blackKnightCount = board.countPieces(Piece.Color.BLACK, 'N');
        assertEquals(2, blackKnightCount);

        int whiteQueenCount = board.countPieces(Piece.Color.WHITE, 'q');
        assertEquals(1, whiteQueenCount);

        int blackQueenCount = board.countPieces(Piece.Color.BLACK, 'Q');
        assertEquals(1, blackQueenCount);

        int whiteKingCount = board.countPieces(Piece.Color.WHITE, 'k');
        assertEquals(1, whiteKingCount);

        int blackKingCount = board.countPieces(Piece.Color.BLACK, 'K');
        assertEquals(1, blackKingCount);

        int whiteBishopCount = board.countPieces(Piece.Color.WHITE, 'b');
        assertEquals(2, whiteBishopCount);

        int blackBishopCount = board.countPieces(Piece.Color.BLACK, 'B');
        assertEquals(2, blackBishopCount);
    }
    @Test
    public void testSelectPieces() {
        board.initializeBoard();

        Piece selectedPiece = board.getPieceAt(3, 0);

        assertEquals('Q' + "", selectedPiece.getRepresentation() + "");

        Piece anotherPiece = board.getPieceAt(3, 7);

        assertEquals('q', anotherPiece.getRepresentation());
    }
    @Test
    public void testCreatePieceForIndex() {
        board.initializeBoard();
        assertEquals('r'+ "", Piece.createPieceForIndex(7).getRepresentation() + "");
    }
    @Test
    public void testPlacePieceAt() {
        Piece customPiece = Piece.createBlackPawn();

        int file = 2;
        int rank = 3;

        board.placePieceAt(customPiece, file, rank);
        Piece retrievedPiece = board.getPieceAt(rank, file);

        assertEquals(customPiece.getRepresentation(), retrievedPiece.getRepresentation());
    }
    @Test
    public void testAssignAndSortPieceValues() {
        board.initializeBoard();
        board.assignPieceValues();

        assertEquals(32, board.getNumberOfPieces());

        Piece firstPiece = board.getPieceAt(0, 0);
        Piece lastPiece = board.getPieceAt(7, 7);

        assertEquals('R', firstPiece.getRepresentation());
        assertEquals('r', lastPiece.getRepresentation());
}
    @Test
    public void testIsSameColor() {
        assertTrue(board.isSameColor(Piece.Color.WHITE, 'a'));
        assertTrue(board.isSameColor(Piece.Color.BLACK, 'B'));
        assertFalse(board.isSameColor(Piece.Color.WHITE, 'B'));
        assertFalse(board.isSameColor(Piece.Color.BLACK, 'a'));
    }
    @Test
    public void testIsValidPosition() {
        assertTrue(board.isValidPosition("a1"));
        assertTrue(board.isValidPosition("h8"));
        assertFalse(board.isValidPosition("i1"));
        assertFalse(board.isValidPosition("a9"));
    }
    @Test
    public void testPositionToIndex() {
        assertEquals(0, board.positionToIndex("a1"));
        assertEquals(7, board.positionToIndex("h1"));
        assertEquals(56, board.positionToIndex("a8"));
        assertEquals(27, board.positionToIndex("d4"));
    }
    @Test
    public void testGetPieceValue() {
        board.initializeBoard();

        String position = "e2";
        double pieceValue = board.getPieceValue(position);
        assertTrue(pieceValue >= 0.0);
    }

}

