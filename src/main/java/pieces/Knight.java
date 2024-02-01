package pieces;

public abstract class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
        //add logica especifica do cavalo aqui
        return false;
    }

    public char getPieceRepresentation() {
        return isBlack() ? 'N' : 'n';
    }


    public static double getPieceValue() {
        return 2.5;
    }

    public void addPointsForSameColumnPawn() {

    }
}
