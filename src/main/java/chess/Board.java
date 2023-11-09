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
        pieces.set(0, Piece.createWhiteRook());
        pieces.set(1, Piece.createWhiteKnight());
        pieces.set(2, Piece.createWhiteBishop());
        pieces.set(3, Piece.createWhiteQueen());
        pieces.set(4, Piece.createWhiteKing());
        pieces.set(5, Piece.createWhiteBishop());
        pieces.set(6, Piece.createWhiteKnight());
        pieces.set(7, Piece.createWhiteRook());

        pieces.set(8, Piece.createWhitePawn());
        pieces.set(9, Piece.createWhitePawn());
        pieces.set(10, Piece.createWhitePawn());
        pieces.set(11, Piece.createWhitePawn());
        pieces.set(12, Piece.createWhitePawn());
        pieces.set(13, Piece.createWhitePawn());
        pieces.set(14, Piece.createWhitePawn());
        pieces.set(15, Piece.createWhitePawn());

        pieces.set(56, Piece.createBlackRook());
        pieces.set(57, Piece.createBlackKnight());
        pieces.set(58, Piece.createBlackBishop());
        pieces.set(59, Piece.createBlackQueen());
        pieces.set(60, Piece.createBlackKing());
        pieces.set(61, Piece.createBlackBishop());
        pieces.set(62, Piece.createBlackKnight());
        pieces.set(63, Piece.createBlackRook());

        pieces.set(55, Piece.createBlackPawn());
        pieces.set(54, Piece.createBlackPawn());
        pieces.set(53, Piece.createBlackPawn());
        pieces.set(52, Piece.createBlackPawn());
        pieces.set(51, Piece.createBlackPawn());
        pieces.set(50, Piece.createBlackPawn());
        pieces.set(49, Piece.createBlackPawn());
        pieces.set(48, Piece.createBlackPawn());

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

}
    
    
    






