package rockapp.rockidentificationapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Niko on 4/1/2016. (booya)
 */
public class Controller {

    public static Intent requestHistory(Context from) {
        Intent i = new Intent(from, History.class);
        //User Database.queryData() -->
        //queryResults <--
        ArrayList<Rock> queryResults = new ArrayList<Rock>();
        queryResults.add(new Rock("Some Rock", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        Bundle dataBundle = new Bundle();
        dataBundle.putSerializable("HISTORY_DATA", queryResults);
        i.putExtras(dataBundle);
        return i;
    }

    public static Intent requestSearch(Context from){
        Intent i = new Intent(from, RockMatches.class);
        //TODO pull this from the forum?
        ArrayList<Rock> queryResults = new ArrayList<Rock>();
        queryResults.add(new Rock("Some Rock", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        Bundle dataBundle = new Bundle();
        dataBundle.putSerializable("MATCHED_ROCKS", queryResults);
        i.putExtras(dataBundle);
        return i;
    }


    private void swapActivity(){
    }
}
