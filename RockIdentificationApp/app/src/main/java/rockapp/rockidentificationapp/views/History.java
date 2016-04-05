package rockapp.rockidentificationapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import rockapp.rockidentificationapp.R;
import rockapp.rockidentificationapp.Rock;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Pull data sent from intent
        ArrayList<Rock> listOfRocks = (ArrayList<Rock>) this.getIntent().getExtras().getSerializable("HISTORY_DATA");//TODO error handling
        displayHistory(listOfRocks);
    }

    private void displayHistory(ArrayList<Rock> listOfRocks){
        System.out.println("# of rocks: " + listOfRocks.size());
        //TODO display the rocks in the window
    }

}
