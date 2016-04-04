package rockapp.rockidentificationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

public class Main extends AppCompatActivity {

    private Spinner hardnessSelect;
    private Spinner colourSelect;
    private Spinner textureSelect;
    private Spinner sizeSelect;
    private CheckBox useLocationChkBox;
    private Button historyBtn;
    private Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect private members
        connectSpinner(hardnessSelect, R.id.hardness_select, R.array.hardness_array);
        connectSpinner(colourSelect, R.id.colour_select, R.array.colour_array);
        connectSpinner(textureSelect, R.id.texture_select, R.array.texture_array);
        connectSpinner(sizeSelect, R.id.size_select, R.array.size_array);
    }

    //Sync up the string resource, dropdown in the xml, and this class
    private void connectSpinner(Spinner spinner, int viewId, int stringResourceId) {
        spinner = (Spinner) findViewById(viewId);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, stringResourceId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void historyClicked(View view){
        //Necessary workaround (startActivity not able to be called from Controller)
        Intent i = Controller.requestHistory(this);
        startActivity(i);
    }
}
