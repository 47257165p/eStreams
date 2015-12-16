package tv.estreams.estreams;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import tv.estreams.estreams.json.Streams;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    WebView webMain;
    GridView gridMain;
    TextView textMain;
    String channel="nightblue3";
    // https://www-cdn.jtvnw.net/swflibs/TwitchPlayer.swf?channel=lvpes&bgcolor=
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
        String game = "";

        WebSettings webSettings = webMain.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        TwitchService service = ServiceGenerator.createService(TwitchService.class);
        service.games(game).enqueue(new Callback<Streams>() {
            @Override
            public void onResponse(Response<Streams> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Streams streams = response.body();

                    channel = streams.getStreams().get(0).getChannel().getName().toString();
                    textMain.setText(channel);
                    webMain.loadUrl("http://player.twitch.tv/?channel="+channel+"&!branding&player=frontpage&deviceId=97c6511392cbf759&!channelInfo&controls");
                } else {
                    try {
                        Log.e(null, response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });

        return rootView;
    }
}