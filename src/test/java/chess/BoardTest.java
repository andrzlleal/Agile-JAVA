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
    }

    @Test
    public void testInitializeBoard() {
        assertEquals(0, board.getNumberOfPieces());

        String expectedBoard =
                """
                        ........
                        ........
                        ........
                        ........
                        ........
                        ........
                        ........
                        ........""";

        String actualBoard = board.getBoardRepresentation();
        assertEquals(expectedBoard, actualBoard);

    }
    @Test
    public void testBoardWithPieces() {
        board.initializeBoard();
        assertEquals(32, board.getNumberOfPieces());
        assertEquals(16, board.whitePieceCount());
        assertEquals(16, board.blackPieceCount());

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

        String actualBoard = board.getBoardRepresentation();
        assertEquals(expectedBoard, actualBoard);
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

        assertEquals('q' + "", board.getPieceAt("d1").getRepresentation() + "");
        assertEquals('R' + "", board.getPieceAt("a8").getRepresentation() + "");
    }
    @Test
    public void testCreatePieceForIndex() {
        board.initializeBoard();

        assertEquals('r'+ "", Piece.createPieceForIndex(7).getRepresentation() + "");
    }
    @Test
    public void testPlacePieceAt() {
        Piece customPiece = Piece.createBlackPawn();

        board.placePieceAt(customPiece, "c4");
        assertEquals(customPiece.getRepresentation(), board.getPieceAt("c4").getRepresentation());
    }
    @Test
    public void testGetPieceValue() {
        board.initializeBoard();

        assertEquals(1.5, board.getPieceValue("d2"), 0.01);
        assertEquals(9.0, board.getPieceValue("d1"), 0.01);
        assertEquals(3.0, board.getPieceValue("f1"), 0.01);

        assertEquals(-9.0, board.getPieceValue("d8"), 0.01);

    }
    //teste com erro de expectativa
    @Test
    public void testAssignAndSortPieceValues() {
        board.initializeBoard();
        Piece customPiece = Piece.createBlackPawn();
        board.assignPieceValues();

        // Testes básicos de força
        assertEquals(1.0, board.getPieceAt("d2").getStrength(), 0.01);
        assertEquals(-1.0, board.getPieceAt("e7").getStrength(), 0.01);
        assertEquals(5.0, board.getPieceAt("a1").getStrength(), 0.01);
        assertEquals(-5.0, board.getPieceAt("a8").getStrength(), 0.01);

        // Testes para peões na mesma coluna
        assertEquals(1.5, board.getPieceAt("d2").getStrength(), 0.01);
        assertEquals(-1.5, board.getPieceAt("e7").getStrength(), 0.01);

        // Testes para outros tipos de peças na mesma coluna (deve manter a pontuação original)
        assertEquals(5.0, board.getPieceAt("a2").getStrength(), 0.01);
        assertEquals(-5.0, board.getPieceAt("a7").getStrength(), 0.01);

        // Testes para peões de cores diferentes na mesma coluna (deve manter a pontuação original)
        assertEquals(1.0, customPiece.getStrength(), 0.01);
    }

}



