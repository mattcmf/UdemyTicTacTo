package demos.udemytictacto;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    Game game;
    String playersTurn;
    Players kitten;
    Players grumpy;
    boolean clickedFlagGridLeftTop = false;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //TODO: Need to update layout to use grid view and align counters using padding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WinningPatterns.Setup();
        game = new Game();
        game.start();
        playersTurn = "kitten";
        kitten = new Players();
        kitten.PlayerName = "kitten";
        grumpy = new Players();
        grumpy.PlayerName = "Grumpy";

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void PlaceCounter(View view) {
        if (!clickedFlagGridLeftTop) DropCounter((ImageView) view);
                //clickedFlagGridLeftTop = true;
    }

    private void DropCounter(ImageView view) {

        //TODO: Need to add flag to check whether game is active

        view.setTranslationY(-1200f);
        String currentPlayer = SelectCounter(view);
        view.animate().translationYBy(1200f).setDuration(500);
        int counterPos =Integer.parseInt(String.valueOf(view.getTag()));
        RecordPlayerCounterPos(counterPos, currentPlayer);
        ChangePlayerTurn();
        String kittenStats = game.CheckForWinner(kitten);
        String grumpyStats = game.CheckForWinner(grumpy);

        if (kittenStats != "")  Toast.makeText(getApplicationContext(), kittenStats, Toast.LENGTH_SHORT).show();
        if (grumpyStats != "")  Toast.makeText(getApplicationContext(), grumpyStats, Toast.LENGTH_SHORT).show();
    }

    private void ChangePlayerTurn() {
        if (playersTurn == "grumpyCat") {
            playersTurn = "kitten";
        } else {
            playersTurn = "grumpyCat";
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
        if (playersTurn == "grumpyCat") {
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
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
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
