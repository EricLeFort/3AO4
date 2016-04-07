package rockapp.rockidentificationapp.views;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import rockapp.rockidentificationapp.R;
import rockapp.rockidentificationapp.Rock;
import rockapp.rockidentificationapp.RockList;

//Display the results of a rock search.
//Expect the incoming intent to include an ArrayList<Rock> under the key "ROCK_LIST"
public class RockMatches extends AppCompatActivity {

    private ListView rockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_matches_view);

        //Pull data sent from intent
        if(this.getIntent().getExtras() != null){
            ArrayList<Rock> listOfRocks = (ArrayList<Rock>) this.getIntent().getExtras().getSerializable("ROCK_LIST");//TODO error handling
            displayResults(listOfRocks);
        }
    }

    private void displayResults(final ArrayList<Rock> matchedRocks) {
        //Create the RockList (populate it with matchedRocks)
        final ArrayList<Rock> duplicateFreeList = new ArrayList<Rock>();

        for(int i = 0; i < matchedRocks.size(); i++){
            if(!duplicateFreeList.contains(matchedRocks.get(i))){
                duplicateFreeList.add(matchedRocks.get(i));
            }
        }
        RockList adapter = new RockList(RockMatches.this,duplicateFreeList);

        rockList = (ListView) findViewById(R.id.rock_list);
        rockList.setAdapter(adapter);
        rockList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Rock rock = duplicateFreeList.get(position);
                SQLiteDatabase db=this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                //TODO NICK
                contentValues.put("NAME", rock.toString());
                contentValues.put("VALUE", rock.getValue());
                contentValues.put("HARDNESS", rock.getHardness().toString());
                contentValues.put("COLOUR", rock.getColour().toString());
                contentValues.put("TEXTURE", rock.getTexture().toString());
                contentValues.put("SIZE", rock.getSize().toString());
                contentValues.put("LATITUDE", rock.getLat());
                contentValues.put("LONGITUDE", rock.getLon());
                contentValues.put("RADIUS", rock.getRad());

                long result = db.insert(TABLE_NAME,null,contentValues);
                Toast.makeText(RockMatches.this, "Added " + rock.toString() + " to history.", Toast.LENGTH_SHORT).show();
                //TODO Add this rock to the database of saved rocks
            }
        });
    }
}
