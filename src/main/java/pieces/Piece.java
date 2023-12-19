package pieces;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import static pieces.Piece.King.fileToLetter;
import static pieces.Piece.King.isValidSquare;

public abstract class Piece implements Comparable<Piece>{

    private final Color color;
    private final PieceType type;
    private static int whitePieceCount = 0;
    private static int blackPieceCount = 0;
    private double strength = 0;


    public List<String> getPossibleMoves(String currentPosition){
        List<String> possibleMoves = new ArrayList<>();
        int currentFile = currentPosition.charAt(0) - 'a';
        int currentRank = 8 - Integer.parseInt(currentPosition.substring(1));

        for (int file = currentFile - 1; file <= currentFile + 1; file++) {
            for(int rank = currentRank - 1; rank <= currentRank + 1; rank++) {
                if (isValidSquare(file, rank)) {
                    possibleMoves.add(String.valueOf(fileToLetter(file) + (8 - rank)));
                }
            }
        }
        return possibleMoves;
    }


    public abstract boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank);

    public static class King extends Piece {
        public King(Color color) {
            super(color, PieceType.KING);
        }
    public static class Queen extends Piece{
            public Queen(Color color) {
                super(color, PieceType.QUEEN);
            }

        @Override
        public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                return Math.abs(toFile - fromFile) <= 1 && Math.abs(toRank - fromRank) <= 1;
        }
    }

        static String fileToLetter(int file) {
            return String.valueOf((char) ('a' + file));
        }

        static boolean isValidSquare(int file, int rank) {
            return file >= 0 && file < 8 && rank >= 0 && rank < 8;
        }

        @Override
        public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
            return fromFile == toFile || fromRank == toRank || Math.abs(toFile - fromFile) == Math.abs(toRank - fromRank);
        }
        private void addDiagonalMoves(List<String> possibleMoves, int currentFile, int currentRank) {
            for (int file = 0; file < 8; file++) {
                for (int rank = 0; rank < 8; rank++) {
                    if (Math.abs(file - currentFile) == Math.abs(rank - currentRank) && isValidSquare(file, rank)) {
                        possibleMoves.add(String.valueOf(fileToLetter(file) + (8 - rank)));
                    }
                }
            }
        }

        private void addHorizontalAndVerticalMoves(List<String> possibleMoves, int currentFile, int currentRank) {
            for (int file = 0; file < 8; file++) {
                if (isValidSquare(file, currentRank)) {
                    possibleMoves.add(String.valueOf(fileToLetter(file) + (8 - currentRank)));
                }
            }
            for (int rank = 0; rank < 8; rank++) {
                if (isValidSquare(currentFile, rank)) {
                    possibleMoves.add(String.valueOf(fileToLetter(currentFile) + (8 - rank)));
                }
            }
        }
    }
    public static Piece noPiece() {
        return new Piece(Color.NO_PIECE, PieceType.NO_PIECE) {
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

    public Piece(Color color, PieceType type) {
        this.color = color;
        this.type = type;

        if (Color.WHITE.equals(color)) {
            whitePieceCount++;

        }else if(Color.BLACK.equals(color)) {
            blackPieceCount++;
        }
    }
    public static Piece createPiece(Color color, PieceType pawn) {
        return (Color.WHITE.equals(color) || Color.BLACK.equals(color)) ?
                new Piece(color, PieceType.PAWN) {
                @Override
                    public List<String> getPossibleMoves(String currentPosition) {
                    return null;
                }
                @Override
                    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
                    return false;
                }
                @Override
                    public PieceType getType() {
                    return pawn;
                }
                 } : Piece.noPiece();
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
        return new Piece(Color.WHITE, PieceType.PAWN) {
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
    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, PieceType.PAWN) {
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
        return new Piece(Color.WHITE, PieceType.ROOK) {
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
        return new Piece(Color.BLACK, PieceType.ROOK) {
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
        return new Piece(Color.WHITE, PieceType.KNIGHT) {
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
        return new Piece(Color.BLACK, PieceType.KNIGHT) {
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
        return new Piece(Color.WHITE, PieceType.QUEEN) {
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
        return new Piece(Color.BLACK, PieceType.QUEEN) {
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
        return new Piece(Color.WHITE, PieceType.KING) {
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
        return new Piece(Color.BLACK, PieceType.KING) {
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
        return new Piece(Color.WHITE, PieceType.BISHOP) {
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
        return new Piece(Color.BLACK, PieceType.BISHOP) {
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
    public boolean isValidQueenMove(int fromFile, int fromRank, int toFile, int toRank) {
        int fileDifference = Math.abs(toFile - fromFile);
        int rankDifference = Math.abs(toRank - fromRank);

        Boolean isDiagonal = fileDifference == rankDifference;
        Boolean isVertical = fromFile == toFile;
        Boolean isHorizontal = fromRank == toRank;

        boolean isBlackQueen = this.isBlack();
        boolean isWhiteQueen = this.isWhite();

        return (isDiagonal || isVertical || isHorizontal) && (isBlackQueen || isWhiteQueen);
    }

}
