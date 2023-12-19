package chess;

import pieces.Piece;

public class Game {
Board board;

public Game() {
    this.board = new Board();
}
public void startGame() {
    board = new Board();
    board.initializeBoard();
    //logica adicional de configuração
}
public void movePiece(String fromPosition, String toPosition) {
    Piece piece = board.getPieceAt(fromPosition);
    if (piece.getType() != Piece.PieceType.NO_PIECE) {
        board.placePieceAt(Piece.noPiece(), fromPosition);
        board.placePieceAt(piece, toPosition);
        board.assignPieceValues();
        System.out.println("Movimento realizado: " + fromPosition + " para " + toPosition);
    } else {
        System.out.println("Movimento inválido. Peça não encontrada em " + fromPosition);
    }

}
public void moveKing(String fromPosition, String toPosition) {
    Piece king = board.getPieceAt(fromPosition);

    if (king.getType() == Piece.PieceType.KING) {
        int fromFile = board.getFileIndex(fromPosition);
        int fromRank = board.getRankIndex(fromPosition);

        int toFile = board.getFileIndex(toPosition);
        int toRank = board.getRankIndex(toPosition);

        if (isValidKingMove(fromFile, fromRank, toFile, toRank)) {
            board.placePieceAt(Piece.noPiece(), fromPosition);
            board.placePieceAt(king, toPosition);
            System.out.println("Movimento do rei realizado: " + fromPosition + " para " + toPosition);
        } else {
            System.out.println("Movimento inválido para o rei de " + fromPosition + " para " + toPosition);
        }
    }
}
    private boolean isValidKingMove(int fromFile, int fromRank, int toFile, int toRank) {
        return Math.abs(toFile - fromFile) <= 1 && Math.abs(toRank - fromRank) <= 1;
    }
public boolean moveQueen(String fromPosition, String toPosition) {
    Piece queen = board.getPieceAt(fromPosition);

    if (queen.getType() == Piece.PieceType.QUEEN) {
        int fromFile = board.getFileIndex(fromPosition);
        int fromRank = board.getRankIndex(fromPosition);

        int toFile = board.getFileIndex(toPosition);
        int toRank = board.getRankIndex(toPosition);

        //verifica se o movimento é válido para a rainha

        if (queen.isValidQueenMove(fromFile, fromRank, toFile, toRank)) {
            //o movimento é válido, execute a movimentação
            board.placePieceAt(Piece.noPiece(), fromPosition);
            board.placePieceAt(queen, toPosition);
            board.assignPieceValues();
            System.out.printf(" Movimento de rainha realizado: " + fromPosition + " para " + toPosition);
            return true;
        } else {
            System.out.printf(" Movimento inválido para a rainha de " + fromPosition + " para " + toPosition);
        }
        } else {
            System.out.printf(" Peça em " + fromPosition + " não é uma rainha ");
    }
    return false;
}

}
