package pieces;

public class NoPiece extends Piece{
    private static final PieceType color = null ;

    public NoPiece() {
        super(color, PieceType.NO_PIECE);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        return false;
    }
}
