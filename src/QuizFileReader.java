
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class QuizFileReader {
    private final String QUESTIONS_FILE_PATH;
    private final String SCORES_FILE_PATH;
    private final int NUMBER_OF_ANSWERS = 4;

    QuizFileReader(String questionsFilePath, String scoresFilePath) {
        this.QUESTIONS_FILE_PATH = questionsFilePath;
        this.SCORES_FILE_PATH = scoresFilePath;
    }
/** Tworzona jest pusta lista przechowujaca pytania */
    public List<Question> getQuestionsFromFile() {

        List<Question> questions = new ArrayList<>();

        try {
            File file = new File(QUESTIONS_FILE_PATH);
            /** Jesli szukany plik nie istnieje, to zwracana jest pusta lista */
            if(!file.exists()) {
                return questions;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] splittedLine, answers;
            String line, questionContent;
            char correctAnswer;

            /**Z kazdej lini pliku wczytywane sa dane pytania.Plik dzieli sie na czesci oddzielane srednikiem (;). Do listy dodaje sie nowy obiekt typu Question o parametrach odczytanych z pliku */
            while ((line = bufferedReader.readLine()) != null) {
                splittedLine = line.split(";");
                questionContent = splittedLine[0];
                answers = new String[NUMBER_OF_ANSWERS];
                for(int answerIndex = 0; answerIndex < NUMBER_OF_ANSWERS; answerIndex++) {
                    answers[answerIndex] = splittedLine[answerIndex + 1];
                }
                correctAnswer = splittedLine[NUMBER_OF_ANSWERS + 1].charAt(0);

                questions.add(new Question(questionContent, answers, correctAnswer));
            }
            bufferedReader.close();
/** W przypadku bledu wyswietlany jest komunikat */
        } catch (IOException e) {

            System.out.println("Nie udalo sie wczytac pytan z pliku!");
        }

        /** Zwracana jest lista zawierajaca odczytane z pliku pytania */
        return questions;
    }
    /** Tworzona jest pusta lista przechowujaca wyniki */
    public List<Score> getScoresFromFile() {

        List<Score> scores = new ArrayList<>();

        try {
            File file = new File(SCORES_FILE_PATH);
            /** Jesli szukany plik nie istnieje to zwraca sie pusta liste */
            if(!file.exists()) {
                return scores;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] splittedLine;
            String line, playerName;
            int points;

            /** Z kazdej lini pliku wczytywane sa dane wyniku oddzielone srednikiem (;). Do listy dodawany jest nowy obiekt typu Score o parametrach odczytanych z pliku*/
            while ((line = bufferedReader.readLine()) != null) {
                splittedLine = line.split(";");
                playerName = splittedLine[0];
                points = Integer.parseInt(splittedLine[1]);
                scores.add(new Score(playerName, points));
            }
            bufferedReader.close();
/** W przypadku bledu wyswietlany sie komunikat */
        } catch (IOException e) {

            System.out.println("Nie udalo sie wczytac wynikow z pliku!");
        }

        /** Zwracana jest lista zawierajaca odczytane z pliku wyniki */
        return scores;
    }
}