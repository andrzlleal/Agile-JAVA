package pieces;

public class Pawn {
    private final String color;
    public static final String WHITE = "White";
    public static final String BLACK = "Black";

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Pawn() {
        this.color = WHITE;
    }

    public char getPrintableRepresentation() {
        if (WHITE.equals(color)) {
            return 'p';
        } else {
            return 'P';
        }
    }
}
