package pieces;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static pieces.Pawn.WHITE;

public class PawnTest {
  private Pawn pawn;
  private Pawn whitePawn;
  private Pawn blackPawn;
  @Before
  public void setUp() {
    pawn = new Pawn();
    whitePawn = new Pawn(WHITE);
    blackPawn = new Pawn(Pawn.BLACK);
  }
  @Test
    public void testCreate() {
      assertEquals(WHITE, whitePawn.getColor());
      assertEquals(Pawn.BLACK, blackPawn.getColor());
  }
  @Test
    public void testPawnWithoutColor(){
      assertEquals(WHITE, pawn.getColor());
  }
  @Test
  public void testPrintableRepresentationWhitePawn() {
    char printableRepresentation = whitePawn.getPrintableRepresentation();
    assertEquals('p', printableRepresentation);
    System.out.println("peao branco: " + whitePawn.getPrintableRepresentation());
  }
  @Test
    public void testPrintableRepresentationBlackPawn() {
      char printableRepresentation = blackPawn.getPrintableRepresentation();
      assertEquals('P', printableRepresentation);
      System.out.println("peao preto: " + blackPawn.getPrintableRepresentation());
 }
}