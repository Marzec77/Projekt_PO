import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QuizFileReaderTests {
    QuizFileReader fileReader = new QuizFileReader("questions.txt", "scores.txt");

    @Test
    public void testNumberOfLoadedQuestions() {
        List<Question> questions = fileReader.getQuestionsFromFile();

        int expectedListSize = 10;
        Assertions.assertEquals(questions.size(), expectedListSize);
    }
}
