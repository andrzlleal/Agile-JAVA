package chess;

import org.junit.Before;
import org.junit.Test;
import pieces.King;
import pieces.Piece;
import pieces.Queen;

import static org.junit.Assert.*;

public class GameTest {
    private Game chessGame;
    @Before
    public void setUp() {
        chessGame = new Game();
        chessGame.startGame();
    }
    @Test
    public void testStartGame() {
        assertEquals("rnbqkbnr\npppppppp\n........\n........\n........\n........\nPPPPPPPP\nRNBQKBNR",
        chessGame.board.getBoardRepresentation());

        assertEquals(32, chessGame.board.getNumberOfPieces());

        //add testes específicos de inicio do jogo conforme necessário
        //assertEquals(Esperado, chessGame.getNumberOfPieces());
    }
    @Test
    public void testMovePiece() {
        int initialNumberOfPieces = chessGame.board.getNumberOfPieces();
        chessGame.movePiece("d1", "d4");

        assertEquals(initialNumberOfPieces, chessGame.board.getNumberOfPieces());
    }
    @Test
    public void testMovePawnsInSameColumn() {
        double initialWhitePawnValue = chessGame.board.getPieceValue("d2");
        double initialBlackPawnValue = chessGame.board.getPieceValue("d7");

        chessGame.movePiece("d2", "d4");
        chessGame.movePiece("d7", "d5");

        double updatedWhitePawnValue = chessGame.board.getPieceValue("d4");
        double updatedBlackPawnValue = chessGame.board.getPieceValue("d5");

        assertEquals(initialWhitePawnValue, updatedWhitePawnValue, 0.01);
        assertEquals(initialBlackPawnValue, updatedBlackPawnValue, 0.01);
    }
    @Test
    public void testMovePawnAndUpdateScore() {
        double initialScore = chessGame.board.getPieceValue("e2");

        chessGame.movePiece("e2", "e4");

        double updatedScore = chessGame.board.getPieceValue("e4");

        assertEquals(initialScore, updatedScore, 0.01);
    }
    @Test
    public void testGetPieceValueAfterMove() {
        double initialQueenValue = chessGame.board.getPieceValue("d1");
        chessGame.movePiece("d1", "d4");
        double updatedQueenValue = chessGame.board.getPieceValue("d4");

        assertEquals(initialQueenValue, updatedQueenValue, 0.01);

        double initialRookValue = chessGame.board.getPieceValue("a1");
        chessGame.movePiece("a1", "b4");
        double updatedRookValue = chessGame.board.getPieceValue("b4");

        assertEquals(initialRookValue, updatedRookValue, 0.01);

        double initialPawnValue = chessGame.board.getPieceValue("a2");
        chessGame.movePiece("a2", "a4");
        double updatedPawnValue = chessGame.board.getPieceValue("a4");

        assertEquals(initialPawnValue, updatedPawnValue, 0.01);
    }
    @Test
    public void testMoveKing() {
        Game game = new Game();
        game.board.placePieceAt(new King(Piece.Color.WHITE), "e1");

        assertTrue(game.moveKing("e1", "d1"));
        assertEquals('k', game.board.getPieceAt("d1").getType().getRepresentation());

        game.board.initializeBoard();
        game.board.placePieceAt(new King(Piece.Color.WHITE), "e1");

        assertTrue(game.moveKing("e1", "f1"));
        assertEquals('k', game.board.getPieceAt("f1").getType().getRepresentation());

    }
    @Test
    public void testMoveQueen() {
        Game game = new Game();
        game.board.placePieceAt(new Queen(Piece.Color.WHITE), "d1");

        //testa movimento válido para a rainha branca
        assertTrue(game.moveQueen("d1", "g4"));
        assertEquals('q', game.board.getPieceAt("g4").getType().getRepresentation());

        game.board.initializeBoard();
        game.board.placePieceAt(new Queen(Piece.Color.WHITE), "d1");

        assertTrue(game.moveQueen("d1", "a1"));
        assertEquals('q', game.board.getPieceAt("a1").getType().getRepresentation());
    }

    @Test
    public void testInvalidQueenMove() {
        String validStartPosition = "d1";
        String invalidMove = "e3";

        assertFalse(chessGame.moveQueen(validStartPosition, invalidMove));
    }
}