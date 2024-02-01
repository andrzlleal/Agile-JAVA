import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ScorerTest {
    @Test
    public void testCaptureScore() {
        Scorer scorer = new Scorer();
        assertEquals(75, scorer.score("75"));
    }
    @Test
    public void testBadScoreEntered() {
        Scorer scorer = new Scorer();
        try {
            scorer.score("abd");
            fail("expected NumberFormatException on bad input");
        } catch (NumberFormatException success) {
        }
    }

}
