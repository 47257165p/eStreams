package tv.estreams.estreams;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import tv.estreams.estreams.json.Game;
import tv.estreams.estreams.json.TopGames;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private WebView webMain;
    private GridView gridMain;
    private TextView textMain;
    private AdapterMainGrid mainAdapter;
    private ArrayList<Game> items;
    private String channel="";
    private String game = "";
    //http://player.twitch.tv/?channel="+channel+"&!branding&player=frontpage&deviceId=4da0a05ee8919056&!channelInfo&controls

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Creación de la vista del fragment.
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        gridMain = (GridView) rootView.findViewById(R.id.gridMain);

        TwitchService service = ServiceGenerator.createService(TwitchService.class);

        items = new ArrayList(Arrays.asList());
        mainAdapter = new AdapterMainGrid(
                getContext(),
                0,
                items);

        gridMain.setAdapter(mainAdapter);

        gameTypesCall(service);

        gridMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Game game = (Game) parent.getItemAtPosition(position);
                String gameName = game.getName();
                Intent gameTypeIntent = new Intent(getContext(), gameTypeActivity.class);
                gameTypeIntent.putExtra("gameName", gameName);
                startActivity(gameTypeIntent);
            }
        });
        return rootView;
    }

    //API CALL using asyncronous retrofit
    public void gameTypesCall (TwitchService service)
    {
        service.topGames().enqueue(new Callback<TopGames>() {
            @Override
            public void onResponse(Response<TopGames> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    TopGames topGames = response.body();

                    for (int i = 0; i < topGames.getTop().size(); i++) {
                        mainAdapter.add(topGames.getTop().get(i).getGame());
                    }
                }
                else
                {
                    try
                    {
                        Log.e(null, response.errorBody().string());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}