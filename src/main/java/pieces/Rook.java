package pieces;

public class Rook extends Piece{
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        //add lógica espeficia aqui
        return false;
    }
    public static char getRepresentation() {
        return new Pawn(Color.BLACK).isBlack() ? 'R' : 'r';
    }
    public static double getPointValue() {
        return 5.0;
    }

    @Override
    public void addPointsForSameColumnPawn() {

    }
}
