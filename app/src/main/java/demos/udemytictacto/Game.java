package demos.udemytictacto;

import java.util.ArrayList;

/**
 * Created by matthewframpton on 28/12/2016.
 */
public class Game {

    private String playersTurn;

    public void start() {
        playersTurn = "grumpyCat";
    }

    //TODO: Need to add linear layout, button and text label to restart game
    //TODO: Need to set visibility from invisibile to visible
    //TODO: Loop through all images and set position back to blah blah
    String CheckForWinner(Players player) {
        for (ArrayList<Integer> pattern : WinningPatterns.getGetWinningPatterns()){
            if (player.counterPositions.containsAll(pattern)){
                return player.PlayerName.toUpperCase() + " has won the game!";
            }
    }
        return "";
    }
}

