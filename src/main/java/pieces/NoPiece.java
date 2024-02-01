package pieces;

public abstract class NoPiece extends Piece {
    private static final NoPiece uniqueInstance = new NoPiece(Color.NO_PIECE) {
        @Override
        public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
            return false;
        }
    };
    public NoPiece(Color color) {
      super(color, 0, 0);
    }

    public static NoPiece getInstance() {
        return uniqueInstance;
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank, Piece[][] pieces) {
        return false;
    }

    public char getPieceRepresentation() {
        return '.';
    }

    @Override
    public void addPointsForSameColumnPawn() {

    }
}