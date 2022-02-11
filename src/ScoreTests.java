import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreTests {
    @Test
    public void testAddPoint() {
        Score score = new Score("User1", 0);
        score.addPoint();
        Assertions.assertEquals(score.getPoints(), 1);
    }
}