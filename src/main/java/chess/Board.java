package chess;

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
            pieces.set(i, piece);
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

        int fileIndex = Character.toUpperCase(file) - 'A';
        int rankIndex = rank - '1';

        if(!isValidFile(file) || !isValidRank(rank)) {
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
        return getPieceValue(piece, position);
    }

    private double getPieceValue(Piece piece, String position) {
        double baseValue = switch (piece.getType()) {
            case PAWN -> piece.isWhite() ? 1.0 : -1.0;
            case KNIGHT -> piece.isWhite() ? 2.5 : -2.5;
            case BISHOP -> piece.isWhite() ? 3.0 : -3.0;
            case ROOK -> piece.isWhite() ? 5.0 : -5.0;
            case QUEEN -> piece.isWhite() ? 9.0 : -9.0;
            default -> 0.0;
        };
        if (piece.getType() == Piece.PieceType.PAWN) {

            int whitePawnCount = countPieces(Piece.Color.WHITE, 'p');
            int sameColumnPawnCount = countSameColumnPawns(position, piece.getColor());

            if (whitePawnCount > 1) {
                baseValue += piece.isWhite() ? 0.5 : -0.5;

            if(sameColumnPawnCount > 0 ) {
                baseValue += piece.isWhite() ? 0.5 : -0.5;
            }
            }else {
                int blackPawnCount = countPieces(Piece.Color.BLACK, 'p');

                if (blackPawnCount > 0) {
                    baseValue += piece.isWhite() ? 1.0 : -1.0;
                }
            }
        }
        return baseValue;
    }

    private int countSameColumnPawns(String position, Piece.Color color) {
        char column = position.charAt(0);
        int count = 0;

        for(Piece piece : pieces) {
            if(isSameColumnPawn(piece, color, column, position.charAt(0) )) {
                count++;
            }
        }
        return count;
    }
    private boolean isSameColumnPawn(Piece piece, Piece.Color color, char column, char positionColumn) {
        return piece.getType() == Piece.PieceType.PAWN && piece.getColor() == color && getPositionForPiece(piece.indexOf(Collections.singletonList(piece))).charAt(0) == column &&
                getPositionForPiece(piece.indexOf(Collections.singletonList(piece))).charAt(0) == positionColumn;
    }

    public void assignPieceValues() {
        List<Piece> copyOfPieces = new LinkedList<>(pieces);

        copyOfPieces.forEach(piece -> piece.setStrength(getPieceValue(piece, getPositionForPiece(piece.getRepresentation()))));

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
            if (currentPiece.getType() == Piece.PieceType.PAWN) {
                for (int j = i + 1; j < pieces.size(); j++) {
                    Piece otherPiece = pieces.get(j);
                    if (otherPiece.getType() == Piece.PieceType.PAWN && currentPiece.getColor() == otherPiece.getColor()) {
                        int currentFile = i % 8;
                        int otherFile = j % 8;
                        if (currentFile == otherFile) {
                            currentPiece.addPointsForSameColumnPawn();
                            otherPiece.addPointsForSameColumnPawn();
                        }
                    }
                }
            }
        }
    }


}

