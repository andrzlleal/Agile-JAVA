package chess;

import pieces.King;
import pieces.NoPiece;
import pieces.Piece;
import pieces.Queen;

public class Game {
Board board;

public Game() {
    this.board = new Board();
}
public void startGame() {
    board.initializeBoard();
    //logica adicional de configuração
}

public boolean movePiece(String fromPosition, String toPosition) {
    Piece piece = board.getPieceAt(fromPosition);
    if (!(piece instanceof NoPiece)){
        board.placePieceAt(piece, toPosition);
        board.placePieceAt(Piece.noPiece(), fromPosition);
        board.assignPieceValues();
        System.out.println("Movimento realizado: " + fromPosition + " para " + toPosition);
        return true;
    } else {
        System.out.println("Movimento inválido. Peça não encontrada em " + fromPosition);
    }
    return false;
}
public boolean moveKing(String fromPosition, String toPosition) {
    Piece king = board.getPieceAt(fromPosition);

    if (king instanceof King) {
        int fromFile = board.getFileIndex(fromPosition);
        int fromRank = board.getRankIndex(fromPosition);

        int toFile = board.getFileIndex(toPosition);
        int toRank = board.getRankIndex(toPosition);

        if(!fromPosition.equals(toPosition) && king.isValidMove(fromFile, fromRank, toFile, toRank)) {
            board.placePieceAt(Piece.noPiece(), fromPosition);
            board.placePieceAt(king, toPosition);
            System.out.println("Movimento do rei realizado: " + fromPosition + " para " + toPosition);
            return true;
        } else {
            System.out.println("Movimento inválido para o rei de " + fromPosition + " para " + toPosition);
        }
    }
    return false;
}
public boolean moveQueen(String fromPosition, String toPosition) {
    Piece queen = board.getPieceAt(fromPosition);

    if (queen instanceof Queen) {
        int fromFile = board.getFileIndex(fromPosition);
        int fromRank = board.getRankIndex(fromPosition);

        int toFile = board.getFileIndex(toPosition);
        int toRank = board.getRankIndex(toPosition);

        //verifica se o movimento é válido para a rainha usando o metodo isValidMove de Piece

        if (queen.isValidMove(fromFile, fromRank, toFile, toRank)) {
            //o movimento é válido, execute a movimentação
            board.placePieceAt(Piece.noPiece(), fromPosition);
            board.placePieceAt(queen, toPosition);
            board.assignPieceValues();
            System.out.printf("Movimento de rainha realizado: " + fromPosition + " para " + toPosition);
            return true;
        } else {
            System.out.printf("Movimento inválido para a rainha de " + fromPosition + " para " + toPosition);
        }
        } else {
            System.out.printf("Peça em " + fromPosition + " não é uma rainha ");
        }
        return false;
    }

}
