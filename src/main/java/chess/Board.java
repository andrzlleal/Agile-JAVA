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

//    public void initializeBoard() {
//        initializeRow(Piece.Color.WHITE, 0);
//        initializeRow(Piece.Color.BLACK, 7);
//    }
//
//    private void initializeRow(Piece.Color color, int row) {
//        pieces.set(row, Piece.createPiece(color, Piece.PieceType.ROOK));
//        pieces.set(row + 1, Piece.createPiece(color, Piece.PieceType.KNIGHT));
//        pieces.set(row + 2, Piece.createPiece(color, Piece.PieceType.BISHOP));
//        pieces.set(row + 3, Piece.createPiece(color, Piece.PieceType.QUEEN));
//        pieces.set(row + 4, Piece.createPiece(color, Piece.PieceType.KING));
//        pieces.set(row + 5, Piece.createPiece(color, Piece.PieceType.BISHOP));
//        pieces.set(row + 6, Piece.createPiece(color, Piece.PieceType.KNIGHT));
//        pieces.set(row + 7, Piece.createPiece(color, Piece.PieceType.ROOK));
//
//        int pawnRow = (color == Piece.Color.WHITE) ? row + 1 : row - 1;
//        for (int i = 0; i < 8; i++) {
//            pieces.set(pawnRow * 8 + i, Piece.createPiece(color, Piece.PieceType.PAWN));
//        }
//    }
    public void initializeBoard() {
        for (int i = 0; i < 16; i++) {
            if (i == 0 || i == 7) {
                pieces.set(i, Piece.createWhiteRook());
            } else if (i == 1 || i == 6) {
                pieces.set(i, Piece.createWhiteKnight());
            } else if (i == 2 || i == 5) {
                pieces.set(i, Piece.createWhiteBishop());
            } else if (i == 3) {
                pieces.set(i, Piece.createWhiteQueen());
            } else if (i == 4) {
                pieces.set(i, Piece.createWhiteKing());
            } else {
                pieces.set(i, Piece.createWhitePawn());
            }
        }
        for (int i = 48; i < 64; i++) {
            if (i == 56 || i == 63) {
                pieces.set(i, Piece.createBlackRook());
            } else if (i == 57 || i == 62) {
                pieces.set(i, Piece.createBlackKnight());
            } else if (i == 58 || i == 61) {
                pieces.set(i, Piece.createBlackBishop());
            } else if (i == 59) {
                pieces.set(i, Piece.createBlackQueen());
            } else if (i == 60) {
                pieces.set(i, Piece.createBlackKing());
            } else {
                pieces.set(i, Piece.createBlackPawn());
            }
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
                if((i+1) % 8 == 0) {
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
        System.out.println(rankIndex);

        if (fileIndex < 0 || fileIndex > 7 || rankIndex < 0 || rankIndex > 7) {
            return Piece.noPiece();
        }
        return pieces.get(fileIndex + 8 * rankIndex);
    }

    public Piece createPieceForIndex(int index) {
        int rank = index / 8;
        int file = index % 8;

        if((rank == 0 || rank == 7) && (file == 0 || file == 7)) {
            return (rank == 0) ?
                    Piece.createWhiteRook():
                    Piece.createBlackRook();

        } else if ((rank == 0 || rank ==7) && (file == 1 || file == 6)) {
            return (rank == 0) ?
                    Piece.createWhiteKnight():
                    Piece.createBlackKnight();

        }else if ((rank == 0 || rank == 7) && (file == 2 || file == 5)) {
            return (rank == 0) ?
                    Piece.createWhiteBishop():
                    Piece.createBlackBishop();


        } else if ((rank == 0 || rank == 7) && (file == 3)) {
            return (rank == 0) ?
                    Piece.createWhiteQueen():
                    Piece.createBlackQueen();

        } else if ((rank == 0 || rank == 7) && (file == 4)) {
            return (rank == 0) ?
                    Piece.createWhiteKing():
                    Piece.createBlackKing();

        } else if (rank == 1 || rank == 6) {
            return (rank == 1) ?
                    Piece.createWhitePawn():
                    Piece.createBlackPawn();

        } else {
            return Piece.noPiece();
        }
    }
}


    
    
    






