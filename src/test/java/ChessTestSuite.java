import chess.BoardTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pieces.PawnTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BoardTest.class,
        PawnTest.class,
})
public class ChessTestSuite {

}
