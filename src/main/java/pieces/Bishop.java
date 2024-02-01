package pieces;

public abstract class Bishop extends Piece{

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        //add logica especifica do bispo
        return false;
    }

    public char getPieceRepresentation() {
        return isBlack() ? 'B' : 'b';
    }

    public static double getPieceValue() {
        return 3.0;
    }

    public void addPointsForSameColumnPawn() {

    }



}
