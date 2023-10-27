package pieces;

public class Piece {
    public static final String WHITE = "White";
    public static final String BLACK = "Black";

    public enum PieceType{
        PAWN,
        KNIGHT,
        BISHOP,
        ROOK,
        QUEEN,
        KING
    }

    private final String color;
    private final PieceType type;
    private static int whitePieceCount = 0;
    private static int blackPieceCount = 0;

    public Piece(String color, PieceType type) {
        this.color = color;
        this.type = type;

        if (WHITE.equals(color)) {
            whitePieceCount++;

        }else if(BLACK.equals(color)) {
            blackPieceCount++;
        }
    }
    public static Piece createPiece(String color, PieceType type) {
        return new Piece(color, type);
    }
    public String getColor() {
        return color;
    }
    public PieceType getType() {
        return type;
    }
    public static int getWhitePieceCount() {
        return whitePieceCount;
    }
    public static int getBlackPieceCount() {
        return blackPieceCount;
    }
    public boolean isBlack() {
        return BLACK.equals(color);
    }
    public boolean isWhite() {
        return WHITE.equals(color);
    }

}
