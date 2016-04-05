package rockapp.rockidentificationapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import rockapp.rockidentificationapp.enums.Colour;
import rockapp.rockidentificationapp.enums.Hardness;
import rockapp.rockidentificationapp.enums.Size;
import rockapp.rockidentificationapp.enums.Texture;
import rockapp.rockidentificationapp.views.History;
import rockapp.rockidentificationapp.views.RockMatches;

/**
 * Created by Niko on 4/1/2016. (booya)
 *
 * Implementation Notes:
 *
 * Intents are meant to be used to directly jump between activities in Android. By using blackboard architecture, we require
 * the use of a controller through which most commands travel. To combine these two methodologies, an activity will call a method on the controller
 * to acquire an Intent (Transition between pages), which will then be run by the original activity. Running the intent will trigger another page opening.
 */
public class Controller {

    //Calling this returns an intent pointing to the history activity.
    //The intent will be populated by a list of rocks saved by the user
    public static Intent requestHistory(Context from) {
        Intent i = new Intent(from, History.class);
        //TODO Database Query
        //User Database.queryData() -->
        //queryResults <--
        ArrayList<Rock> queryResults = new ArrayList<Rock>();
        queryResults.add(new Rock("History Rock", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        queryResults.add(new Rock("History Rock 2", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        Bundle dataBundle = new Bundle();
        dataBundle.putSerializable("HISTORY_DATA", queryResults);
        i.putExtras(dataBundle);
        return i;
    }

    //Calling this returns an intent pointing to the rock matches activity
    //The intent will be populated by a list of rocks returned by the forum
    public static Intent requestSearch(Context from, Hardness hardness, Colour colour, Texture texture, Size size){
        Intent i = new Intent(from, RockMatches.class);
        //TODO pull this from the forum?
        //Would also likely grab GPS location here
        ArrayList<Rock> queryResults = new ArrayList<Rock>();
        queryResults.add(new Rock("Search Rock", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        queryResults.add(new Rock("Search Rock 2", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        Bundle dataBundle = new Bundle();
        dataBundle.putSerializable("MATCHED_ROCKS", queryResults);
        i.putExtras(dataBundle);
        return i;
    }
}
