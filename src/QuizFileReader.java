
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

    public List<Question> getQuestionsFromFile() {
        // Tworzona jest pusta lista przechowujaca pytania
        List<Question> questions = new ArrayList<>();

        try {
            File file = new File(QUESTIONS_FILE_PATH);
            // Jesli szukany plik nie istnieje, to zwracana jest pusta lista
            if(!file.exists()) {
                return questions;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] splittedLine, answers;
            String line, questionContent;
            char correctAnswer;

            // Z kazdej lini pliku wczytywane sa dane pytania
            // Plik dzieli sie na czesci oddzielane srednikiem (;)
            while ((line = bufferedReader.readLine()) != null) {
                splittedLine = line.split(";");
                questionContent = splittedLine[0];
                answers = new String[NUMBER_OF_ANSWERS];
                for(int answerIndex = 0; answerIndex < NUMBER_OF_ANSWERS; answerIndex++) {
                    answers[answerIndex] = splittedLine[answerIndex + 1];
                }
                correctAnswer = splittedLine[NUMBER_OF_ANSWERS + 1].charAt(0);
                // Do listy dodaje sie nowy obiekt typu Question o parametrach odczytanych z pliku
                questions.add(new Question(questionContent, answers, correctAnswer));
            }
            bufferedReader.close();

        } catch (IOException e) {
            // W przypadku bledu wyswietlany jest komunikat
            System.out.println("Nie udalo sie wczytac pytan z pliku!");
        }

        // Zwracana jest lista zawierajaca odczytane z pliku pytania
        return questions;
    }


}