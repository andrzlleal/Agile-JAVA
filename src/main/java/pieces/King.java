package pieces;

import java.util.ArrayList;
import java.util.List;

public abstract class King extends Piece{

    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
        int fileDifference = Math.abs(toFile - fromFile);
        int rankDifference = Math.abs(toRank - fromRank);

        return fileDifference <= 1 && rankDifference <= 1;
    }

    public char getPieceRepresentation() {
        return isBlack() ? 'K' : 'k';
    }

    public static double getPieceValue() {
        return 0;
    }
    @Override
    public void addPointsForSameColumnPawn() {}

    @Override
    public List<String> getPossibleMoves(String currentPosition) {
        List<String> possibleMoves = new ArrayList<>();
        int currentFile = currentPosition.charAt(0) - 'a';
        int currentRank = 8 - Integer.parseInt(currentPosition.substring(1));

        int[] fileOffsets = {-1, 0, 1};
        int[] rankOffsets = {-1, 0, 1};

        for (int fileOffset : fileOffsets) {
            for (int rankOffset : rankOffsets) {
                int file = currentFile + fileOffset;
                int rank = currentRank + rankOffset;

                if (file >= 0 && file < 8 && rank >= 0 && rank < 8 &&
                        !(fileOffset == 0 && rankOffset == 0) && isValidMove(currentFile, currentRank, file, rank)) {
                    possibleMoves.add(fileToLetter(file) + (8 - rank));
                }
            }
        }
        return possibleMoves;
    }

}
