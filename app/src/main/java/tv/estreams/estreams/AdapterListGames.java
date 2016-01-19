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
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_text_game_type, parent, false);
                TextView tVList = (TextView) convertView.findViewById(R.id.tVList);
                tVList.setText("CANALES EN ESPAÑOL");
                break;
            }
            case 1:
            case 2:
            {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.listview_image_game_type, parent, false);
                Stream stream = getItem(position-1);
                posterPath = "http://static-cdn.jtvnw.net/previews-ttv/live_user_"+stream.getChannel().getName()+"-320x180.jpg";

                ImageView iVList = (ImageView) convertView.findViewById(R.id.iVList);
                TextView tVListImage1 = (TextView) convertView.findViewById(R.id.tVListImage1);
                TextView tVListImage2 = (TextView) convertView.findViewById(R.id.tVListImage2);
                TextView tVListImage3 = (TextView) convertView.findViewById(R.id.tVListImage3);

                tVListImage1.setText(stream.getChannel().getName());
                tVListImage2.setText("reproduciendo "+stream.getGame());
                tVListImage3.setText(stream.getChannel().getViews()+" espectadores");
                
                Picasso.with(getContext()).load(posterPath).fit().into(iVList);
                break;
            }
            case 3:
            {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.listview_text_game_type, parent, false);
                TextView tVList = (TextView) convertView.findViewById(R.id.tVList);
                tVList.setText("TODOS LOS CANALES");
                break;
            }
            default:
            {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_image_game_type, parent, false);
                Stream stream = getItem(position-2);
                posterPath = "http://static-cdn.jtvnw.net/previews-ttv/live_user_"+stream.getChannel().getName()+"-320x180.jpg";
                ImageView iVList = (ImageView) convertView.findViewById(R.id.iVList);
                TextView tVListImage1 = (TextView) convertView.findViewById(R.id.tVListImage1);
                TextView tVListImage2 = (TextView) convertView.findViewById(R.id.tVListImage2);
                TextView tVListImage3 = (TextView) convertView.findViewById(R.id.tVListImage3);

                tVListImage1.setText(stream.getChannel().getName());
                tVListImage2.setText("reproduciendo "+stream.getGame());
                tVListImage3.setText(stream.getChannel().getViews()+" espectadores");
                Picasso.with(getContext()).load(posterPath).fit().into(iVList);
                break;
            }
        }
        return convertView;
    }
}
