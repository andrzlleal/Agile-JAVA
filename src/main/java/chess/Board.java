package chess;
import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

/**
 *  Represents a chess board that can hold pawns.

 * This class provide methods to manage a chess board and pawns to it.
 */
public class Board {
    public int getNumberOfPieces() {
        return pieces.size();
    }

    /**
     * The list of pawns currently on the board.
     */
    private final List<Pawn> pieces;

    /**
     * Creates a new empty chess board.
     */
    public Board() {
        pieces = new ArrayList<>();
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
    public int getPiecesCount() {
        return pieces.size();
    }

    /**
     * Gets the list of pawns currently on the board
     *
     * @return A list of pieces.Pawn objects representing the pawns on the board
     */

    public List<Pawn> getPieces() {
        return pieces;
    }

}


