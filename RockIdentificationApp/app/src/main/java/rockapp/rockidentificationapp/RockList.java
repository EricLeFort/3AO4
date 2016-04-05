package rockapp.rockidentificationapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Niko on 4/5/2016.
 *
 * Custom ListView to display a list of rocks (used in both history and searches)
 */
public class RockList extends ArrayAdapter<Rock> {
    private final Activity context;
    private final ArrayList<Rock> rockMembers;

    public RockList(Activity context,
                      ArrayList<Rock> rocks) {
        super(context, R.layout.rock_list, rocks);
        this.context = context;
        rockMembers = rocks;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.rock_list, null, true);

        Rock rock = rockMembers.get(position);

        //Fill each individual list view with the information from Rock rock.
        TextView rockTitle = (TextView) rowView.findViewById(R.id.rock_name);
        rockTitle.setText(rock.toString());

        TextView rockDescription = (TextView) rowView.findViewById(R.id.rock_description);
        rockDescription.setText(rock.getHardness().toString());

        //TODO grab image
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        //imageView.setImageResource(imageId[position]);

        return rowView;
    }
}
