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

        assertEquals('q' +"", board.getPieceAt("d1").getRepresentation() +"");
        assertEquals('R' + "", board.getPieceAt("a8").getRepresentation() + "");

    }
    @Test
    public void testCreatePieceForIndex() {
        board.initializeBoard();

        assertEquals('r'+ "", Piece.createPieceForIndex(7).getRepresentation() + "");
    }
    @Test
    public void testPlacePieceAt() {
        Piece customPiece = Piece.createCustomPiece();

        // Coloca a peça personalizada na posição "c4"
        board.placePieceAt(customPiece, "c4");

        // Verifica se a peça está na posição correta
        assertEquals(customPiece, board.getPieceAt("c4"));
    }

//    @Test
//    public void testPlacePieceAtInvalidPosition() {
//        Piece customPiece = Piece.createCustomPiece();
//
//        // Tenta colocar a peça personalizada em uma posição inválida
//        board.placePieceAt(customPiece, "i9");
//
//        // Verifica se a peça não foi colocada em uma position inválida
//        assertEquals(Piece.noPiece(), board.getPieceAt("i9"));
//    }

}