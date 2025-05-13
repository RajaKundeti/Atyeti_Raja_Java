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
        if (playerLevel< 10 && score > 0) {
            playerLevel = (score - 1) / 10 + 1;
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
