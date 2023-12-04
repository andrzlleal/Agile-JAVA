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
        PAWN('p', 1.0),
        KNIGHT('n', 2.5),
        BISHOP('b',3.0),
        ROOK('r', 5.0),
        QUEEN('q',9.0),
        KING('k', 0),
        NO_PIECE('-',0);

        private final char representation;
        private final double pointValue;

        PieceType(char representation, double pointValue) {
            this.representation = representation;
            this.pointValue = pointValue;
        }
        public char getRepresentation() {
            return representation;
        }

        public double getPointValue() {
            return pointValue;
        }
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
        return type.getRepresentation();
    }
//            char rep =  switch (type) {
//                case PAWN -> 'p';
//                case KNIGHT -> 'n';
//                case BISHOP -> 'b';
//                case ROOK -> 'r';
//                case QUEEN -> 'q';
//                case KING -> 'k';
//                default -> '-';
//            };
//        return isBlack() ? Character.toUpperCase(rep) : rep;
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

    public void addPointsForSameColumnPawn() {
        if(getType() == PieceType.PAWN) {
            setStrength(getStrength() + 0.5);
        }
    }

}
