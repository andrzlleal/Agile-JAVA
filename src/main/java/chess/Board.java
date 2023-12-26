package chess;

import pieces.NoPiece;
import pieces.Pawn;
import pieces.Piece;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private final List<Piece> pieces = new LinkedList<>();

    public Board() {
        initializeRanks();
    }

    private void initializeRanks() {
        for (int i = 0; i < 64; i++) {
            pieces.add(Piece.noPiece());
        }
    }

    public void initializeBoard() {
        for (int i = 0; i < 64; i++) {
            Piece piece = Piece.createPieceForIndex(i);
            if (piece != null) {
                pieces.set(i, piece);
            }
        }
    }

    public int getNumberOfPieces() {
        int count = 0;

        for (Piece piece : pieces) {
            if (piece.getClass() != NoPiece.class) {
                count++;
            }
        }
        return count;
    }

    public String getBoardRepresentation() {
        StringBuilder representation = new StringBuilder();

        for (int i = 0; i < 64; i++) {
            Piece piece = pieces.get(i);
            representation.append(piece.getRepresentation());
            if ((i + 1) % 8 == 0) {
                representation.append("\n");
            }

        }
        return representation.toString().trim();
    }

    public int countPieces(Piece.Color color, char pieceRepresentation) {
        int count = 0;
        for (Piece piece : pieces) {
            if (piece.getColor() == color && piece.getRepresentation() == pieceRepresentation) {
                count++;
            }
        }
        return count;
    }

    public int whitePieceCount() {
        int count = 0;
        for (Piece piece : pieces) {
            if (piece.isWhite()) {
                count++;
            }
        }
        return count;
    }

    public int blackPieceCount() {
        int count = 0;
        for (Piece piece : pieces) {
            if (piece.isBlack()) {
                count++;
            }
        }
        return count;
    }

    public Piece getPieceAt(String location) {
        if (location.length() != 2) {
            System.out.println("Invalid location format " + location);
            return Piece.noPiece();
        }
        char file = location.charAt(0);
        char rank = location.charAt(1);

        int fileIndex = Character.toUpperCase(file) - 'A';
        int rankIndex = rank - '1';

        if (!isValidFile(file) || !isValidRank(rank)) {
            return Piece.noPiece();
        }

        int pieceIndex = fileIndex + 8 * rankIndex;

        if (pieceIndex < 0 || pieceIndex >= pieces.size()) {
            return Piece.noPiece();
        }

        Piece piece = pieces.get(pieceIndex);

        if (!isSameColor(piece.getColor(), piece.getRepresentation())) {
            return Piece.noPiece();
        }

        return piece;
    }

    private boolean isSameColor(Piece.Color color, char representation) {
        if (color == Piece.Color.WHITE && Character.isLowerCase(representation)) {
            return true;
        } else return color == Piece.Color.BLACK && Character.isUpperCase(representation);
    }

    public void placePieceAt(Piece piece, String position) {
        if (isValidPosition(position)) {
            int index = positionToIndex(position);
            pieces.set(index, piece);
        }
    }

    private boolean isValidPosition(String position) {
        return position.length() == 2 && isValidFile(position.charAt(0)) && isValidRank(position.charAt(1));
    }

    private boolean isValidFile(char file) {
        return file >= 'a' && file <= 'h';
    }

    private boolean isValidRank(char rank) {
        return rank >= '1' && rank <= '8';
    }

    private int positionToIndex(String position) {
        char file = position.charAt(0);
        char rank = position.charAt(1);

        int fileIndex = file - 'a';
        int rankIndex = rank - '1';

        return fileIndex + 8 * rankIndex;
    }

    public double getPieceValue(String position) {
        Piece piece = getPieceAt(position);
        return getPieceValue(piece, position);
    }

    private double getPieceValue(Piece piece, String position) {
        double baseValue = Piece.getPieceValue();

        if (!piece.isWhite()) {
            baseValue *= -1.0;
        }
        System.out.printf("Piece" + piece + "Base Value" + baseValue);

        if (piece instanceof Pawn) {

            int sameColumnPawnCount = countSameColumnPawns(piece, position);
            if(sameColumnPawnCount > 0 ) {
                double pawnValue = piece.isWhite() ? 0.5 : -0.5;
                baseValue += pawnValue;

                System.out.printf("Same Column Pawns " + sameColumnPawnCount + "Pawn Value" + pawnValue);
            }
        }
        return baseValue;
    }

    private int countSameColumnPawns(Piece piece, String position) {
        char column = position.charAt(0);
        int count = 0;

        for(Piece otherPiece : pieces) {
            if(isSameColumnPawn(piece, otherPiece, column, position.charAt(0) )) {
                count++;
            }
        }
        return count;
    }

    private boolean isSameColumnPawn(Piece piece, Piece otherPiece, char column, char positionColumn) {
        return piece instanceof Pawn &&
                otherPiece instanceof Pawn &&
                piece.getColor() == otherPiece.getColor() &&
                getPositionForPiece(otherPiece.indexOf(pieces)).charAt(0) == column &&
                getPositionForPiece(otherPiece.indexOf(pieces)).charAt(0) == positionColumn;
    }
    public void assignPieceValues() {
        List<Piece> copyOfPieces = new LinkedList<>(pieces);

        copyOfPieces.forEach(piece -> piece.setStrength(Piece.getPieceValue()));

        addPointsForSameColumnPawns();
        Collections.sort(pieces);

    }

    private String getPositionForPiece(int index) {
        char file = (char) ('a' + index % 8);
        char rank = (char) ('1' + index / 8);
        return String.valueOf(file) + rank;
    }

    private void addPointsForSameColumnPawns() {
        for (int i = 0; i < pieces.size(); i++) {
            Piece currentPiece = pieces.get(i);
            if (currentPiece instanceof Pawn) {
                for(int j = i + 1; j < pieces.size(); j++) {
                    Piece otherPiece = pieces.get(j);
                    if(otherPiece instanceof Pawn && currentPiece.getColor() == otherPiece.getColor()
                            && i % 8 == j % 8 ) {
                        currentPiece.addPointsForSameColumnPawn();
                        otherPiece.addPointsForSameColumnPawn();
                    }
                }
            }
        }
    }

    int getFileIndex(String position) {
        return Character.toUpperCase(position.charAt(0)) - 'A';
    }
    int getRankIndex(String position) {
        return Character.getNumericValue(position.charAt(1)) - 1;
    }

}