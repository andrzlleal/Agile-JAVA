package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Piece> pieces = new ArrayList<>();

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
            pieces.set(i, Piece.createPieceForIndex(i));
        }
    }

    public int getNumberOfPieces() {
        int count = 0;

        for (Piece piece : pieces) {
            if (piece.getType() != Piece.PieceType.NO_PIECE) {
                count++;
            }
        }
        return count;
    }

    public String getBoardRepresentation() {
        StringBuilder representation = new StringBuilder();

        for (int i = 0; i < 64; i++) {
            representation.append(pieces.get(i).getRepresentation());
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
            return Piece.noPiece();
        }
        char file = location.charAt(0);
        char rank = location.charAt(1);

        int fileIndex =
                Character.toUpperCase(file) - 'A';
        int rankIndex = rank - '1';

        if (fileIndex < 0 || fileIndex > 7 || rankIndex < 0 || rankIndex > 7) {
            return Piece.noPiece();
        }
        return pieces.get(fileIndex + 8 * rankIndex);
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
        return getPieceValue(piece);
    }
    private double getPieceValue(Piece piece) {
        if (piece.isWhite()) {
            return switch (piece.getType()) {
                case PAWN -> 1.0;
                case KNIGHT -> 2.5;
                case BISHOP -> 3.0;
                case ROOK -> 5.0;
                case QUEEN -> 9.0;
                default -> 0.0;
            };
        } else if (piece.isBlack()) {
            return switch (piece.getType()) {
                case PAWN -> -1.0;
                case KNIGHT -> -2.5;
                case BISHOP -> -3.0;
                case ROOK -> -5.0;
                case QUEEN -> -9.0;
                default -> 0.0;
            };
        } else {

            return 0.0;
        }


    }


}