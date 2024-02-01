package pieces;


public abstract class Pawn extends Piece {
    private boolean hasMoved = false;

    public Pawn(Color color) {
        super(color);
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
        int forwardDirection = isBlack() ? 1 : -1;

        if ((toFile == fromFile) && (toRank == (fromRank + forwardDirection)) && isEmpty(toFile, toRank, pieces)) {
            return true;
        }
        return !hasMoved() && toFile == fromFile && toRank == fromRank + 2 * forwardDirection && isEmpty(toFile, toRank, pieces);
    }
    public char getPieceRepresentation() {
        return isBlack() ? 'P' : 'p';
    }

    public static double getPieceValue() {
        return 1.0;
    }

    @Override
    public void addPointsForSameColumnPawn() {
        setStrength(getStrength() + 0.5);
    }
    @Override
    public void move() {
        super.move();
        hasMoved = true;
    }
    private boolean isEmpty(int file, int rank, Piece[][] pieces) {
        return pieces[file][rank] instanceof NoPiece;
    }


}
