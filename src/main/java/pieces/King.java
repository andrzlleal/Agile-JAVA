package pieces;

public class King extends Piece{
    public King(Color color) {
        super(PieceType.KING);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        return Math.abs(toFile - fromFile) <= 1 && Math.abs(toRank - fromRank) <= 1;
    }
}
