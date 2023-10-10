package pieces;

/**
 * A class representing a pawn in a chess game.
 * This class represents a pawn with a color, witch can be "white" or "black."
 * **/
public class Pawn {

    /** The color of the pawn **/
    private final String color;
    public static final String WHITE = "White";
    public static final String BLACK = "Black";

    /** Create a new pieces.Pawn object with the specified color. **/
   public Pawn(String color) {
       this.color = color;
   }
   public Pawn(){
       this.color = "white";
   }
   public String getColor(){
       return color;
   }
}
