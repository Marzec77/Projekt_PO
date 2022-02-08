

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
            askForNewGame();

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
        for(Question question : questions) {
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

    private void askForNewGame() {
        // Wyswietlenie zapytania o ponowna gre oraz pobranie odpowiedzi
        // Jesli odpowiedz jest twierdzaca, to quiz zaczyna sie od poczatku
        // Jesli jest przeczaca, to wyniki sa zapisywane do pliku, a program sie konczy
        // W przypadku blednej wartosci funkcja wywolywana jest ponownie
        int choice;

        System.out.println("Czy chcesz zagrac ponownie?");
        System.out.println("1. Tak");
        System.out.println("2. Nie");
        System.out.println("Podaj wybor (1 lub 2):");

        try {
            choice = Integer.parseInt(scanner.nextLine());
            if(choice != 1 && choice != 2) {
                throw new Exception();
            }
            if(choice == 1) {
                start();
            } else {
                System.out.println("Dziekujemy za gre. Program zostanie wylaczony.");

                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Podany wybor jest nieprawidlowy!");
            askForNewGame();
        }
    }
}