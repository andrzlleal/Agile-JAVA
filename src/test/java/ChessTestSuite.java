import chess.BoardTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pieces.PieceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({BoardTest.class, PieceTest.class, ChessTestSuite.class})
public class ChessTestSuite {
}
