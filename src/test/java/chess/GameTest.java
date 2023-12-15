package chess;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Before
    public void setUp() {
        Game chessGame = new Game();
        chessGame.startGame();
    }
    @Test
    public void testStartGame() {
        Game chessGame = new Game();
        chessGame.startGame();

        assertEquals("rnbqkbnr\npppppppp\n........\n........\n........\n........\nPPPPPPPP\nRNBQKBNR",
        chessGame.board.getBoardRepresentation());

        assertEquals(32, chessGame.board.getNumberOfPieces());

        //add testes específicos de inicio do jogo conforme necessário
        //assertEquals(Esperado, chessGame.getNumberOfPieces());
    }
    @Test
    public void testMovePiece() {
        Game chessGame = new Game();
        chessGame.startGame();

        int initialNumberOfPieces = chessGame.board.getNumberOfPieces();
        chessGame.movePiece("d1", "d4");

        assertEquals(initialNumberOfPieces, chessGame.board.getNumberOfPieces());
    }
    @Test
    public void testMovePawnsInSameColumn() {
        Game chessGame = new Game();
        chessGame.startGame();

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
        Game chessGame = new Game();
        chessGame.startGame();

        double initialScore = chessGame.board.getPieceValue("e2");

        chessGame.movePiece("e2", "e4");

        double updatedScore = chessGame.board.getPieceValue("e4");

        assertEquals(initialScore, updatedScore, 0.01);
    }
    @Test
    public void testGetPieceValueAfterMove() {
        Game chessGame = new Game();
        chessGame.startGame();

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
        Game chessGame = new Game();
        chessGame.startGame();

        String initialPosition = "e1";

        String validMove1 = "d1";
        String validMove2 = "f1";
        String validMove3 = "d2";

        chessGame.moveKing(initialPosition, validMove1);
        assertEquals('k', chessGame.board.getPieceAt(validMove1).getType().getRepresentation());

        chessGame.board.initializeBoard();

        chessGame.moveKing(initialPosition, validMove2);
        assertEquals('k', chessGame.board.getPieceAt(validMove2).getType().getRepresentation());

        chessGame.board.initializeBoard();

        chessGame.moveKing(initialPosition, validMove3);
        assertEquals('k', chessGame.board.getPieceAt(validMove3).getType().getRepresentation());

    }
}