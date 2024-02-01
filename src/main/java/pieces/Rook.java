package pieces;

public abstract class Rook extends Piece{
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
        //add lógica espeficia aqui
        return false;
    }

    public char getPieceRepresentation() {
        return isBlack() ? 'R' : 'r';
    }
    public static double getPieceValue() {
        return 5.0;
    }

    @Override
    public void addPointsForSameColumnPawn() {

    }

}
