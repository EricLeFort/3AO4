package rockapp.rockidentificationapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by genevieveokon on 2016-04-05.
 */







    public class MainActivity extends AppCompatActivity {
        //EditText edit_name,edit_surname,edit_mark;
        //Button btn_addData;
        DatabaseHelper myDB;
        //EditText edit_name,edit_location,edit_desc;
        //Button btn_addData;
        Cursor data;
        ArrayList<String> list;
        //String listString;
        //TextView newtext;


        //@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            myDB = new DatabaseHelper(this);


            list = new ArrayList<String>();
            //list2 = new ArrayList<String>();

            String display = "ID";
            String display2 = "NAME";//what will be shown to user according to what database finds
            String expert = "COLOUR"; //expert that user inputs
            String find = "BLACK";//name of what to find in the expert






            //Query the database for rocks
            String[] column = new String[]{display, display2, expert};
            String filter = find;

            data = myDB.queryData(column, "COLOUR LIKE \"" + "%" + filter + "%\"");//expert needs to be changed according to wht is needed


            if (data .moveToFirst()) {
                while (!data.isAfterLast()) {
                    String id = data.getString(data.getColumnIndex(display));
                    String name = data.getString(data.getColumnIndex(display2));
                    String expertcolour = data.getString(data.getColumnIndex(expert));

                    list.add(id + ","+ name + " is " + expertcolour);//This will show that ID, and name should be displayed for all rocks that had expert
                    data.moveToNext();
                }
            }



            String[] stringArray = list.toArray(new String[0]);

            TextView newText = (TextView) findViewById(R.id.textView);

            newText.setText(Arrays.toString(stringArray));





        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_rock_view, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();

            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


    }


