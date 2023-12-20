package pieces;

public class Rook extends Piece{
    public Rook(Color color) {
        super(PieceType.ROOK);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        //add lógica espeficia aqui
        return false;
    }
}
