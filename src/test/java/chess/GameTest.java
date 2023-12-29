package chess;

import org.junit.Before;
import org.junit.Test;
import pieces.King;
import pieces.Piece;
import pieces.Queen;

import static org.junit.Assert.*;

public class GameTest {

    @Before
    public void setUp() {
        Game game = new Game();
        game.startGame();
    }
    @Test
    public void testStartGame() {
        Game game = new Game();
        game.startGame();

        assertEquals("rnbqkbnr\npppppppp\n........\n........\n........\n........\nPPPPPPPP\nRNBQKBNR",
        game.board.getBoardRepresentation());

        assertEquals(32, game.board.getNumberOfPieces());
    }
    @Test
    public void testMovePieceValid() {
        Game game = new Game();
        game.startGame();

        assertTrue(game.movePiece("e2", "e5"));
        assertTrue(game.movePiece("a1", "a2"));
    }

    @Test
    public void testMovePieceInvalid() {
        Game game = new Game();
        game.startGame();

        assertFalse(game.movePiece("e3", "e5"));
    }



//    @Test
//    public void testMovePawnsInSameColumn() {
//        double initialWhitePawnValue = game.board.getPieceValue("d2");
//        double initialBlackPawnValue = game.board.getPieceValue("d7");
//        System.out.printf("Initial white Pawn value: " + initialWhitePawnValue);
//
//        System.out.printf("Initial Black Pawn value: " + initialBlackPawnValue);
//
//        chessGame.movePiece("d2", "d4");
//        chessGame.movePiece("d7", "d5");
//
//        double updatedWhitePawnValue = game.board.getPieceValue("d4");
//        double updatedBlackPawnValue = game.board.getPieceValue("d5");
//
//        System.out.printf("Update white pawn Value " + updatedWhitePawnValue);
//
//        System.out.printf("Update black pawn Value " + updatedBlackPawnValue);
//
//        assertEquals(initialWhitePawnValue, updatedWhitePawnValue, 0.01);
//        assertEquals(initialBlackPawnValue, updatedBlackPawnValue, 0.01);
//    }
//    @Test
//    public void testMovePawnAndUpdateScore() {
//        double initialScore = game.board.getPieceValue("e2");
//
//        chessGame.movePiece("e2", "e4");
//
//        double updatedScore = game.board.getPieceValue("e4");
//
//        assertEquals(initialScore, updatedScore, 0.01);
//    }
//    @Test
//    public void testGetPieceValueAfterMove() {
//        double initialQueenValue = game.board.getPieceValue("d1");
//        chessGame.movePiece("d1", "d4");
//        double updatedQueenValue = game.board.getPieceValue("d4");
//
//        assertEquals(initialQueenValue, updatedQueenValue, 0.01);
//
//        double initialRookValue = game.board.getPieceValue("a1");
//        chessGame.movePiece("a1", "b4");
//        double updatedRookValue = game.board.getPieceValue("b4");
//
//        assertEquals(initialRookValue, updatedRookValue, 0.01);
//
//        double initialPawnValue = game.board.getPieceValue("a2");
//        chessGame.movePiece("a2", "a4");
//        double updatedPawnValue = game.board.getPieceValue("a4");
//
//        assertEquals(initialPawnValue, updatedPawnValue, 0.01);
//    }
    @Test
    public void testMoveKing() {
        Game game = new Game();
        game.startGame();

        game.board.placePieceAt(new King(Piece.Color.WHITE), "e1");

        assertTrue(game.moveKing("e1", "d1"));
        assertTrue(game.board.getPieceAt("d1") instanceof King);

        game.board.initializeBoard();
        game.board.placePieceAt(new King(Piece.Color.WHITE), "e1");

        assertTrue(game.moveKing("e1", "f1"));
        assertTrue(game.board.getPieceAt("f1") instanceof King) ;

    }
    @Test
    public void testInvalidMoveKing() {
        Game game = new Game();
        game.board.placePieceAt(new King(Piece.Color.WHITE), "e1");

        assertFalse(game.moveKing("e1", "e3"));
        assertFalse(game.moveKing("e1", "e1"));
        assertFalse(game.moveKing("e1", "e3"));
    }
    @Test
    public void testMoveQueen() {
        Game game = new Game();
        game.board.placePieceAt(new Queen(Piece.Color.WHITE), "d1");

        //testa movimento válido para a rainha branca
        assertTrue(game.moveQueen("d1", "g4"));
        assertTrue(game.board.getPieceAt("g4") instanceof Queen);

        game.board.initializeBoard();
        game.board.placePieceAt(new Queen(Piece.Color.WHITE), "d1");

        assertTrue(game.moveQueen("d1", "a1"));
        assertTrue(game.board.getPieceAt("a1") instanceof Queen);
    }

        @Test
        public void testInvalidQueenMove() {
            Game game = new Game();
            game.board.placePieceAt(new Queen(Piece.Color.WHITE), "d1");

            assertFalse(game.moveQueen("d1", "e3"));
            assertFalse(game.moveQueen("d1", "j10"));
        }
}