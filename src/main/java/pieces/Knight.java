package pieces;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        //add logica especifica do cavalo aqui
        return false;
    }

    public char getRepresentation() {
        return isBlack() ? 'N' : 'n';
    }


    public static double getPieceValue() {
        return 2.5;
    }

    public void addPointsForSameColumnPawn() {

    }
}
