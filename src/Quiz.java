

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Quiz {
    private Scanner scanner;
    private Score currentPlayer;
    private List<Score> scores;
    private List<Question> questions;

    Quiz() {

        scanner = new Scanner(System.in);
        currentPlayer = new Score();
    }

    public void start() {


        // Utworzenie nowego wyniku dla aktualnego gracza
        currentPlayer = new Score();
        askForPlayerName();
        runQuiz();


    }


    private void askForPlayerName() {
        // Aktualizacja nazwy gracza wedlug podanej przez niego wartosci
        System.out.println("Podaj swoje imie:");
        String name = scanner.nextLine();
        currentPlayer.setPlayerName(name);
    }

    private void runQuiz() {
        System.out.println("Przed Toba " + questions.size() + " pytan. Powodzenia!");
        char userAnswer;
        int questionNumber = 1;

        // Przemieszanie pytan z listy (ustawienie losowej kolejnosci)
        Collections.shuffle(questions, new Random());

        // Kazde pytanie z listy jest wyswietlane i pobierana jest odpowiedz gracza
        for (Question question : questions) {
            question.print(questionNumber);
            System.out.println("Podaj odpowedz (A/B/C/D):");
            userAnswer = scanner.nextLine().charAt(0);

            // Jesli odpowiedz jest poprawna, gracz otrzymuje punkt
            if (question.isAnswerCorrect(userAnswer)) {
                currentPlayer.addPoint();
            }
            questionNumber++;
        }


    }
}