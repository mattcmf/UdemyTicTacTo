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

import static demos.udemytictacto.R.id.grumpyCatLeftBottom;
import static demos.udemytictacto.R.id.grumpyCatLeftMiddle;
import static demos.udemytictacto.R.id.grumpyCatLeftTop;
import static demos.udemytictacto.R.id.grumpyCatMiddleBottom;
import static demos.udemytictacto.R.id.grumpyCatMiddleMiddle;
import static demos.udemytictacto.R.id.grumpyCatMiddleTop;
import static demos.udemytictacto.R.id.grumpyCatRightBottom;
import static demos.udemytictacto.R.id.grumpyCatRightMiddle;
import static demos.udemytictacto.R.id.grumpyCatRightTop;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    Game game;
    String playersTurn;
    Players kitten;
    Players grumpy;
    boolean clickedFlagGridLeftTop = false;
    boolean clickedFlagGridMiddleTop = false;
    boolean clickedFlagGridRightTop = false;
    boolean clickedFlagGridLeftMiddle = false;
    boolean clickedFlagGridMiddleMiddle = false;
    boolean clickedFlagGridRightMiddle = false;
    boolean clickedFlagGridLeftBottom = false;
    boolean clickedFlagGridMiddleBottom = false;
    boolean clickedFlagGridRightBottom = false;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //TODO: Need to update layout to use grid view and align counters using padding

    //TODO: Need to set gridview background to game board

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
        game.start();
        playersTurn = "kitten";
        kitten = new Players();
        kitten.PlayerName = "kitten";
        grumpy = new Players();
        grumpy.PlayerName = "Grumpy";


        ImageView iv0, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;

        iv0 = (ImageView) findViewById(grumpyCatLeftBottom);
        iv1 = (ImageView) findViewById(grumpyCatLeftMiddle);
        iv2 = (ImageView) findViewById(grumpyCatLeftTop);
        iv3 = (ImageView) findViewById(grumpyCatMiddleTop);
        iv4 = (ImageView) findViewById(grumpyCatMiddleMiddle);
        iv5 = (ImageView) findViewById(grumpyCatMiddleBottom);
        iv6 = (ImageView) findViewById(grumpyCatRightTop);
        iv7 = (ImageView) findViewById(grumpyCatRightMiddle);
        iv8 = (ImageView) findViewById(grumpyCatRightBottom);


        ImageView[] IMGS = {iv0, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8};

        IMGS[0] = iv0;
        IMGS[1] = iv1;
        IMGS[2] = iv2;
        IMGS[3] = iv3;
        IMGS[4] = iv4;
        IMGS[5] = iv5;
        IMGS[6] = iv6;
        IMGS[7] = iv7;
        IMGS[8] = iv8;


        for (ImageView img : IMGS) {
            img.animate().translationY(-1500f);
        }


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void PlaceCounter(View view) {

        switch (view.getId()) {

            case R.id.gridLeftTop:
                //TODO: This will perform animation on the Rick image, but if I instead call placecounter on
                // the cat image (and set its source to blank to start with) then I don't need to specify the grumpy cat every time.
                if (!clickedFlagGridLeftTop) DropCounter((ImageView) view, 1);
                clickedFlagGridLeftTop = true;
                break;
            case R.id.gridMiddleTop:
                //TODO: Need to add tagging to activity_main.xml to get position
                //Counter.getTag
                if (!clickedFlagGridMiddleTop) DropCounter((ImageView) findViewById(grumpyCatMiddleTop), 2);
                clickedFlagGridMiddleTop = true;
                break;
            case R.id.gridRightTop:
                if (!clickedFlagGridRightTop) DropCounter((ImageView) findViewById(grumpyCatRightTop), 3);
                clickedFlagGridRightTop = true;
                break;
            case R.id.gridLeftMiddle:
                if (!clickedFlagGridLeftMiddle) DropCounter((ImageView) findViewById(grumpyCatLeftMiddle), 4);
                clickedFlagGridLeftMiddle = true;
                break;
            case R.id.gridMiddleMiddle:
                if (!clickedFlagGridMiddleMiddle) DropCounter((ImageView) findViewById(grumpyCatMiddleMiddle), 5);
                clickedFlagGridMiddleMiddle = true;
                break;
            case R.id.gridRightMiddle:
                if (!clickedFlagGridRightMiddle) DropCounter((ImageView) findViewById(grumpyCatRightMiddle), 6);
                clickedFlagGridRightMiddle = true;
                break;
            case R.id.gridLeftBottom:
                if (!clickedFlagGridLeftBottom) DropCounter((ImageView) findViewById(grumpyCatLeftBottom), 7);
                clickedFlagGridLeftBottom = true;
                break;
            case R.id.gridMiddleBottom:
                if (!clickedFlagGridMiddleBottom) DropCounter((ImageView) findViewById(grumpyCatMiddleBottom), 8);
                clickedFlagGridMiddleBottom = true;
                break;
            case R.id.gridRightBottom:
                if (!clickedFlagGridRightBottom) DropCounter((ImageView) findViewById(grumpyCatRightBottom), 9);
                clickedFlagGridRightBottom = true;
                break;
        }
    }

    private void DropCounter(ImageView view, int counterPos) {

        //TODO: Need to add flag to check whether game is active

        //TODO: Setting the ByX value to 9000 here will avoid the double tap goes off screen bug
        // It does require having the image set to null source though.

        String currentPlayer = SelectCounter(view);
        view.animate().translationYBy(1500f).setDuration(500);
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
