package rockapp.rockidentificationapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import rockapp.rockidentificationapp.R;
import rockapp.rockidentificationapp.Rock;

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
        rockList = (ListView) findViewById(R.id.rock_list);
        //For now, just display the names of the rocks
        ArrayList<String> stringlist = new ArrayList<String>();
        for(int i=0;i<matchedRocks.size();i++){
            stringlist.add(matchedRocks.get(i).toString());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringlist);
        rockList.setAdapter(arrayAdapter);
    }
}
