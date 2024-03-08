package chess;

import pieces.NoPiece;
import pieces.Pawn;
import pieces.Piece;

import java.util.Arrays;
import java.util.Iterator;

import static pieces.Piece.isValidSquare;

public class Board implements Iterable<Piece>{
    private final Piece[][] pieces = new Piece[8][8];

    void initializeBoard(){
        int index = 0;
        for(int rank = 7; rank >= 0; rank--) {
            for(int file = 0; file < pieces[rank].length; file++) {
               pieces[rank][file] = Piece.createPieceForIndex(index++);
            }
        }
    }
    public Board() {
        initializeRanks();
    }

    public boolean isEmpty(int file, int rank) {
        return pieces[file][rank] instanceof NoPiece;
    }

    private void initializeRanks() {
        for(Piece[] column : pieces) {
            Arrays.fill(column, Piece.noPiece());
        }
    }
    @Override
    public Iterator<Piece> iterator() {
        return new BoardIterator(this);
    }

    public int getNumberOfPieces() {
        int count = 0;

        for (Piece[] rank : pieces) {
            for(Piece piece : rank ) {
                if (!(piece instanceof NoPiece)){
                    count++;
                }
            }
        }
        return count;
    }

    public String getBoardRepresentation() {
        StringBuilder representation = new StringBuilder();

            for (Piece[] rank : pieces) {
                for (Piece piece : rank) {
                    if (piece != null) {
                        representation.append(piece.getRepresentation());
                    } else {
                        representation.append('.');
                    }
            }
                representation.append("\n");
        }
        return representation.toString().trim();
    }

    public int countPieces(Piece.Color color, char pieceRepresentation) {
        int count = 0;
        for (Piece[] rank : pieces) {
            for(Piece piece : rank) {
                if (piece.getColor() == color && piece.getRepresentation() == pieceRepresentation) {
                    count++;
                }
            }
        }
        return count;
    }

    public int whitePieceCount() {
        int count = 0;
            for (Piece[] rank : pieces) {
                for(Piece piece : rank) {
                    if (piece.isWhite()) {
                        count++;
                    }
                }
            }
        return count;
    }

    public int blackPieceCount() {
        int count = 0;
        for (Piece[] rank : pieces) {
            for (Piece piece : rank) {
                if (piece.isBlack()) {
                    count++;
                }
            }
        }
        return count;
    }

    public Piece getPieceAt(int file, int rank) {
        if (isValidSquare(file, rank)) {
            return pieces[rank][file];
        } else {
            System.out.println("Invalid position: (" + file + " , " + rank + ") " );
            return Piece.noPiece();
        }
    }

    boolean isSameColor(Piece.Color color, char representation) {
        return (color == Piece.Color.WHITE && Character.isLowerCase(representation)) ||
                (color == Piece.Color.BLACK && Character.isUpperCase(representation));
    }

    public void placePieceAt(Piece piece, int file, int rank) {
        pieces[file][rank] = piece;
    }

    public boolean isValidPosition(String position) {
        return position.length() == 2 && isValidFile(position.charAt(0)) && isValidRank(position.charAt(1));
    }

    private boolean isValidFile(char file) { return file >= 'a' && file <= 'h';}

    private boolean isValidRank(char rank) { return rank >= '1' && rank <= '8'; }

    int positionToIndex(String position) {
        char file = position.charAt(0);
        char rank = position.charAt(1);

        int fileIndex = file - 'a';
        int rankIndex = rank - '1';

        return fileIndex + 8 * rankIndex;
    }

  public double getPieceValue(String position) {
        int fileIndex = getFileIndex(position);
        int rankIndex = getRankIndex(position);

        Piece piece = pieces[fileIndex] [rankIndex];
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

        for (Piece[] rank : pieces) {
            for (Piece otherPiece : rank) {
                if (isSameColumnPawn(piece, otherPiece, (char) column, position.charAt(0))) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isSameColumnPawn(Piece piece, Piece otherPiece, int column, char positionColumn) {
        int otherColumn = getFileIndex(getPositionForPiece(otherPiece.indexOf(pieces)));
            return piece instanceof Pawn && piece.getColor() == otherPiece.getColor() && otherColumn == column &&
                    getPositionForPiece(otherPiece.indexOf(pieces)).charAt(0) == positionColumn;
    }

    public void assignPieceValues() {
        for (Piece[] rank : pieces) {
            for (Piece currentPiece : rank) {
                currentPiece.setStrength(Piece.getPieceValue());
            }
        }
        addPointsForSameColumnPawns();
    }

    private String getPositionForPiece(int index) {
        char file = (char) ('a' + index % 8);
        char rank = (char) ('1' + index / 8);
        return String.valueOf(file) + rank;
    }

    private void addPointsForSameColumnPawns() {
        for (Piece[] column : pieces) {
            for (int i = 0; i < column.length - 1; i++) {
                Piece currentPiece = column[i];
                if (currentPiece instanceof Pawn) {
                    for (int j = i + 1; j < column.length; j++){
                        Piece otherPiece = column[j];
                        if (otherPiece instanceof Pawn && currentPiece.getColor() == otherPiece.getColor()) {
                            currentPiece.addPointsForSameColumnPawn();
                            otherPiece.addPointsForSameColumnPawn();
                        }
                    }
                }
            }
        }
    }

    public int getFileIndex(String position) {
        return Character.toUpperCase(position.charAt(0)) - 'A';
    }
    public int getRankIndex(String position) {
        return Character.getNumericValue(position.charAt(1)) - 1;
    }

    public Piece[][] getPieces() {
        Piece[][] copy = new Piece[8][8];
        for (int rank = 0; rank < 8; rank++) {
            System.arraycopy(pieces[rank], 0, copy[rank], 0, pieces[rank].length);
        }
        return copy;
    }

}