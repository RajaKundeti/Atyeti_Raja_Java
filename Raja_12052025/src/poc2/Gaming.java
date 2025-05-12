package poc2;
/*
    Concepts Covered:
    -----------------
    Local vs global (instance) variables
    Use of final for constants
    Variable shadowing
    Scope resolution with this
    Safe updates within limits (MAX_LEVEL)

 */

public class Gaming {

    public static void main(String[] args) {
        GameTracker player1 = new GameTracker("Arun");
        player1.increaseScore(10);
        player1.increaseScore(1);
        player1.increaseScore(10);
        player1.resetGame();
        player1.increaseScore(11);
        player1.increaseScore(32);
    }
}
