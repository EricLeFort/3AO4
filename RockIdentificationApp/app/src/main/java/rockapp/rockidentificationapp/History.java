package rockapp.rockidentificationapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void displayHistory(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //TODO this needs to be able to pull the history data from somewhere
            //Rock r = extras.get("HISTORY_DATA");
        }
    }

}
