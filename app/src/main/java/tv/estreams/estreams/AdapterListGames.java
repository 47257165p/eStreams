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
import tv.estreams.estreams.json.Stream;

/**
 * Created by 47257165p on 11/01/16.
 */
public class AdapterListGames extends ArrayAdapter <Stream>{

    String posterPath;

    public AdapterListGames(Context context, int resource, List<Stream> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        switch (position)
        {
            case 0:
            {
                if (convertView==null)
                {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    convertView = inflater.inflate(R.layout.listview_text_game_type, parent, false);
                    TextView tVList = (TextView) convertView.findViewById(R.id.tVList);
                    tVList.setText("Hola");
                }
            }
            default:
            {
                if (convertView==null)
                {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    convertView = inflater.inflate(R.layout.listview_image_game_type, parent, false);
                }
                Stream stream = getItem(position);
                posterPath = "http://static-cdn.jtvnw.net/ttv-static/404_preview-320x180.jpg";

                ImageView iVList = (ImageView) convertView.findViewById(R.id.iVList);



                Picasso.with(getContext()).load(posterPath).fit().into(iVList);
            }
        }
        return convertView;
    }
}
