package rockapp.rockidentificationapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import rockapp.rockidentificationapp.R;
import rockapp.rockidentificationapp.Rock;
import rockapp.rockidentificationapp.RockList;

public class RockMatches extends AppCompatActivity {

    private ListView rockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_matches_view);

        //Pull data sent from intent
        ArrayList<Rock> listOfRocks = (ArrayList<Rock>) this.getIntent().getExtras().getSerializable("MATCHED_ROCKS");//TODO error handling
        displayResults(listOfRocks);
    }

    private void displayResults(ArrayList<Rock> matchedRocks) {
        //Create the RockList (populate it with matchedRocks)
        RockList adapter = new RockList(this,matchedRocks);

        rockList = (ListView) findViewById(R.id.rock_list);
        rockList.setAdapter(adapter);
    }
}
