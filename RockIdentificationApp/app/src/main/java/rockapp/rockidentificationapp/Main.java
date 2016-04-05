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
        hardnessSelect = connectSpinner(hardnessSelect, R.id.hardness_select, R.array.hardness_array);
        colourSelect = connectSpinner(colourSelect, R.id.colour_select, R.array.colour_array);
        textureSelect = connectSpinner(textureSelect, R.id.texture_select, R.array.texture_array);
        sizeSelect = connectSpinner(sizeSelect, R.id.size_select, R.array.size_array);
    }

    //Sync up the string resource, dropdown in the xml, and this class
    private Spinner connectSpinner(Spinner spinner, int viewId, int stringResourceId) {
        spinner = (Spinner) findViewById(viewId);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, stringResourceId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return spinner;
    }

    public void historyClicked(View view){
        //Necessary workaround (startActivity not able to be called from Controller)
        Intent i = Controller.requestHistory(this);
        startActivity(i);
    }

    public void findRockClicked(View view){
        //Get data values from spinners - We need to subtract one because the first item is a placeholder
        Hardness hardness = Hardness.values()[hardnessSelect.getSelectedItemPosition()];
        Colour colour = Colour.values()[colourSelect.getSelectedItemPosition()];
        Texture texture = Texture.values()[textureSelect.getSelectedItemPosition()];
        Size size = Size.values()[sizeSelect.getSelectedItemPosition()];

        Intent i = Controller.requestSearch(this, hardness, colour, texture, size);
        startActivity(i);
    }
}
