package demos.udemytictacto;

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
        if (player.counterPositions.containsAll((WinningPatterns.getTop()))){
            return player.PlayerName.toUpperCase() + " has won the game!";
        }
        else if (player.counterPositions.containsAll((WinningPatterns.bottom()))) {
            return player.PlayerName.toUpperCase() + " has won the game!";
        }
        else if (player.counterPositions.containsAll((WinningPatterns.middle()))) {
            return player.PlayerName.toUpperCase() + " has won the game!";
        }
        else if (player.counterPositions.containsAll((WinningPatterns.topLeftToBottomRight()))) {
            return player.PlayerName.toUpperCase() + " has won the game!";
        }
        else if (player.counterPositions.containsAll((WinningPatterns.topRightToBottomLeft()))) {
            return player.PlayerName.toUpperCase() + " has won the game!";
        }
        else {
            return "";
        }
    }
}

