package pieces;

public class Bishop extends Piece{

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        //add logica especifica do bispo
        return false;
    }

    public static char getRepresentation() {
        return new Pawn(Color.BLACK).isBlack() ? 'B' : 'b';
    }
    public static double getPointValue() {
        return 3.0;
    }

    public void addPointsForSameColumnPawn() {

    }


}
