package demos.udemytictacto;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    Game game;
    Players kitten;
    Players grumpy;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WinningPatterns.Setup();
        game = new Game(this);
        game.start();
        SetupPlayers();
        setGameGrid();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    void setGameGrid() {
        ArrayList<ImageView> GameGrid = new ArrayList();

        GameGrid.add((ImageView) findViewById(R.id.imageView));
        GameGrid.add((ImageView) findViewById(R.id.imageView2));
        GameGrid.add((ImageView) findViewById(R.id.imageView3));
        GameGrid.add((ImageView) findViewById(R.id.imageView4));
        GameGrid.add((ImageView) findViewById(R.id.imageView5));
        GameGrid.add((ImageView) findViewById(R.id.imageView6));
        GameGrid.add((ImageView) findViewById(R.id.imageView7));
        GameGrid.add((ImageView) findViewById(R.id.imageView8));
        GameGrid.add((ImageView) findViewById(R.id.imageView9));

        for (ImageView position : GameGrid) {
            position.setImageResource(android.R.color.transparent);
        }
    }

    private void SetupPlayers() {
        kitten = new Players();
        kitten.PlayerName = "kitten";
        grumpy = new Players();
        grumpy.PlayerName = "Grumpy";
    }

    public void ResetGame(View view){
        kitten =  null;
        grumpy =  null;
        game = new Game(this);
        SetupPlayers();
        game.hideRestartView();
        setGameGrid();
        game.setGameState(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void PlaceCounter(View view) {
        if (game.getGameState()) DropCounter((ImageView) view);
    }

    private void DropCounter(ImageView view) {
        view.setTranslationY(-1200f);
        String currentPlayer = SelectCounter(view);
        view.animate().translationYBy(1200f).setDuration(500);
        int counterPos =Integer.parseInt(String.valueOf(view.getTag()));
        RecordPlayerCounterPos(counterPos, currentPlayer);
        game.ChangePlayerTurn();
        String kittenStats = game.CheckForWinner(kitten);
        String grumpyStats = game.CheckForWinner(grumpy);

        if (kittenStats != "")  Toast.makeText(getApplicationContext(), kittenStats, Toast.LENGTH_SHORT).show();
        if (grumpyStats != "")  Toast.makeText(getApplicationContext(), grumpyStats, Toast.LENGTH_SHORT).show();
        CheckForDraw();

        if (!game.getGameState()) showRestartView();
    }

    public void CheckForDraw(){
        if (kitten.counterPositions.size() + grumpy.counterPositions.size() == 9){
            TextView gameResult = (TextView) findViewById(R.id.textViewGameResult);
            gameResult.setText("Draw");
            if (!game.getGameState()) showRestartView();
        }
    }

    private void RecordPlayerCounterPos(int counterPos, String currentPlayer) {
        if (currentPlayer == "grumpyCat") {
            grumpy.counterPositions.add(counterPos);
        } else {
            kitten.counterPositions.add(counterPos);
        }
    }

    private String SelectCounter(ImageView view){
        if (game.playersTurn == "grumpyCat") {
            view.setImageDrawable(getResources().getDrawable(R.drawable.grumpycat, getApplicationContext().getTheme()));
            return "grumpyCat";
        } else {
            view.setImageDrawable(getResources().getDrawable(R.drawable.kitten, getApplicationContext().getTheme()));
            return "kitten";
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Animal Connect3")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    void showRestartView() {
        View view= findViewById(R.id.winningKitty);
        view.setVisibility(View.VISIBLE);
        view.bringToFront();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
