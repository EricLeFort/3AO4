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
        queryResults.add(new Rock("History Rock", 0.00, Colour.BLUE, Hardness.HARD, Size.COARSE, Texture.GLOSSY));
        queryResults.add(new Rock("History Rock 2", 0.00, Colour.BLUE, Hardness.HARD, Size.COARSE, Texture.GLOSSY));
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
        Rock[] query;
        forum = null;

        //Adds all rocks matching specified hardness.
        if(hardness != Hardness.UNKNOWN){
            forum = new Forum(dbHelper.queryData("Hardness LIKE '" + hardness + "'"));
        }

        //Adds all rocks matching specified colour.
        if(colour != Colour.UNKNOWN){
            query = dbHelper.queryData("Colour == '" + colour + "'");
            if(forum == null){
                forum = new Forum(query);
            }else{
                forum.addList(query);
            }
        }

        //Adds all rocks matching specified texture.
        if(texture != Texture.UNKNOWN){
            query = dbHelper.queryData("Texture == '" + texture + "'");
            if(forum == null){
                forum = new Forum(query);
            }else{
                forum.addList(query);
            }
        }

        //Adds all rocks matching specified size.
        if(size != Size.UNKNOWN){
            query = dbHelper.queryData("Size == '" + size + "'");
            if(forum == null){
                forum = new Forum(query);
            }else{
                forum.addList(query);
            }
        }

        //Adds all rocks matching User's current location.
        if(useLocation) {
            try{
                LocationManager service = (LocationManager)from.getSystemService(Context.LOCATION_SERVICE);
                Criteria criteria = new Criteria();
                String provider = service.getBestProvider(criteria, false);
                Location location = service.getLastKnownLocation(provider);
                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());

                //TODO refine query results using location data
            } catch (SecurityException se) {
                new AlertDialog.Builder(from)
                        .setTitle("Location Services")
                        .setMessage("Unable to obtain Location Services permission.")
                        .show();
            }catch(IllegalArgumentException iae){
                new AlertDialog.Builder(from)
                        .setTitle("Illegal Argument Exception")
                        .setMessage("Provider is giving issues.")
                        .show();
            }
        }

        //Returns the empty list here to prevent null references.
        if(forum == null){
            return i;
        }

        for(int j = 0; j < forum.getCommonElements().length; j++){
            queryResults.add(forum.getCommonElements()[j]);
        }
        dataBundle.putSerializable("ROCK_LIST", queryResults);
        i.putExtras(dataBundle);
        return i;
    }
}
