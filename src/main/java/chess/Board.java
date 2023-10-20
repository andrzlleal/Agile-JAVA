package chess;
import pieces.Pawn;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Pawn> pawns = new ArrayList<>();
    private final List<String> ranks = new ArrayList<>();

    public Board() {
        initializeRanks();
    }
    private void initializeRanks() {
        ranks.add("........");
        ranks.add("PPPPPPPP");
        ranks.add("........");
        ranks.add("........");
        ranks.add("........");
        ranks.add("........");
        ranks.add("pppppppp");
        ranks.add("........");

//        System.out.println("Representation\n" + ranks);
    }
    public void initializeBoard() {
        for (String rank : ranks) {
            for (char symbol : rank.toCharArray()) {
                if (symbol == 'p') {
                    pawns.add(new Pawn(Pawn.WHITE));
                } else if (symbol == 'P') {
                    pawns.add(new Pawn(Pawn.BLACK));
                }
            }
        }
    }
         public int getNumberOfPawns() {
            return pawns.size();
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






