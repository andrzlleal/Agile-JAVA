package pieces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the pieces.Pawn class
 * This class contains test methods to verify the functionality of the pieces.Pawn class.
 * including creating pawns with specified and default colors
 * */
public class PawnTest {

    /**
     * Test creating pawns with specified colors
     * */
    @Test
    public void testCreate(){
        //create a white pawn using the constant and check its color.
        Pawn whitePawn = new Pawn(Pawn.WHITE);
        assertEquals(Pawn.WHITE, whitePawn.getColor());

        /* create a black pawn using the constant and check its color. */
        Pawn blackPawn = new Pawn(Pawn.BLACK);
        assertEquals(Pawn.BLACK, blackPawn.getColor());
    }
    /**
     * Test creating a pawn with the default color.
     * */

    @Test
    public void testCreatePawnWithDefaultColor() {
    /* Create a pawn without specifying a color and check its color. */
        Pawn pawn = new Pawn("white", 1,2);
        assertEquals("white", pawn.getColor());
}
    @Test
    public void testPrintableRepresentationBlackPawn(){
        Pawn blackPawn =  new Pawn(Pawn.BLACK);
        assertEquals('p', blackPawn.getPrintableRepresentation());
    }
    @Test
    public void testPrintableRepresentationWhitePawn() {
        Pawn whitePawn = new Pawn(Pawn.WHITE);
        assertEquals('P', whitePawn.getPrintableRepresentation());
    }

}