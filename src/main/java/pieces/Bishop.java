package pieces;

public class Bishop extends Piece{

    public Bishop(Color color) {
        super(PieceType.BISHOP);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        //add logica especifica do bispo
        return false;
    }
}
