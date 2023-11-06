package pieces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pieces.Piece.Color.BLACK;
import static pieces.Piece.Color.WHITE;

public class PieceTest{
  private Piece blackPawn;
  private Piece whitePawn;

  @Before
    public void setUp() {
      blackPawn = Piece.createPiece(BLACK, Piece.PieceType.valueOf("PAWN"));
      whitePawn = Piece.createPiece(WHITE, Piece.PieceType.valueOf("PAWN"));
  }
  @Test
    public void testCreatePiece() {
      assertEquals(BLACK, blackPawn.getColor());
      assertEquals(Piece.PieceType.PAWN, blackPawn.getType());

      assertEquals(WHITE, whitePawn.getColor());
      assertEquals(Piece.PieceType.PAWN, whitePawn.getType());
  }
  @Test
  public void testIsBlackOrWhite() {
    Piece blackPiece = Piece.createPiece(BLACK, Piece.PieceType.PAWN);
    assertTrue(blackPiece.isBlack());

    Piece whitePiece = Piece.createPiece(WHITE, Piece.PieceType.PAWN);
    assertTrue(whitePiece.isWhite());
  }
  @Test
  public void testCreate() {
    verifyCreation(
            Piece.createWhitePawn(),
            Piece.createBlackPawn(),
            Piece.PieceType.PAWN,
            Piece.PAWN_REPRESENTATION
    );
    verifyCreation(
            Piece.createWhiteRook(),
            Piece.createBlackRook(),
            Piece.PieceType.ROOK,
            Piece.ROOK_REPRESENTATION

    );
    verifyCreation(
            Piece.createWhiteKnight(),
            Piece.createBlackKnight(),
            Piece.PieceType.KNIGHT,
            Piece.KNIGHT_REPRESENTATION
    );
    verifyCreation(
            Piece.createWhiteQueen(),
            Piece.createBlackQueen(),
            Piece.PieceType.QUEEN,
            Piece.QUEEN_REPRESENTATION
    );
    verifyCreation(
            Piece.createWhiteKing(),
            Piece.createBlackKing(),
            Piece.PieceType.KING,
            Piece.KING_REPRESENTATION
    );
    verifyCreation(
            Piece.createWhiteBishop(),
            Piece.createBlackBishop(),
            Piece.PieceType.BISHOP, Piece.BISHOP_REPRESENTATION);

    Piece blank = Piece.noPiece();
    assertEquals('.', blank.getRepresentation());
    assertEquals(Piece.PieceType.NO_PIECE, blank.getType());
  }

  private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.PieceType type, char representation) {
    assertTrue(whitePiece.isWhite());
    assertEquals(type, whitePiece.getType());
    assertEquals(representation, whitePiece.getRepresentation());

    assertTrue(blackPiece.isBlack());
    assertEquals(type, blackPiece.getType());
    assertEquals(Character.toUpperCase(representation),
            blackPiece.getRepresentation());
  }

}