package pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class Piece implements Comparable<Piece> {

    private final Color color;
    private static int whitePieceCount = 0;
    private static int blackPieceCount = 0;
    private double strength = 0;

    int file;
    int rank;

    public static double getPieceValue() {
        return 0;
    }

    public Piece(Color color, int file, int rank) {
        this.color = color;
        this.file = file;
        this.rank = rank;

        incrementPieceCount();
    }
    private void incrementPieceCount() {
     if (isWhite()) {
         whitePieceCount++;
     } else if (isBlack()) {
         blackPieceCount++;
     }
    }

    public int getFile() {
        return file;
    }
    public void setFile(int file) { this.file = file; }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
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

    public static boolean isValidSquare(int file, int rank) {
        return file >= 0 && file < 8 && rank >= 0 && rank < 8;
    }

    public static Piece noPiece() {
        return NoPiece.getInstance();
    }

    @Override
    public int compareTo(Piece otherPiece) {
        return Double.compare(this.strength, otherPiece.getStrength());
    }
    private static final Map<Class<? extends Piece>, Supplier<Piece>> pieceConstructors = Map.of(
            Pawn.class, Piece::createPawn

            // Adicionar outras classes de peças
    );
    public static Piece createPiece(Color color, Class<? extends Piece> pieceClass, int file, int rank) {
        return pieceConstructors.getOrDefault(pieceClass, Piece::noPiece).get();
    }

    private static Piece createPawn() {
        return new Pawn(Color.NO_PIECE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }

    private static NoPiece createNoPiece() {
        return NoPiece.getInstance();
    }

    public static Piece createPieceForIndex(int index) {
        int file = index % 8;
        int rank = index / 8;

        switch (rank) {
            case 0, 7 -> {return createPieceForTopAndBottomRank(file, rank); }
            case 1, 6 -> {return (rank ==1) ? createWhitePawn() : createBlackPawn(); }
            default -> {return NoPiece.getInstance(); }
        }
    }
    private static Piece createPieceForTopAndBottomRank(int file, int rank) {
        return switch (file) {
            case 0, 7 -> createRook(rank);
            case 1, 6 -> createKnight(rank);
            case 2, 5 -> createBishop(rank);
            case 3 -> createQueen(rank);
            case 4 -> createKing(rank);
            default -> createNoPiece();
        };
    }
    private static Piece createRook(int rank) {
        return (rank == 0) ? createWhiteRook() : createBlackRook();
    }

    private static Piece createKnight(int rank) {
        return (rank == 0) ? createWhiteKnight() : createBlackKnight();
    }

    private static Piece createBishop(int rank) {
        return (rank == 0) ? createWhiteBishop() : createBlackBishop();
    }

    private static Piece createQueen(int rank) {
        return (rank == 0) ? createWhiteQueen() : createBlackQueen();
    }

    private static Piece createKing(int rank) {
        return (rank == 0) ? createWhiteKing() : createBlackKing();
    }

    public void setStrength(double pieceValue) {
        this.strength = pieceValue;

    }
    public double getStrength() {
        return strength;
    }

    public int indexOf(Piece[][] pieces) {
        Objects.requireNonNull(pieces, "pieces cannot be null");

        for (int file = 0; file < pieces.length; file++) {
            for (int rank = 0; rank < pieces[file].length; rank++) {
                if (this.equals(pieces[file][rank])) {
                    return file * 8 + rank;
                }
            }
        }
        return -1;
    }

    public abstract boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces);

    public char getRepresentation() {
        return (this instanceof NoPiece) ? '.' : getPieceRepresentation();
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
        incrementPieceCount();
    }


    public static Piece createWhitePawn() {
      return new Pawn(Color.WHITE) {
          @Override
          public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return toFile == fromFile && toRank == fromRank +1;
          }
      };
    }
    public static Piece createBlackPawn() {
      return new Pawn(Color.BLACK) {
          @Override
          public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
             return toFile == fromFile && toRank == fromRank - 1;
             }
      };
    }
    public static Piece createWhiteRook() {
        return new Rook(Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createBlackRook() {
        return new Rook(Color.BLACK) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createWhiteKnight() {
        return new Knight(Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createBlackKnight() {
        return new Knight(Color.BLACK) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createWhiteQueen() {
        return new Queen(Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
                return false;
            }
        };
    }
    public static Piece createBlackQueen() {
        return new Queen(Color.BLACK) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
                return false;
            }
        };
    }
    public static Piece createWhiteKing() {
        return new King(Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createBlackKing() {
        return new King(Color.BLACK) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createWhiteBishop() {
        return new Bishop(Color.WHITE) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
                return false;
            }
        };
    }
    public static Piece createBlackBishop() {
        return new Bishop(Color.BLACK) {
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
                return false;
            }
        };
    }

}
