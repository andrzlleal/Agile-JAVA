package pieces;

public class Piece {
    
    private final Color color;
    private final PieceType type;
    private static int whitePieceCount = 0;
    private static int blackPieceCount = 0;

    public static Piece noPiece() {
        return new Piece(Color.NO_PIECE, PieceType.NO_PIECE);
    }
    public enum Color {
        WHITE, BLACK, NO_PIECE
    }
    static final char PAWN_REPRESENTATION = 'p';
    static final char KNIGHT_REPRESENTATION = 'n';
    static final char ROOK_REPRESENTATION = 'r';
    static final char QUEEN_REPRESENTATION = 'q';
    static final char BISHOP_REPRESENTATION = 'b';
    static final char KING_REPRESENTATION = 'k';

    public enum PieceType{
        PAWN,
        KNIGHT,
        BISHOP,
        ROOK,
        QUEEN,
        KING,
        NO_PIECE
    }
    public Piece(Color color, PieceType type) {
        this.color = color;
        this.type = type;

        if (Color.WHITE.equals(color)) {
            whitePieceCount++;

        }else if(Color.BLACK.equals(color)) {
            blackPieceCount++;
        }
    }
    public static Piece createPiece(Color color, PieceType type) {
        if(Color.WHITE.equals(color) || Color.BLACK.equals(color)){
            return new Piece(color, type);
        }
        return new Piece(Color.NO_PIECE, PieceType.NO_PIECE);
    }
    public Color getColor() {
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
        return Color.BLACK.equals(color);
    }
    public boolean isWhite() {
        return Color.WHITE.equals(color);
    }
    public char getRepresentation() {
        if (type == PieceType.NO_PIECE) {
            return '.';
        }
            char rep =  switch (type) {
                case PAWN -> 'p';
                case KNIGHT -> 'n';
                case BISHOP -> 'b';
                case ROOK -> 'r';
                case QUEEN -> 'q';
                case KING -> 'k';
                default -> '-';
            };
            if (isBlack()) {
                return Character.toUpperCase(rep);
            }
            return rep;
    }
    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, PieceType.PAWN);
    }
    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, PieceType.PAWN);
    }
    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, PieceType.ROOK);
    }
    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, PieceType.ROOK);
    }
    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, PieceType.KNIGHT);
    }
    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, PieceType.KNIGHT);
    }
    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, PieceType.QUEEN);
    }
    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, PieceType.QUEEN);
    }
    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, PieceType.KING);
    }
    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, PieceType.KING);
    }
    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, PieceType.BISHOP);
    }
    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, PieceType.BISHOP);
    }



}
