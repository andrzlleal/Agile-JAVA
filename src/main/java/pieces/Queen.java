package pieces;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {

        int fileDifference = Math.abs(toFile - fromFile);
        int rankDifference = Math.abs(toRank - fromRank);

        Boolean isDiagonal = fileDifference == rankDifference;
        Boolean isVertical = fromFile == toFile;
        Boolean isHorizontal = fromRank == toRank;

        boolean isBlackQueen = isBlack();
        boolean isWhiteQueen = isWhite();

        return (isDiagonal || isVertical || isHorizontal) && isValidSquare(toFile, toRank) && (isBlackQueen || isWhiteQueen);
    }

    public char getRepresentation() {
        return isBlack() ? 'Q' : 'q';
    }

    public static double getPieceValue() {
        return 9.0;
    }

    public void addPointsForSameColumnPawn() {
    }

    @Override
    //falta arrumar o teste
    public List<String> getPossibleMoves(String currentPosition) {
        List<String> possibleMoves = new ArrayList<>();
        int currentFile = currentPosition.charAt(0) - 'a';
        int currentRank = 8 - Integer.parseInt(currentPosition.substring(1));

        int[] fileOffsets = {-1, 0, 1};
        int[] rankOffsets = {-1, 0, 1};

        for(int fileOffset : fileOffsets) {
            for(int rankOffset : rankOffsets) {
                if (fileOffset == 0 && rankOffset == 0) {
                    continue;
                }
                int file = currentFile + fileOffset;
                int rank = currentRank + rankOffset;

                while (isValidSquare(file, rank)) {
                    possibleMoves.add(fileToLetter(file) + (8 - rank));

                    if (fileOffset != 0) {
                        file += fileOffset;
                    }
                    if (rankOffset != 0) {
                        rank += rankOffset;
                    }
                }
            }
        }
        return possibleMoves;
    }
}
