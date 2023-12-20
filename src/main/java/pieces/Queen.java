package pieces;

public class Queen extends Piece{
    public Queen(Color color) {
        super(PieceType.QUEEN);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {

        int fileDifference = Math.abs(toFile - fromFile);
        int rankDifference = Math.abs(toRank - fromRank);

        Boolean isDiagonal = fileDifference == rankDifference;
        Boolean isVertical = fromFile == toFile;
        Boolean isHorizontal = fromRank == toRank;

        boolean isBlackQueen = this.isBlack();
        boolean isWhiteQueen = this.isWhite();

        return (isDiagonal || isVertical || isHorizontal) && isValidSquare(toFile, toRank) && (isBlackQueen || isWhiteQueen);
    }
}
