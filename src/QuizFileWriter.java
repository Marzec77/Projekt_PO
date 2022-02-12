
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class QuizFileWriter {
    private final String SCORES_FILE_PATH;

    QuizFileWriter(String scoresFilePath) {
        this.SCORES_FILE_PATH = scoresFilePath;
    }

    public void saveScoresToFile(List<Score> scores) {
        try {
            FileWriter fileWriter = new FileWriter(SCORES_FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String fileContent = "";
            /** Dane kazdego wyniku sa dodawane jako nowa linia do ciagu znakow. Przykladowo: Jan;10 */
            for(Score score : scores) {
                fileContent += score.getPlayerName() + ";" + score.getPoints() + "\n";
            }

            /** Utworzony z wpisow o graczach ciag jest zapisywany do pliku */
            bufferedWriter.write(fileContent);
            bufferedWriter.close();
        }
        /** W przypadku bledu wyswietlany sie komunikat */
        catch (IOException e) {
            System.out.println("Nie udalo sie zapisac wynikow do pliku!");
        }
    }
}