package rockapp.rockidentificationapp;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Niko on 4/1/2016. (booya)
 */
public class Controller {

    public static Intent requestHistory(Context from) {
        Intent i = new Intent(from, History.class);
        //User Database.queryData() -->
        //queryResults <--
        //i.putExtra("HISTORY_DATA", queryResults);
        return i;
    }


    private void swapActivity(){
    }
}
