package rockapp.rockidentificationapp;

import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;


import android.content.Context;
import android.content.Intent;
import android.location.*;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

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
 * Implementation Notes for group members:
 *
 * Intents are meant to be used to directly jump between activities in Android. By using blackboard architecture, we require
 * the use of a controller through which most commands travel. To combine these two methodologies, an activity will call a method on the controller
 * to acquire an Intent (Transition between pages), which will then be run by the original activity. Running the intent will trigger another page opening.
 *
 * 1. Page calls Controller function with any necessary parameters
 * 2. Controller prepares any data required by the soon-to-open page (e.g. sending requests to DB, Experts/Forum, etc.)
 * 3. Controller packages the data gathered in (2) in a bundle that is then packaged into an Intent
 * 4. The Intent is sent back to Page, where it is then executed.
 */
public class Controller{
    private Forum forum;
    private DatabaseHelper dbHelper;

    public Controller(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    //Calling this returns an intent pointing to the history activity.
    //The intent will be populated by a list of rocks saved by the user
    public Intent requestHistory(Context from) {
        Intent i = new Intent(from, History.class);
        //TODO Database Query
        //User Database.queryData() -->
        //queryResults <--
        ArrayList<Rock> queryResults = new ArrayList<Rock>();
        queryResults.add(new Rock("History Rock", 0.00, Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        queryResults.add(new Rock("History Rock 2", 0.00, Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        Bundle dataBundle = new Bundle();
        dataBundle.putSerializable("ROCK_LIST", queryResults);
        i.putExtras(dataBundle);
        return i;
    }

    //Calling this returns an intent pointing to the rock matches activity
    //The intent will be populated by a list of rocks returned by the forum
    public Intent requestSearch(Context from, Hardness hardness, Colour colour, Texture texture, Size size, boolean useLocation){
        Intent i = new Intent(from, RockMatches.class);
        ArrayList<Rock> queryResults = new ArrayList<Rock>();
        Bundle dataBundle = new Bundle();
        forum = null;

        //TODO Check each attribute. If selected, query db, construct Rock array using results,
        // add those Rocks to Forum or create new Forum if there's not one yet.
        if(hardness != Hardness.UNKNOWN){
            //TODO
            if(forum == null){

            }else{

            }
        }

        //TODO query db for everything but location here.
        if(useLocation) {
            try{
                LocationManager service = (LocationManager)from.getSystemService(Context.LOCATION_SERVICE);
                Criteria criteria = new Criteria();
                String provider = service.getBestProvider(criteria, false);
                Location location = service.getLastKnownLocation(provider);
                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());

                //TODO refine query results using location data
            } catch (SecurityException se) {
                /*We were unable to obtain Location Services permission.*/
            }catch(IllegalArgumentException iae){
                /*Likely due to not being able to find a provider*/
            }
        }

        queryResults.add(new Rock("Search Rock", 0.00, Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));//TODO remove
        queryResults.add(new Rock("Search Rock 2", 0.00, Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));//TODO remove
        dataBundle.putSerializable("ROCK_LIST", queryResults);
        i.putExtras(dataBundle);
        return i;
    }
}
