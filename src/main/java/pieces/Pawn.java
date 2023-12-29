package pieces;

import chess.Board;

public class Pawn extends Piece {
    private boolean hasMoved = false;

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        int forwardDirection = isBlack() ? 1 : -1;

        if (toFile == fromFile && toRank == fromRank + forwardDirection && Board.isEmpty(toFile, toRank)) {
            return true;
        }
        return !hasMoved && toFile == fromFile && toRank == fromRank + 2 * forwardDirection && Board.isEmpty(toFile, toRank);
    }
    public char getRepresentation() {
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


}
