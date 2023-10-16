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

    private int rank;
    private int file;

    /** Create a new pieces.Pawn object with the specified color. **/
   public Pawn(String color) {
       this.color = color;
       this.rank = rank;
       this.file = file;
   }
   public Pawn(String color, int i, int i1){
       this.color = color;
   }
   public String getColor(){
       return color;
   }
   public int getRank() {
       return rank;
   }
   public int getFile(){
       return file;
   }

    public char getPrintableRepresentation() {
        if (WHITE.equals(color)) {
            return 'P';
        }else {
            return 'p';
        }
    }

}
