package pieces;

public class NoPiece extends Piece{

    public NoPiece() {
        super(Color.NO_PIECE);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        return false;
    }


    public static char getRepresentation() {
        return '.';
    }

    @Override
    public void addPointsForSameColumnPawn() {

    }


}
