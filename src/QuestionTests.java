import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuestionTests {
    String[] answers = {"Answer A", "Answer B", "Answer C", "Answer D"};
    Question question = new Question("Content", answers, 'A');

    @Test
    public void testIsAnswerCorrect() {
        Assertions.assertTrue(question.isAnswerCorrect('a'));
        Assertions.assertTrue(question.isAnswerCorrect('A'));

        Assertions.assertFalse(question.isAnswerCorrect('b'));
        Assertions.assertFalse(question.isAnswerCorrect('B'));

        Assertions.assertFalse(question.isAnswerCorrect('c'));
        Assertions.assertFalse(question.isAnswerCorrect('C'));

        Assertions.assertFalse(question.isAnswerCorrect('d'));
        Assertions.assertFalse(question.isAnswerCorrect('D'));
    }
}
