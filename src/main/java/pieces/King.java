package pieces;

public class King extends Piece{
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        return Math.abs(toFile - fromFile) <= 1 && Math.abs(toRank - fromRank) <= 1;
    }

    public char getRepresentation() {
        return isBlack() ? 'K' : 'k';
    }

    public static double getPieceValue() {
        return 0;
    }
    @Override
    public void addPointsForSameColumnPawn() {

    }
}
