public class Score implements Comparable<Score>{
    private String playerName;
    private int points;

    Score() {
        playerName = "Player";
        points = 0;
    }

    Score(String playerName) {
        this.playerName = playerName;
        this.points = 0;
    }

    Score(String playerName, int points) {
        this.playerName = playerName;
        this.points = points;
    }

    public int compareTo(Score other) {
        // Funkcja porownujaca obiekty typu wedlug ich punktow
        // Pozwala m.in. na latwe sortowanie list z wynikami
        if(this.points > other.points) {
            return 1;
        } else if(this.points == other.points) {
            return 0;
        } else {
            return -1;
        }
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void addPoint() {
        points++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPoints() {
        return points;
    }
}