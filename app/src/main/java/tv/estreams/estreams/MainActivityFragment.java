package tv.estreams.estreams;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import tv.estreams.estreams.json.Game;
import tv.estreams.estreams.json.Streams;
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
        webMain = (WebView) rootView.findViewById(R.id.webMain);
        gridMain = (GridView) rootView.findViewById(R.id.gridMain);
        textMain = (TextView) rootView.findViewById(R.id.textMain);

        WebSettings webSettings = webMain.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        TwitchService service = ServiceGenerator.createService(TwitchService.class);
        topCall(service, game);

        items = new ArrayList(Arrays.asList());
        mainAdapter = new AdapterMainGrid(
                getContext(),
                0,
                items);

        gridMain.setAdapter(mainAdapter);

        gameTypesCall(service);

        return rootView;
    }
    public static void rellenarGrid()
    {

    }
    public void topCall(TwitchService service, String type)
    {
        service.games(type).enqueue(new Callback<Streams>() {
            @Override
            public void onResponse(Response<Streams> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Streams streams = response.body();

                    channel = streams.getStreams().get(0).getChannel().getName().toString();
                    textMain.setText(channel);
                    webMain.loadUrl("http://player.twitch.tv/?channel="+channel+"&!branding&player=frontpage&deviceId=97c6511392cbf759&!channelInfo&controls");


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
                t.printStackTrace();
            }
        });
    }

    public void gameTypesCall (TwitchService service)
    {
        service.topGames().enqueue(new Callback<TopGames>() {
            @Override
            public void onResponse(Response<TopGames> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    TopGames topGames = response.body();

                    for (int i = 0; i < topGames.getTop().size(); i++) {
                       items.add(topGames.getTop().get(i).getGame());
                    }
                    mainAdapter.addAll(items);
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

            }
        });
    }
}