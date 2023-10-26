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
        ranks.add("PPPPPPPP");
        ranks.add("........");
        ranks.add("........");
        ranks.add("........");
        ranks.add("........");
        ranks.add("pppppppp");
        ranks.add("RNBQKBNR");

//        System.out.println("Representation\n" + ranks);
    }
    public void initializeBoard() {
        for (String rank : ranks) {
            for (char symbol : rank.toCharArray()) {
                if (symbol == 'p') {
                    pieces.add(Piece.createPiece(Piece.WHITE, Piece.PieceType.valueOf("PAWN")));
                } else if (symbol == 'P') {
                    pieces.add(Piece.createPiece(Piece.BLACK, Piece.PieceType.valueOf("PAWN")));
                } ///adicionar as peças que coloquei a mais
            }
        }
    }
         public int getNumberOfPawns() {
            return pieces.size();
    }
        public List<String> getRanks() {
            return ranks;
    }

    public String getBoardRepresentation() {
        StringBuilder representation = new StringBuilder();

        for(String rank : ranks) {
            representation.append(rank).append("\n");
        }
        representation.deleteCharAt(representation.length() - 1);
        return representation.toString();
    }

}






