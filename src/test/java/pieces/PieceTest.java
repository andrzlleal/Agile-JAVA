package pieces;

import org.junit.Test;

import static org.junit.Assert.*;
import static pieces.Piece.Color.BLACK;
import static pieces.Piece.Color.WHITE;

public class PieceTest{
   @Test
   public void testCreateWhitePawn() {
     Piece whitePawn = Piece.createWhitePawn();

     assertEquals(WHITE, whitePawn.getColor());
     assertEquals('p', whitePawn.getPieceRepresentation());
   }
   @Test
   public void testCreateBlackPawn() {
     Piece blackPawn = Piece.createBlackPawn();

     assertEquals(BLACK, blackPawn.getColor());
     assertEquals('P', blackPawn.getPieceRepresentation());
   }

  @Test
  public void testCreateWhiteRook() {
    Piece whiteRook = Piece.createWhiteRook();
    assertEquals(WHITE, whiteRook.getColor());
    assertEquals('r', whiteRook.getPieceRepresentation());
  }

  @Test
  public void testCreateBlackRook() {
    Piece blackRook = Piece.createBlackRook();
    assertEquals(BLACK, blackRook.getColor());
    assertEquals('R', blackRook.getPieceRepresentation());
  }

  @Test
  public void testCreateWhiteKnight() {
    Piece whiteKnight = Piece.createWhiteKnight();
    assertEquals(WHITE, whiteKnight.getColor());
    assertEquals('n', whiteKnight.getPieceRepresentation());
  }

  @Test
  public void testCreateBlackKnight() {
    Piece blackKnight = Piece.createBlackKnight();
    assertEquals(BLACK, blackKnight.getColor());
    assertEquals('N', blackKnight.getPieceRepresentation());
  }

  @Test
  public void testCreateWhiteBishop() {
    Piece whiteBishop = Piece.createWhiteBishop();
    assertEquals(WHITE, whiteBishop.getColor());
    assertEquals('b', whiteBishop.getPieceRepresentation());
  }

  @Test
  public void testCreateBlackBishop() {
    Piece blackBishop = Piece.createBlackBishop();
    assertEquals(BLACK, blackBishop.getColor());
    assertEquals('B', blackBishop.getPieceRepresentation());
  }

  @Test
  public void testCreateWhiteQueen() {
    Piece whiteQueen = Piece.createWhiteQueen();
    assertEquals(WHITE, whiteQueen.getColor());
    assertEquals('q', whiteQueen.getPieceRepresentation());
  }

  @Test
  public void testCreateBlackQueen() {
    Piece blackQueen = Piece.createBlackQueen();
    assertEquals(BLACK, blackQueen.getColor());
    assertEquals('Q', blackQueen.getPieceRepresentation());
  }

  @Test
  public void testCreateWhiteKing() {
    Piece whiteKing = Piece.createWhiteKing();
    assertEquals(WHITE, whiteKing.getColor());
    assertEquals('k', whiteKing.getPieceRepresentation());
  }

  @Test
  public void testCreateBlackKing() {
    Piece blackKing = Piece.createBlackKing();
    assertEquals(BLACK, blackKing.getColor());
    assertEquals('K', blackKing.getPieceRepresentation());
  }

  @Test
  public void testIsValidMoveForPawn() {
    Piece whitePawn = Piece.createWhitePawn();
    assertTrue(whitePawn.isValidMove(1, 2, 1, 3));  // Exemplo de movimento válido para peão branco.
    assertFalse(whitePawn.isValidMove(1, 2, 2, 3));  // Exemplo de movimento inválido para peão branco.
  }
  @Test
  public void testGetRepresentationForNoPiece() {
    Piece noPiece = Piece.noPiece();
    assertEquals('.', noPiece.getRepresentation());
  }

  @Test
  public void testCompareTo() {
    Piece whitePawn1 = Piece.createWhitePawn();
    Piece whitePawn2 = Piece.createWhitePawn();
    Piece blackPawn = Piece.createBlackPawn();

    Piece noPiece = NoPiece.getInstance();

    whitePawn1.setStrength(2.0);
    whitePawn2.setStrength(1.5);
    blackPawn.setStrength(3.0);
    noPiece.setStrength(0.0);

    assertTrue(whitePawn1.compareTo(blackPawn) < 0);
    assertTrue(blackPawn.compareTo(whitePawn1) > 0);
    assertEquals(0, noPiece.compareTo(noPiece));
  }
  @Test
  public void testGetPossibleMovesForNoPiece() {
    Piece noPiece = Piece.noPiece();
    assertNull(noPiece.getPossibleMoves("a1"));
  }
  @Test
  public void testGetPointValue() {
    assertEquals(1.0, Pawn.getPieceValue(), 0.01);
    assertEquals(2.5, Knight.getPieceValue(), 0.01);
    assertEquals(3.0, Bishop.getPieceValue(), 0.01);
    assertEquals(5.0, Rook.getPieceValue(), 0.01);
    assertEquals(9.0, Queen.getPieceValue(),0.01);
    assertEquals(0, King.getPieceValue(), 0.01);
    assertEquals(0, NoPiece.getPieceValue(), 0.01);
  }

  @Test
  public void testPiecePosition() {
    Piece whitePiece = new Pawn(WHITE) {
      @Override
      public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        return false;
      }

      @Override
      public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
        return false;
      }
    };

    whitePiece.setFile(2);
    whitePiece.setRank(3);

    assertEquals(2, whitePiece.getFile());
    assertEquals(3, whitePiece.getRank());

    whitePiece.setFile(4);
    whitePiece.setRank(5);

    assertEquals(4, whitePiece.getFile());
    assertEquals(5, whitePiece.getRank());
  }
  @Test
  public void testIndexOfForPiece() {
    Piece whitePawn = Piece.createWhitePawn();
    Piece[][] board = new Piece[8][8];
    board[1][1] = whitePawn;
    assertEquals(9, whitePawn.indexOf(board));
  }

  @Test
  public void testIndexOfForNoPiece() {
    Piece noPiece = Piece.noPiece();
    Piece[][] board = new Piece[8][8];
    assertEquals(-1, noPiece.indexOf(board));
  }


}