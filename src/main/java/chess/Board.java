package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

/**
 *  Represents a chess board that can hold pawns.

 * This class provide methods to manage a chess board and pawns to it.
 */
public class Board {
    private final List<Pawn> pieces;

    public Board() {
        pieces = new ArrayList<>();
        initializeBoardWithPieces();
        initialize();
    }

    private void initializeBoardWithPieces() {
        for(int i = 0; i < 16; i++) {
            if(i < 8) {
                pieces.add(new Pawn(Pawn.WHITE));
            } else {
                pieces.add(new Pawn(Pawn.BLACK));
            }
        }
    }
    public void initialize() {
        initializeRank(Pawn.WHITE, 1);
        initializeRank(Pawn.BLACK, 6);
    }
    private void initializeRank(String color, int rank) {
        for(int i = 0; i < 8; i++) {
            pieces.add(new Pawn(color));
        }

    }
    public int getPieceCount() {
        return pieces.size();
    }
    public List<Pawn> getPieces(){
        return pieces;
    }

    public int getNumberOfPieces() {
        return pieces.size();
    }

    /**
     * Adds a white pawn to the board
     */
    public void addWhitePawn() {
        Pawn whitePawn = new Pawn(Pawn.WHITE);
        pieces.add(whitePawn);
    }

    /**
     * Adds a black pawn to the board
     **/
    public void addBlackPawn() {
        Pawn blackPawn = new Pawn(Pawn.BLACK);
        pieces.add(blackPawn);
    }
    /**
     * Gets the number of pawns currently on the board.
     *
     * @return The number of pawns on the board.
     */

}


