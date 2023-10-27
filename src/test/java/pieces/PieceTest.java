package pieces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PieceTest{
  private Piece blackPawn;
  private Piece whitePawn;

  @Before
    public void setUp() {
      blackPawn = Piece.createPiece("Black", Piece.PieceType.valueOf("PAWN"));
      whitePawn = Piece.createPiece("White", Piece.PieceType.valueOf("PAWN"));
  }
  @Test
    public void testCreatePiece() {
      assertEquals("Black", blackPawn.getColor());
      assertEquals(Piece.PieceType.PAWN, blackPawn.getType());

      assertEquals("White", whitePawn.getColor());
      assertEquals(Piece.PieceType.PAWN, whitePawn.getType());
  }
  @Test
  public void testIsBlackOrWhite() {
    Piece blackPiece = Piece.createPiece(Piece.BLACK, Piece.PieceType.PAWN);
    assertTrue(blackPiece.isBlack());

    Piece whitePiece = Piece.createPiece(Piece.WHITE, Piece.PieceType.PAWN);
    assertTrue(whitePiece.isWhite());

  }
}