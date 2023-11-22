package pieces;

import java.util.Objects;
import java.util.List;

public class Piece implements Comparable<Piece>{

    private final Color color;
    private final PieceType type;
    private static int whitePieceCount = 0;
    private static int blackPieceCount = 0;
    private double strength = 0;


    public static Piece noPiece() {
        return new Piece(Color.NO_PIECE, PieceType.NO_PIECE);
    }

    @Override
    public int compareTo(Piece otherPiece) {
        return Double.compare(strength, strength);
    }

    public static Piece createPieceForIndex(int index) {
        int rank = index / 8;
        int file = index % 8;

        if(rank == 0 || rank == 7) {
            switch (file) {
                case 0, 7 -> {return (rank == 0) ? Piece.createWhiteRook() : Piece.createBlackRook(); }
                case 1, 6 -> {return (rank == 0) ? Piece.createWhiteKnight() : Piece.createBlackKnight(); }
                case 2, 5 -> {return (rank == 0) ? Piece.createWhiteBishop() : Piece.createBlackBishop(); }
                case 3 -> {return (rank == 0) ? Piece.createWhiteQueen() : Piece.createBlackQueen(); }
                case 4 -> {return (rank == 0) ? Piece.createWhiteKing() : Piece.createBlackKing(); }
                default -> {return Piece.noPiece(); }
            }
        } else if (rank == 1 || rank == 6) {
            return (rank == 1) ? Piece.createWhitePawn() : Piece.createBlackPawn();
        } else {
            return Piece.noPiece();
        }
    }

    public void setStrength(double pieceValue) {
        this.strength = pieceValue;

    }
    public double getStrength() {
        return strength;
    }

    public int indexOf(List<Piece> pieces) {
        Objects.requireNonNull(pieces, "pieces cannot be null");
        for(int i = 0; i < pieces.size(); i++) {
            if(this.equals(pieces.get(i))){
                return i;
            }
        }
        return -1;
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
        NO_PIECE,
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
        return (Color.WHITE.equals(color) || Color.BLACK.equals(color)) ?
                new Piece(color, type) : Piece.noPiece();
        }

    public Color getColor() {
        return color;
    }
    public PieceType getType() {
        return type;
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
            return isBlack() ? Character.toUpperCase(rep) : rep;
    }
    public static Piece createWhitePawn() {
        Piece pawn = new Piece(Color.WHITE, PieceType.PAWN);
        pawn.setStrength(1.0);
        return pawn;
    }
    public static Piece createBlackPawn() {
        Piece pawn = new Piece(Color.BLACK, PieceType.PAWN);
        pawn.setStrength(-1.0);
        return pawn;
    }
    public static Piece createWhiteRook() {
        Piece rook = new Piece(Color.WHITE, PieceType.ROOK);
        rook.setStrength(5.0);
        return rook;
    }
    public static Piece createBlackRook() {
        Piece rook = new Piece(Color.BLACK, PieceType.ROOK);
        rook.setStrength(-5.0);
        return rook;
    }
    public static Piece createWhiteKnight() {
        Piece knight = new Piece(Color.WHITE, PieceType.KNIGHT);
        knight.setStrength(2.5);
        return knight;
    }
    public static Piece createBlackKnight() {
        Piece knight = new Piece(Color.BLACK, PieceType.KNIGHT);
        knight.setStrength(-2.5);
        return knight;
    }
    public static Piece createWhiteQueen() {
        Piece queen = new Piece(Color.WHITE, PieceType.QUEEN);
        queen.setStrength(9.0);
        return queen;
    }
    public static Piece createBlackQueen() {
        Piece queen = new Piece(Color.BLACK, PieceType.QUEEN);
        queen.setStrength(-9.0);
        return queen;
    }
    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, PieceType.KING);
    }
    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, PieceType.KING);
    }
    public static Piece createWhiteBishop() {
        Piece bishop = new Piece(Color.WHITE, PieceType.BISHOP);
        bishop.setStrength(3.0);
        return bishop;
    }
    public static Piece createBlackBishop() {
        Piece bishop = new Piece(Color.BLACK, PieceType.BISHOP);
        bishop.setStrength(-3.0);
        return bishop;
    }
    public void addPointsForSameColumnPawn() {
        if(getType() == PieceType.PAWN) {
            setStrength(getStrength() + 0.5);
        }
    }

}
