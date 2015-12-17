package tv.estreams.estreams;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

import tv.estreams.estreams.json.Game;

/**
 * Created by 47257165p on 16/12/15.
 */
public class AdapterMainGrid extends ArrayAdapter <Game>{

    private String posterURL;

    public AdapterMainGrid(Context context, int resource, List<Game> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Game game = getItem(position);

        if (convertView==null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.gridview_mainfragment_item_layout, parent, false);
        }

        ImageView iV = (ImageView) convertView.findViewById(R.id.iVGrid);
        TextView tV = (TextView) convertView.findViewById(R.id.tVGrid);

        tV.setText(game.getName());
        posterURL=game.getBox().getMedium();

        Picasso.with(getContext()).load(posterURL).fit().into(iV);
        return convertView;
    }
}
