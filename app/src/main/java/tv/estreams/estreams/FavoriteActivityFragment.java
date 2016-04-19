package tv.estreams.estreams;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class FavoriteActivityFragment extends Fragment {

    ArrayAdapter<String> adapter;

    public FavoriteActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_favorite, container, false);

        ListView lVFavorite = (ListView) rootview.findViewById(R.id.lVFavorite);

        //opening the database
        SQLiteDatabase database = getActivity().openOrCreateDatabase("database", Context.MODE_PRIVATE, null);
        Cursor resultSet = database.rawQuery("Select * from channel", null);

        ArrayList<String> listItems = new ArrayList<>();

        //adapter to show the info of our favorite channels
        adapter = new ArrayAdapter<> (getContext(),
                android.R.layout.simple_list_item_1,
                listItems);

        lVFavorite.setAdapter(adapter);

        String channelInfo;

        //giving the listView info for each result we got
        while (resultSet.moveToNext())
        {
            channelInfo = "Name: "+resultSet.getString(1)+"\n"+
                    "Game: "+resultSet.getString(2)+"\n"+
                    "URL: "+resultSet.getString(3)+"\n"+
                    "Followers: "+resultSet.getString(4)+"\n"+
                    "Views: "+resultSet.getString(5)+"\n";
            listItems.add(channelInfo);
        }
        return rootview;
    }
}
