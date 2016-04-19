package tv.estreams.estreams;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import tv.estreams.estreams.json.Channel;

/**
 * A placeholder fragment containing a simple view.
 */
public class videoActivityFragment extends Fragment {

    SQLiteDatabase database;

    public videoActivityFragment() {
    }

    //finish the activity when we "pause" it
    @Override
    public void onPause() {
        super.onPause();
        getActivity().finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
        final Button bTSave = (Button) rootView.findViewById(R.id.bTSave);

        final Channel channel = (Channel) getActivity().getIntent().getExtras().get("channel");

        bTSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //we create the database if it does not exists or open it if it does
                database = getActivity().openOrCreateDatabase("database", Context.MODE_PRIVATE, null);

                //creating the table channel to save the user favorites info
                database.execSQL("CREATE TABLE IF NOT EXISTS channel(Id INTEGER, Name VARCHAR, Game VARCHAR, Url VARCHAR, Followers INTEGER, Views INTEGER);");
                insertChannel(channel.getId(),
                        channel.getName(),
                        channel.getGame(),
                        channel.getUrl(),
                        channel.getFollowers(),
                        channel.getViews());
                database.close();

                //changing the icon when the user clicks on the save option so we can apreciate that something happened
                bTSave.setBackgroundResource(R.drawable.ic_favorite_black_24dpbigger);
                bTSave.setText("");
            }
        });

        //inserting the video by webView. It might not work if your device does not support
        WebView webMain = (WebView) rootView.findViewById(R.id.webVideo);
        WebSettings webSettings = webMain.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webMain.loadUrl("http://player.twitch.tv/?channel=" + channel.getName() + "&!branding&player=frontpage&deviceId=97c6511392cbf759&!channelInfo&controls");
        return rootView;
    }
    private void insertChannel(int id, String name, String game, String url, int followers, int views)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id", id);
        contentValues.put("Name", name);
        contentValues.put("Game", game);
        contentValues.put("Url", url);
        contentValues.put("Followers", followers);
        contentValues.put("Views", views);

        //comprobate if data with that id exist, if it does, updates it, if dont, inserts.
        if (comprobateExist(id))
        {
            database.update("channel", contentValues, "Id="+id, null);
        }
        else
        {
            database.insert("channel", null, contentValues);
        }
    }

    //method that comprobates if cursor result is null or doesnt so we can update or insert later.
    private boolean comprobateExist(int id)
    {
        Cursor resultSet = database.rawQuery("Select * from channel where Id="+id, null);
        if (resultSet.getCount()==0)
        {
            return false;
        }
        else return true;
    }

}
