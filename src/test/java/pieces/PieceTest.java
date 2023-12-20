package pieces;

import org.junit.Before;
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
  @Before
    public void setUp() {
      Piece.createPiece(BLACK, Piece.PieceType.PAWN);
      Piece.createPiece(WHITE, Piece.PieceType.PAWN);
  }

  @Test
    public void testCreatePiece() {
      Piece blackPawn = Piece.createPiece(BLACK, Piece.PieceType.PAWN);
      Piece whitePawn = Piece.createPiece(WHITE, Piece.PieceType.PAWN);

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
            Piece.PieceType.PAWN.getRepresentation()
    );
    verifyCreation(
            Piece.createWhiteRook(),
            Piece.createBlackRook(),
            Piece.PieceType.ROOK,
            Piece.PieceType.ROOK.getRepresentation()

    );
    verifyCreation(
            Piece.createWhiteKnight(),
            Piece.createBlackKnight(),
            Piece.PieceType.KNIGHT,
            Piece.PieceType.KNIGHT.getRepresentation()
    );
    verifyCreation(
            Piece.createWhiteQueen(),
            Piece.createBlackQueen(),
            Piece.PieceType.QUEEN,
            Piece.PieceType.QUEEN.getRepresentation()
    );
    verifyCreation(
            Piece.createWhiteKing(),
            Piece.createBlackKing(),
            Piece.PieceType.KING,
            Piece.PieceType.KING.getRepresentation()
    );
    verifyCreation(
            Piece.createWhiteBishop(),
            Piece.createBlackBishop(),
            Piece.PieceType.BISHOP,
            Piece.PieceType.BISHOP.getRepresentation());

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
@Test
  public void testGetPointValue() {
    assertEquals(1.0, Piece.PieceType.PAWN.getPointValue(), 0.01);
    assertEquals(2.5, Piece.PieceType.KNIGHT.getPointValue(), 0.01);
    assertEquals(3.0, Piece.PieceType.BISHOP.getPointValue(), 0.01);
    assertEquals(5.0, Piece.PieceType.ROOK.getPointValue(), 0.01);
    assertEquals(9.0, Piece.PieceType.QUEEN.getPointValue(),0.01);
    assertEquals(0, Piece.PieceType.KING.getPointValue(), 0.01);
    assertEquals(0, Piece.PieceType.NO_PIECE.getPointValue(), 0.01);
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
@Test
  public void testIsValidQueenMove() {
    //criando instancias de Piece
    Piece queen = new Queen(WHITE);

    //Testa movimento válido para a rainha branca
    assertTrue(queen.isValidMove(4,4,1,7));
    assertTrue(queen.isValidMove(4,4,4,7));
    assertTrue(queen.isValidMove(4,4,7,7));


    //Testa movimento válido para a rainha preta
    assertTrue(queen.isValidMove(4,4,1,1));
    assertTrue(queen.isValidMove(4,4,4,1));
    assertTrue(queen.isValidMove(4,4,7,1));

}
@Test
  public void testInvalidQueenMove() {
    Piece queen = Piece.createWhiteQueen();

    //Testa movimento inválido para a rainha branca
    assertFalse(queen.isValidMove(4,4,5,1));

    //Testa movimento inválido para a rainha preta
    Piece blackQueen = Piece.createBlackQueen();

    assertFalse(blackQueen.isValidMove(4,4,2,7));
  }
  @Test
  public void testValidKingMove() {
    Piece king = new King(WHITE);

    assertTrue(king.isValidMove(3,3,4,4));
    assertTrue(king.isValidMove(3,5,4,5));
    assertTrue(king.isValidMove(2,2,1,1));

    assertFalse(king.isValidMove(3,3,5,5));

  }

}