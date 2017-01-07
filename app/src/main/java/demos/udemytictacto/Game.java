package demos.udemytictacto;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by matthewframpton on 28/12/2016.
 */
public class Game extends MainActivity {

    public Activity activity;

    public Game( Activity _activity){
        this.activity = _activity;
    }

    public String playersTurn;
    boolean GameActive = true;

    public void start() {
        GameActive = true;
        playersTurn = "grumpyCat";
        //setGameGrid();
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

    public boolean getGameState() {
        return this.GameActive;
    }

    public void setGameActive(boolean state) {
        this.GameActive = state;
    }

    void hideRestartView() {
        View view= this.activity.findViewById(R.id.winningKitty);
        view.setVisibility(View.INVISIBLE);
    }

    void ChangePlayerTurn() {
        if (playersTurn == "grumpyCat") {
            playersTurn = "kitten";
        } else {
            playersTurn = "grumpyCat";
        }
    }

    public void setGameState(boolean state) {
        this.GameActive = state;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void CheckForDraw(Players kitten, Players grumpy) {
        if (kitten.counterPositions.size() + grumpy.counterPositions.size() == 9){
            TextView gameResult = (TextView) this.activity.findViewById(R.id.textViewGameResult);
            gameResult.setText("Draw");
            //TODO: Not currently working when calling external view
            showRestartView();
        }
    }
}

