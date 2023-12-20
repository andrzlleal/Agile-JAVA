package pieces;

public class Pawn extends Piece{
    public Pawn(Color color) {
        super(PieceType.PAWN);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        return false;
    }
}
