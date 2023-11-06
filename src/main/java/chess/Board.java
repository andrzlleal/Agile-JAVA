package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private final List<Piece> pieces = new ArrayList<>();
    private final List<String> ranks = new ArrayList<>();

    public Board() {
        initializeRanks();
    }
    private void initializeRanks() {
        ranks.add("rnbqkbnr");
        ranks.add("pppppppp");
        ranks.add("........");
        ranks.add("........");
        ranks.add("........");
        ranks.add("........");
        ranks.add("PPPPPPPP");
        ranks.add("RNBQKBNR");
        //System.out.println("Representation\n" + ranks);
    }
    public void initializeBoard() {
        for (String rank : ranks) {
            for (char symbol : rank.toCharArray()) {
                if (symbol == 'p') {
                    pieces.add(Piece.createPiece(Piece.Color.WHITE, Piece.PieceType.PAWN));
                } else if (symbol == 'r') {
                    pieces.add(Piece.createPiece(Piece.Color.WHITE, Piece.PieceType.ROOK));
                } else if (symbol == 'n') {
                    pieces.add(Piece.createPiece(Piece.Color.WHITE, Piece.PieceType.KNIGHT));
                } else if (symbol == 'b') {
                    pieces.add(Piece.createPiece(Piece.Color.WHITE, Piece.PieceType.BISHOP));
                } else if (symbol == 'q') {
                    pieces.add(Piece.createPiece(Piece.Color.WHITE, Piece.PieceType.QUEEN));
                } else if (symbol == 'k') {
                    pieces.add(Piece.createPiece(Piece.Color.WHITE, Piece.PieceType.KING));
                } else if (symbol == 'P') {
                    pieces.add(Piece.createPiece(Piece.Color.BLACK, Piece.PieceType.PAWN));
                } else if (symbol == 'R') {
                    pieces.add(Piece.createPiece(Piece.Color.BLACK, Piece.PieceType.ROOK));
                } else if (symbol == 'N') {
                    pieces.add(Piece.createPiece(Piece.Color.BLACK, Piece.PieceType.KNIGHT));
                } else if (symbol == 'B') {
                    pieces.add(Piece.createPiece(Piece.Color.BLACK, Piece.PieceType.BISHOP));
                } else if (symbol == 'Q') {
                    pieces.add(Piece.createPiece(Piece.Color.BLACK, Piece.PieceType.QUEEN));
                } else if (symbol == 'K') {
                    pieces.add(Piece.createPiece(Piece.Color.BLACK, Piece.PieceType.KING));
                }
            }
        }
    }
        public int getNumberOfPawns () {
            return pieces.size();
        }
        public List<String> getRanks () {
            return ranks;
        }
        public String getBoardRepresentation () {
            StringBuilder representation = new StringBuilder();

            for (String rank : ranks) {
                representation.append(rank).append("\n");
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
}







