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
    whitePawn = new Pawn(WHITE, 'p');
    blackPawn = new Pawn(Pawn.BLACK, 'p');
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



//    public void testCreate(){
//        //create a white pawn using the constant and check its color.
//        Pawn whitePawn = new Pawn(Pawn.WHITE);
//        assertEquals(Pawn.WHITE, whitePawn.getColor());
//
//        /* create a black pawn using the constant and check its color. */
//        Pawn blackPawn = new Pawn(Pawn.BLACK);
//        assertEquals(Pawn.BLACK, blackPawn.getColor());
//    }
//    @Test
//    public void testCreatePawnWithDefaultColor() {
//    /* Create a pawn without specifying a color and check its color. */
//        Pawn = new Pawn("white", 1,2);
//        assertEquals("white", pawn.getColor());
//}
//    @Test
//    public void testPrintableRepresentationBlackPawn(){
//        Pawn blackPawn =  new Pawn(Pawn.BLACK);
//        assertEquals('p', blackPawn.getPrintableRepresentation());
//    }
//    @Test
//    public void testPrintableRepresentationWhitePawn() {
//        Pawn whitePawn = new Pawn(Pawn.WHITE);
//        assertEquals('P', whitePawn.getPrintableRepresentation());
//    }

}