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
    public char getRepresentation() {
        return isBlack() ? 'R' : 'r';
    }
    public static double getPieceValue() {
        return 5.0;
    }

    @Override
    public void addPointsForSameColumnPawn() {

    }
}
