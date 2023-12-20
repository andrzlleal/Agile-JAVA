package pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Piece implements Comparable<Piece> {

    private final Color color;
    private final PieceType type;
    private static int whitePieceCount = 0;
    private static int blackPieceCount = 0;
    private double strength = 0;


    public List<String> getPossibleMoves(String currentPosition) {
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
        return new Piece(PieceType.NO_PIECE) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
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

    public enum PieceType{
        PAWN('p', 1.0),
        KNIGHT('n', 2.5),
        BISHOP('b',3.0),
        ROOK('r', 5.0),
        QUEEN('q',9.0),
        KING('k', 0),
        NO_PIECE('.',0);


        private final char representation;
        private final double pointValue;

        PieceType(char representation, double pointValue) {
            this.representation = representation;
            this.pointValue = pointValue;
        }

        public double getPointValue() {
            return pointValue;
        }

        public char getRepresentation() {
            return representation;
        }
    }

    public Piece(PieceType type) {
        this.color = color;
        this.type = type;

        if (Color.WHITE.equals(color)) {
            whitePieceCount++;

        }else if(Color.BLACK.equals(color)) {
            blackPieceCount++;
        }
    }
    public static Piece createPiece(Color color, PieceType type) {
        return switch (type) {
            case PAWN -> new Pawn(color);
            case KING -> new King(color);
            case BISHOP -> new Bishop(color);
            case KNIGHT -> new Knight(color);
            case QUEEN -> new Queen(color);
            case ROOK -> new Rook(color);
            case NO_PIECE -> new NoPiece();
        };
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
        char rep;
        rep = type.getRepresentation();

        if(isBlack()) {
            rep = Character.toUpperCase(rep);
        }

        return rep;
    }
    public static Piece createWhitePawn() {
        return new Piece(PieceType.PAWN) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }
            //implementação dos movimentos do peao branco
            //List<String> possibleMoves = new ArrayList<>();
            //add movimentos válidos
            //return possibleMoves;
            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
            //implementação da lógica de movimento válido para o peão branco
            //return false;
        };
    }
    public static Piece createBlackPawn() {
        return new Piece(PieceType.PAWN) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createWhiteRook() {
        return new Piece(PieceType.ROOK) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createBlackRook() {
        return new Piece(PieceType.ROOK) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createWhiteKnight() {
        return new Piece(PieceType.KNIGHT) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createBlackKnight() {
        return new Piece(PieceType.KNIGHT) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createWhiteQueen() {
        return new Piece(PieceType.QUEEN) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createBlackQueen() {
        return new Piece(PieceType.QUEEN) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createWhiteKing() {
        return new Piece(PieceType.KING) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createBlackKing() {
        return new Piece(PieceType.KING) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createWhiteBishop() {
        return new Piece(PieceType.BISHOP) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }
    public static Piece createBlackBishop() {
        return new Piece(PieceType.BISHOP) {
            @Override
            public List<String> getPossibleMoves(String currentPosition) {
                return null;
            }

            @Override
            public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return false;
            }
        };
    }

    public void addPointsForSameColumnPawn() {
        if(getType() == PieceType.PAWN) {
            setStrength(getStrength() + 0.5);
        }
    }

}
