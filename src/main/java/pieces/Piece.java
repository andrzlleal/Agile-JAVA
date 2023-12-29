package pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class Piece implements Comparable<Piece> {

    private final Color color;
    private static int whitePieceCount = 0;
    private static int blackPieceCount = 0;
    private double strength = 0;

    public static double getPieceValue() {
        return 0;
    }


    public List<String> getPossibleMoves(String currentPosition) {
        if (this instanceof NoPiece) {
            return null;
        }

        List<String> possibleMoves = new ArrayList<>();
        int currentFile = currentPosition.charAt(0) - 'a';
        int currentRank = 8 - Integer.parseInt(currentPosition.substring(1));

        for (int file = currentFile - 1; file <= currentFile + 1; file++) {
            for (int rank = currentRank - 1; rank <= currentRank + 1; rank++) {
                if (isValidSquare(file, rank)) {
                    possibleMoves.add(fileToLetter(file) + (8 - rank));
                }
            }
        }
        return possibleMoves;
    }

    public abstract boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank);

    static String fileToLetter(int file) {
        return String.valueOf((char) ('a' + file));
    }

    static boolean isValidSquare(int file, int rank) {
        return file >= 0 && file < 8 && rank >= 0 && rank < 8;
    }

    public static Piece noPiece() {
        return new NoPiece();
    }

    @Override
    public int compareTo(Piece otherPiece) {
        return Double.compare(this.strength, otherPiece.strength);
    }

    public static Piece createPiece(Color color, Class<? extends Piece> pieceClass) {
        try {
            return pieceClass.getDeclaredConstructor(Color.class).newInstance(color);
        } catch (Exception e) {
            e.printStackTrace(); // handle or log the exception as needed
            return noPiece(); //default to no piece in case of instantiation failure
        }
    }

    public static Piece createPieceForIndex(int index) {
        int rank = index / 8;
        int file = index % 8;

        if (rank == 0 || rank == 7) {
            switch (file) {
                case 0, 7 -> {
                    return (rank == 0) ? Piece.createWhiteRook() : Piece.createBlackRook();
                }
                case 1, 6 -> {
                    return (rank == 0) ? Piece.createWhiteKnight() : Piece.createBlackKnight();
                }
                case 2, 5 -> {
                    return (rank == 0) ? Piece.createWhiteBishop() : Piece.createBlackBishop();
                }
                case 3 -> {
                    return (rank == 0) ? Piece.createWhiteQueen() : Piece.createBlackQueen();
                }
                case 4 -> {
                    return (rank == 0) ? Piece.createWhiteKing() : Piece.createBlackKing();
                }
                default -> {
                    return Piece.noPiece();
                }
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
        for (int i = 0; i < pieces.size(); i++) {
            if (this.equals(pieces.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public char getRepresentation() {
        if (this instanceof NoPiece) {
            return '.';
        } else if (isWhite()) {
            return Character.toLowerCase(getPieceRepresentation());
        } else {
            return Character.toUpperCase(getPieceRepresentation());
        }
    }

    private static final Map<Class<? extends Piece>, Character> pieceRepresentationMap = Map.of(
            Pawn.class, 'P',
            Rook.class, 'R',
            Knight.class, 'N',
            Bishop.class, 'B',
            Queen.class, 'Q',
            King.class, 'K'
    );
    public char getPieceRepresentation() {
        return pieceRepresentationMap.getOrDefault(getClass(), '.');
    }

    public abstract void addPointsForSameColumnPawn();

    protected void move() {
    }

    public enum Color {
        WHITE, BLACK, NO_PIECE
    }

    public Color getColor() {
        return color;
    }
    public boolean isBlack() {
        return Color.BLACK.equals(color);
    }
    public boolean isWhite() {
        return Color.WHITE.equals(color);
    }

    public Piece(Color color) {
        this.color = color;

        if (Color.WHITE.equals(color)) {
            whitePieceCount++;

        }else if(Color.BLACK.equals(color)) {
            blackPieceCount++;
        }
    }

    public static Piece createWhitePawn() {
        return new Pawn (Color.WHITE);
    }
    public static Piece createBlackPawn() {
        return new Pawn(Color.BLACK);
    }
    public static Piece createWhiteRook() {
        return new Rook(Color.WHITE);
    }
    public static Piece createBlackRook() {
        return new Rook(Color.BLACK);
    }
    public static Piece createWhiteKnight() {
        return new Knight(Color.WHITE);
    }
    public static Piece createBlackKnight() {
        return new Knight(Color.BLACK);
    }
    public static Piece createWhiteQueen() {
        return new Queen(Color.WHITE);
    }
    public static Piece createBlackQueen() {
        return new Queen(Color.BLACK);
    }
    public static Piece createWhiteKing() {
        return new King(Color.WHITE);
    }
    public static Piece createBlackKing() {
        return new King(Color.BLACK);
    }
    public static Piece createWhiteBishop() {
        return new Bishop(Color.WHITE);
    }
    public static Piece createBlackBishop() {
        return new Bishop(Color.BLACK);
    }

}
