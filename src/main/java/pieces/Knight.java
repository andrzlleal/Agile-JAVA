package pieces;

public class Knight extends Piece{
    public Knight(Color color) {
        super(PieceType.KNIGHT);
    }

    @Override
    public boolean isValidMove(int fromFile, int fromRank, int toFile, int toRank) {
        //add logica especifica do cavalo aqui
        return false;
    }
}
