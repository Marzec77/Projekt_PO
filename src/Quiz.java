

import java.util.List;
import java.util.Scanner;

public class Quiz {
    private Scanner scanner;
    private Score currentPlayer;
    private List<Score> scores;

    Quiz() {

        scanner = new Scanner(System.in);
        currentPlayer = new Score();
    }
    public void start() {
       

            // Utworzenie nowego wyniku dla aktualnego gracza
            currentPlayer = new Score();
            askForPlayerName();


        }


    private void askForPlayerName() {
        // Aktualizacja nazwy gracza wedlug podanej przez niego wartosci
        System.out.println("Podaj swoje imie:");
        String name = scanner.nextLine();
        currentPlayer.setPlayerName(name);
    }

}