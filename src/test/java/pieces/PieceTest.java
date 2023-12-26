package pieces;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static pieces.Piece.Color.BLACK;
import static pieces.Piece.Color.WHITE;

public class PieceTest implements Comparable<Piece>{
    private double strength;

  @Override
  public int compareTo(Piece otherPiece) {
    return Double.compare(otherPiece.getStrength(), this.getStrength());
  }

  public double getStrength() {
    return this.strength;
  }

//  @Before
//    public void setUp() {
//      Piece.createPiece(BLACK, Piece.PieceType.PAWN);
//      Piece.createPiece(WHITE, Piece.PieceType.PAWN);
//  }

  @Test
    public void testCreatePiece() {
      Piece blackPawn = Piece.createPiece(BLACK, Pawn.class);
      Piece whitePawn = Piece.createPiece(WHITE, Pawn.class);

      assertEquals(BLACK, blackPawn.getColor());
  }
  @Test
  public void testIsBlackOrWhite() {
    Piece blackPiece = Piece.createPiece(BLACK, Pawn.class);
    assertTrue(blackPiece.isBlack());

    Piece whitePiece = Piece.createPiece(WHITE, Pawn.class);
    assertTrue(whitePiece.isWhite());
  }
  @Test
  public void testCreate() {
    verifyCreation(
            Piece.createWhitePawn(),
            Piece.createBlackPawn(),
            Pawn.class,
            Piece.createWhitePawn().getRepresentation()
    );
    verifyCreation(
            Piece.createWhiteRook(),
            Piece.createBlackRook(),
            Rook.class,
            Piece.createWhiteRook().getRepresentation()

    );
    verifyCreation(
            Piece.createWhiteKnight(),
            Piece.createBlackKnight(),
            Knight.class,
            Piece.createWhiteKnight().getRepresentation()
    );
    verifyCreation(
            Piece.createWhiteQueen(),
            Piece.createBlackQueen(),
            Queen.class,
            Piece.createWhiteQueen().getRepresentation()
    );
    verifyCreation(
            Piece.createWhiteKing(),
            Piece.createBlackKing(),
            King.class,
            Piece.createWhiteKing().getRepresentation()
    );
    verifyCreation(
            Piece.createWhiteBishop(),
            Piece.createBlackBishop(),
            Bishop.class,
            Piece.createWhiteBishop().getRepresentation()
    );

    Piece blank = Piece.noPiece();
    assertEquals('.', Piece.noPiece().getRepresentation());
  }

  private void verifyCreation(Piece whitePiece, Piece blackPiece, Class<? extends Piece> pieceClass, char representation) {
    assertTrue(whitePiece.isWhite());
    assertEquals(pieceClass, whitePiece.getClass());
    assertEquals(representation, whitePiece.getRepresentation());

    assertTrue(blackPiece.isBlack());
    assertEquals(pieceClass, blackPiece.getClass());
    assertEquals(Character.toUpperCase(representation),
            blackPiece.getRepresentation());
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
  public void testGetPossibleMovesForQueen() {
    Piece queen = new Queen(WHITE);
    String currentPosition = "d4";
    List<String> possibleMoves = queen.getPossibleMoves(currentPosition);

    List<String> expectedMoves = Arrays.asList(
            "c5", "c4", "c3", "d5", "d4", "d3", "e5", "e4", "e3"
    );
    assertEquals(expectedMoves, possibleMoves);
}
@Test
  public void testGetPossibleMovesForNoPiece() {
    Piece noPiece = Piece.noPiece();
    List<String> possibleMoves = noPiece.getPossibleMoves("a1");

    assertNull(possibleMoves);
  }

}