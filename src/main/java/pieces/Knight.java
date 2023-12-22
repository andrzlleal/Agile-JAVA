package pieces;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        //add logica especifica do cavalo aqui
        return false;
    }

    public static char getRepresentation() {
        return new Pawn(Color.BLACK).isBlack() ? 'N' : 'n';
    }
    public static double getPointValue() {
        return 2.5;
    }

    public void addPointsForSameColumnPawn() {

    }
}
