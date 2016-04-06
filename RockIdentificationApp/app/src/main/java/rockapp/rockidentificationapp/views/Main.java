package rockapp.rockidentificationapp.views;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import rockapp.rockidentificationapp.Controller;
import rockapp.rockidentificationapp.DatabaseHelper;
import rockapp.rockidentificationapp.R;
import rockapp.rockidentificationapp.enums.Colour;
import rockapp.rockidentificationapp.enums.Hardness;
import rockapp.rockidentificationapp.enums.Size;
import rockapp.rockidentificationapp.enums.Texture;

//Starting page. Searches can be made from here
public class Main extends AppCompatActivity {

    private Controller controller;
    private DatabaseHelper dbhelper;
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

        controller = new Controller(this);

        //Connect private members
        hardnessSelect = connectSpinner(R.id.hardness_select, R.array.hardness_array);
        colourSelect = connectSpinner(R.id.colour_select, R.array.colour_array);
        textureSelect = connectSpinner(R.id.texture_select, R.array.texture_array);
        sizeSelect = connectSpinner(R.id.size_select, R.array.size_array);
        useLocationChkBox = (CheckBox)findViewById(R.id.use_location);
    }

    //Sync up the string resource, dropdown in the xml, and this class
    private Spinner connectSpinner(int viewId, int stringResourceId) {
        Spinner spinner = (Spinner) findViewById(viewId);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, stringResourceId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return spinner;
    }

    public void historyClicked(View view){
        //Necessary workaround (startActivity not able to be called from Controller)
        Intent i = controller.requestHistory(this);
        startActivity(i);
    }

    public void findRockClicked(View view){
        //Get data values from spinners - We need to subtract one because the first item is a placeholder
        Hardness hardness = Hardness.values()[hardnessSelect.getSelectedItemPosition()];
        Colour colour = Colour.values()[colourSelect.getSelectedItemPosition()];
        Texture texture = Texture.values()[textureSelect.getSelectedItemPosition()];
        Size size = Size.values()[sizeSelect.getSelectedItemPosition()];
        boolean useLocation = useLocationChkBox.isChecked();

        //Call controller function with the inputted hardness, colour, texture, size, etc.
        this.databaseList();
        Intent i = controller.requestSearch(this, hardness, colour, texture, size, useLocation);
        startActivity(i);
    }
}
