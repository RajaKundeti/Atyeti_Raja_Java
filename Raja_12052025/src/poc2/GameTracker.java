package poc2;

public class GameTracker {

    private final String playerName;
    private int score = 0;
    private int playerLevel = 0;
    private static final int maxLevel = 10;

    public GameTracker(String playerName) {
        this.playerName = playerName;
    }

    public void increaseScore(int score){
        int previousScore = this.score;
        this.score += score;
        System.out.println(playerName+ " Current Score: "+score);
        System.out.println(playerName+ " Total Score: "+this.score);
        levelUp();
    }

    public void levelUp() {
        if (playerLevel < maxLevel) {
            if (score <= 10) {
                playerLevel = 1;
            } else if (score <= 20) {
                playerLevel = 2;
            } else if (score <= 30) {
                playerLevel = 3;
            } else if (score <= 40) {
                playerLevel = 4;
            } else if (score <= 50) {
                playerLevel = 5;
            } else if (score <= 60) {
                playerLevel = 6;
            } else if (score <= 70) {
                playerLevel = 7;
            } else if (score <= 80) {
                playerLevel = 8;
            } else if (score <= 90) {
                playerLevel = 9;
            } else {
                playerLevel = 10;
            }
            System.out.println("Hurrah! LEVEL UP");
            System.out.println("You are currently at level " + playerLevel);
        }
    }

    public void resetGame(){
        System.out.println("Game Reset Success!");
        score = 0;
        playerLevel = 0;
    }

}
