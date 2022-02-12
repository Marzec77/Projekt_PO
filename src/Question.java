public class Question {
    private String content;
    private String[] answers;
    private char correctAnswer;
/** Konstruktor Question odpowiada za zainicjalizowanie pól klasy danymi które są podane w argumentach metody. */
    Question(String content, String[] answers, char correctAnswer) {
        this.content = content;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public void print(int questionNumber) {
        System.out.println(questionNumber + ". " + content);
        System.out.println("A. " + answers[0]);
        System.out.println("B. " + answers[1]);
        System.out.println("C. " + answers[2]);
        System.out.println("D. " + answers[3]);
    }
/** Jesli odpowiedz uzytkownika jest mala litera, to przeksztalca sie ja na wielka */
    public boolean isAnswerCorrect(char answer) {

        if(Character.isLowerCase(answer)) {
            answer -= 32;
        }
        return answer == correctAnswer;
    }
}