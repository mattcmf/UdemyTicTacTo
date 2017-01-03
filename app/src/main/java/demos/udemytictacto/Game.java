package demos.udemytictacto;

import java.util.ArrayList;

/**
 * Created by matthewframpton on 28/12/2016.
 */
public class Game {

    private String playersTurn;
    private boolean GameActive = true;

    public void start() {
        playersTurn = "grumpyCat";
    }

    String CheckForWinner(Players player) {
        for (ArrayList<Integer> pattern : WinningPatterns.getGetWinningPatterns()){
            if (player.counterPositions.containsAll(pattern)){
                this.GameActive = false;
                return player.PlayerName.toUpperCase() + " has won the game!";
            }
    }
        return "";
    }

    public boolean getGameActive(){
        return this.GameActive;
    }

}

