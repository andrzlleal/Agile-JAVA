package pieces;

public class Pawn extends Piece{
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        return false;
    }

    public char getRepresentation() {
        return isBlack() ? 'P' : 'p';
    }


    public static double getPieceValue() {
        return 1.0;
    }
    @Override
    public void addPointsForSameColumnPawn() {
        setStrength(getStrength() + 0.5);
    }



}
