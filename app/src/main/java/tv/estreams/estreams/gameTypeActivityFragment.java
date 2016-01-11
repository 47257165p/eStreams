package tv.estreams.estreams;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import tv.estreams.estreams.json.Game;
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
        TwitchService service = ServiceGenerator.createService(TwitchService.class);


        items = new ArrayList(Arrays.asList());
        mainAdapter = new AdapterListGames(
                getContext(),
                0,
                items);

        lVGame = (ListView) rootView.findViewById(R.id.listGameType);
        lVGame.setAdapter(mainAdapter);
        topCall(service, getActivity().getIntent().getExtras().getString("gameName"));

        return rootView;
    }

    public void topCall(TwitchService service, String type)
    {
        service.games(type).enqueue(new Callback<Streams>() {
            @Override
            public void onResponse(Response<Streams> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Streams streams = response.body();
                    mainAdapter.addAll(streams.getStreams());
                }
                else {
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
}
