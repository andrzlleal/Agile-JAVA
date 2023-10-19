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
        ranks.add("........\n");
        ranks.add("PPPPPPPP\n");
        ranks.add("........\n");
        ranks.add("........\n");
        ranks.add("........\n");
        ranks.add("........\n");
        ranks.add("pppppppp\n");
        ranks.add("........");

        System.out.println("Representation\n" + ranks);
    }
    public void initializeBoard() {
        for (String rank : ranks) {
            for (char symbol : rank.toCharArray()) {
                if (symbol == 'p') {
                    pawns.add(new Pawn(Pawn.WHITE, 'p'));
                } else if (symbol == 'P') {
                    pawns.add(new Pawn(Pawn.BLACK, 'P'));
                }
            }
        }
    }
        public List<Pawn> getPawns() {
           return pawns;
    }
         public int getNumberOfPawns() {
            return pawns.size();
    }
        public List<String> getRanks() {
            return ranks;
    }
}
//   public void initializeBoard() {
//     for (int i = 0; i < 8; i++) {
//        pawns.add(new Pawn(Pawn.WHITE, 'p'));
//     }
//     for (int i = 0; i < 8; i++) {
//        pawns.add(new Pawn(Pawn.BLACK, 'p'));
//    }
// }

//    public void addPawn(Pawn pawn) {
//        pawns.add(pawn);
//    }


    //    public static final String FIRST_RANK = "........";
//    private final List<Pawn> pieces;
//
//    public Board() {
//        pieces = new ArrayList<>();
//        initializeBoardWithPieces();
//    }
//    private void initializeBoardWithPieces() {
//        for (int rank = 1; rank <= 8; rank++) {
//            for (int file = 1; file <= 8; file++) {
//                if (rank == 2) {
//                    pieces.add(new Pawn(Pawn.WHITE, rank, file));
//                }else if (rank == 7) {
//                    pieces.add(new Pawn(Pawn.BLACK, rank, file));
//                }
//            }
//        }
//    }
//    public void initialize() {
//        initializeRank(Pawn.WHITE, 1);
//        initializeRank(Pawn.BLACK, 6);
//    }
//    private void initializeRank(String color, int rank) {
//        for(int i = 0; i < 8; i++) {
//            pieces.add(new Pawn(color));
//        }
//
//    }
//    public int getPieceCount() {
//        return pieces.size();
//    }
//    public List<Pawn> getPieces(){
//        return pieces;
//    }
//
//    public int getNumberOfPieces() {
//        return pieces.size();
//    }
//
//    /**
//     * Adds a white pawn to the board
//     */
//    public void addWhitePawn() {
//        Pawn whitePawn = new Pawn(Pawn.WHITE);
//        pieces.add(whitePawn);
//    }
//
//    /**
//     * Adds a black pawn to the board
//     **/
//    public void addBlackPawn() {
//        Pawn blackPawn = new Pawn(Pawn.BLACK);
//        pieces.add(blackPawn);
//    }
//    /*
//     * Gets the number of pawns currently on the board.
//     *
//     * @return The number of pawns on the board.
//     */
//    public String getPrintableBoard() {
//        StringBuilder boardRepresentation = new StringBuilder();
//
//        boardRepresentation.append("........\n");
//
//        for(Pawn piece:pieces) {
//            if (piece.getPrintableRepresentation() == 'P') {
//                boardRepresentation.append(piece.getPrintableRepresentation());
//            }
//        }
//        boardRepresentation.append("\n");
//        boardRepresentation.append("........\n");
//
//        boardRepresentation.append("........\n");
//
//        boardRepresentation.append("........\n");
//
//        boardRepresentation.append("........\n");
//
//        for(Pawn piece:pieces) {
//            if(piece.getPrintableRepresentation() == 'p') {
//                boardRepresentation.append(piece.getPrintableRepresentation());
//            }
//        }
//        boardRepresentation.append("\n");
//
//        boardRepresentation.append("........");
//
////        for(int rank = 8; rank >=1; rank--) {
////            for(int file = 1; file <= 8; file++) {
////                boolean pieceFound = false;
////
////                for(Pawn piece:pieces) {
////                    if (piece.getRank() == rank && piece.getFile() == file) {
////                        boardRepresentation.append(piece.getPrintableRepresentation());
////                        pieceFound = true;
////                        break;
////                    }
////                }
////                if (!pieceFound) {
////                    boardRepresentation.append(".");
////                }
////            }
////            boardRepresentation.append(System.getProperty("line.separator"));
////        }
//        return boardRepresentation.toString();
//    }
//




