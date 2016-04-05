package rockapp.rockidentificationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class RockMatches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_matches_view);

        //Pull data sent from intent
        ArrayList<Rock> listOfRocks = (ArrayList<Rock>) this.getIntent().getExtras().getSerializable("MATCHED_ROCKS");//TODO error handling
        displayResults(listOfRocks);
    }

    private void displayResults(ArrayList<Rock> matchedRocks) {
        //TODO display the rocks
        System.out.println("Displaying rock results");
    }
}
