package chess;

import pieces.Piece;

import java.util.Iterator;

public class BoardIterator implements Iterator<Piece> {

    private final Board board;
    private int fileIndex;
    private int rankIndex;

    public BoardIterator(Board board) {
        this.board = board;
        this.fileIndex = 0;
        this.rankIndex = 0;
    }
    @Override
    public boolean hasNext() {
        return fileIndex < 8 && rankIndex < 8;
    }

    @Override
    public Piece next() {
        Piece currentPiece = board.getPieceAt(fileIndex, rankIndex);

        if (fileIndex < 7) {
            fileIndex++;
        } else {
            fileIndex = 0;
            rankIndex++;
        }
        return currentPiece;
    }


}
