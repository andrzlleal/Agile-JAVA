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
    int fromFile = board.getFileIndex(fromPosition);
    int fromRank = board.getRankIndex(fromPosition);

    int toFile = board.getFileIndex(toPosition);
    int toRank = board.getRankIndex(toPosition);

    Piece pieceAtFromPosition = board.getPieceAt(fromFile, fromRank);

    if (!(pieceAtFromPosition instanceof NoPiece)) {
        board.placePieceAt(Piece.noPiece(), toFile, toRank);
        board.placePieceAt(pieceAtFromPosition, toFile, toRank);
        board.assignPieceValues();
        System.out.println("Movimento realizado: " + fromPosition + " para " + toPosition);
            return true;
    }else {
        System.out.println("Movimento inválido. Peça não encontrada em " + fromPosition);
    }
    return false;
}
public boolean moveKing(String fromPosition, String toPosition) {
        int fromFile = board.getFileIndex(fromPosition);
        int fromRank = board.getRankIndex(fromPosition);

        int toFile = board.getFileIndex(toPosition);
        int toRank = board.getRankIndex(toPosition);

        Piece king = board.getPieceAt(fromFile, fromRank);

        if (king instanceof King) {
            if (!fromPosition.equals(toPosition) && king.isValidMove(fromFile, fromRank, toFile, toRank)) {
                board.placePieceAt(Piece.noPiece(), fromFile, fromRank);
                board.placePieceAt(king, toFile, fromRank);
                System.out.println("Movimento do Rei realizado de: " + fromPosition + " para " + toPosition);
                    return true;
            } else {
                System.out.println("Movimento inválido para o Rei de: " + fromPosition + " para " + toPosition);
            }

        }
            return false;
}
public boolean moveQueen(String fromPosition, String toPosition) {
        int fromFile = board.getFileIndex(fromPosition);
        int fromRank = board.getRankIndex(fromPosition);

        int toFile = board.getFileIndex(toPosition);
        int toRank = board.getRankIndex(toPosition);

        Piece queen = board.getPieceAt(fromFile, fromRank);
        if (queen instanceof Queen) {
            //verifica se o movimento é válido para a rainha usando o metodo isValidMove de Piece
        if (queen.isValidMove(fromFile, fromRank, toFile, toRank)) {
            //o movimento é válido, execute a movimentação
            board.placePieceAt(Piece.noPiece(), fromFile, fromRank);
            board.placePieceAt(queen, toFile, toRank);
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
