package tv.estreams.estreams;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import tv.estreams.estreams.json.Channel;
import tv.estreams.estreams.json.Stream;
import tv.estreams.estreams.json.Streams;

/**
 * A placeholder fragment containing a simple view.
 */
public class gameTypeActivityFragment extends Fragment {

    private AdapterListGames mainAdapter;
    private ArrayList<Stream> items;
    private ListView lVGame;

    public gameTypeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_game_type, container, false);
        TwitchService twitchService = ServiceGenerator.createService(TwitchService.class);

        items = new ArrayList(Arrays.asList());
        mainAdapter = new AdapterListGames(
                getContext(),
                0,
                items);

        lVGame = (ListView) rootView.findViewById(R.id.listGameType);
        lVGame.setAdapter(mainAdapter);
        topCall(twitchService, getActivity().getIntent().getExtras().getString("gameName"));

        lVGame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stream channel = (Stream) parent.getItemAtPosition(position);
                Channel channelName = channel.getChannel();
                Intent gameTypeIntent = new Intent(getContext(), videoActivity.class);

                //giving extra info to the new activity, we could just create a new api call but it is much more useful
                //to just give the object
                gameTypeIntent.putExtra("channel", channelName);
                startActivity(gameTypeIntent);
            }
        });

        return rootView;
    }

    //API CALL using asyncronous retrofit retrieving the type of game we want
    public void topCall(TwitchService service, String type)
    {
        service.games(type).enqueue(new Callback<Streams>()
        {
            @Override
            public void onResponse(Response<Streams> response, Retrofit retrofit) {
                if (response.isSuccess())
                {
                    Streams streams = response.body();
                    mainAdapter.addAll(streams.getStreams());
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
