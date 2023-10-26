package pieces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PieceTest{
  private Piece piece;
  private Piece whitePawn;

  @Before
    public void setUp() {
      piece = Piece.createPiece("Black", Piece.PieceType.valueOf("KING"));
      whitePawn = Piece.createPiece("White", Piece.PieceType.valueOf("PAWN"));
  }
  @Test
    public void testCreatePiece() {
      assertEquals("Black", piece.getColor());
      assertEquals(Piece.PieceType.KING, piece.getType());

      assertEquals("White", whitePawn.getColor());
      assertEquals(Piece.PieceType.PAWN, whitePawn.getType());
  }
}