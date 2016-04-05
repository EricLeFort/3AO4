package rockapp.rockidentificationapp;

import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;


import android.content.Context;
import android.content.Intent;
import android.location.*;

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
        dataBundle.putSerializable("ROCK_LIST", queryResults);
        i.putExtras(dataBundle);
        return i;
    }

    //Calling this returns an intent pointing to the rock matches activity
    //The intent will be populated by a list of rocks returned by the forum
    public static Intent requestSearch(Context from, Hardness hardness, Colour colour, Texture texture, Size size){
        Intent i = new Intent(from, RockMatches.class);
        //TODO pull this from the forum?
        //Would also likely grab GPS location here
        try {
            LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = service.getBestProvider(criteria, false);
            Location location = service.getLastKnownLocation(provider);
            LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
            new AlertDialog.Builder(context)    //TODO delete this alert once we are sure we can get location information.
                    .setTitle("Location Info")
                    .setMessage("Lat: " + userLocation.latitude + "Lon: " + userLocation.longitude)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }catch(SecurityException se){ //User did not give permission to access location. }
        ArrayList<Rock> queryResults = new ArrayList<Rock>();
        queryResults.add(new Rock("Search Rock", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        queryResults.add(new Rock("Search Rock 2", Colour.BLUE_TEMP, Hardness.HARD_TEMP, Size.BIG_TEMP, Texture.BRITTLE_TEMP));
        Bundle dataBundle = new Bundle();
        dataBundle.putSerializable("ROCK_LIST", queryResults);
        i.putExtras(dataBundle);
        return i;
    }
}
