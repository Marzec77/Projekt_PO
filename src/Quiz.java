
import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Score> scores;
    private List<Question> questions;
    private Score currentPlayer;
    private Scanner scanner;
    private final String QUESTIONS_FILE_PATH = "questions.txt";
    private final String SCORES_FILE_PATH = "scores.txt";

    Quiz() {
        currentPlayer = new Score();

        scanner = new Scanner(System.in);

    }

    public void start() {
        // Sprawdzenie, czy lista zawiera pytania
        if(questions.size() > 0) {
            // Utworzenie nowego wyniku dla aktualnego gracza
            currentPlayer = new Score();
            askForPlayerName();
            runQuiz();
            askForNewGame();
        } else {
            System.out.println("Nie udalo sie wczytac pytan z pliku!");
        }
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

        // Po quizie wynik jest zapisywany w liscie wynikow,
        // wyswietla sie wynik skonczonej gry oraz ranking
        saveScore();
        printResult();
        printScoreTable();
    }

    private void saveScore() {
        scores.add(currentPlayer);
    }

    private void printResult() {
        System.out.println("Twoj wynik: " + currentPlayer.getPoints() + "/" + questions.size());
    }

    private void printScoreTable() {
        System.out.println("Ranking:");
        int rankingPlace = 1;
        // Lista wynikow jest sortowana i odwracana, aby uzyskac kolejnosc od najwyzszych do najnizszych wynikow
        // Takie sortowanie jest mozliwe, poniewaz klasa Score implementuje inferfejs Comparable
        Collections.sort(scores);
        Collections.reverse(scores);
        // Kazdy z zapisanych wynikow jest wyswietlany
        for(Score score : scores) {
            System.out.println(rankingPlace + ". " + score.getPlayerName() + " (" + score.getPoints() + " pkt)");
            rankingPlace++;
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