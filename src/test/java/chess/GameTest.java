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

        assertEquals("RNBQKBNR\nPPPPPPPP\n........\n........\n........\n........\npppppppp\nrnbqkbnr",
        game.board.getBoardRepresentation().replaceAll(" ", ""));

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

    @Test
    public void testMoveKing() {
        Game game = new Game();
        game.startGame();

        game.board.placePieceAt(new King(Piece.Color.WHITE) {
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                int fileDifference = Math.abs(toFile - fromFile);
                int rankDifference = Math.abs(toRank - fromRank);

                return fileDifference <= 1 && rankDifference <= 1;

            }
        }, 4, 0);
        assertTrue(game.moveKing("e1", "d1"));

        game.board.initializeBoard();

        game.board.placePieceAt(new King(Piece.Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        },4,0);

        assertTrue(game.moveKing("e1", "f1"));
    }
    @Test
    public void testInvalidMoveKing() {
        Game game = new Game();
        int fromRank = 0;

        game.board.placePieceAt(new King(Piece.Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        }, 4, fromRank);

        assertFalse(game.moveKing("e1", "e3"));
        assertFalse(game.moveKing("e1", "e1"));
        assertFalse(game.moveKing("e1", "e3"));
    }
    @Test
    public void testMoveQueen() {
        Game game = new Game();
        game.startGame();

        game.board.placePieceAt(new Queen(Piece.Color.WHITE) {

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
                return false;
            }
        }, 3, 0);

        assertTrue(game.moveQueen("d1", "g4"));


    }
    @Test
    public void testInvalidQueenMove() {
        Game game = new Game();
        int fromRank = 0;
        game.board.placePieceAt(new Queen(Piece.Color.WHITE) {

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
                return false;
            }
        }, 3, fromRank);

        assertFalse(game.moveQueen("d1", "e3"));
        assertFalse(game.moveQueen("d1", "j10"));
    }
}