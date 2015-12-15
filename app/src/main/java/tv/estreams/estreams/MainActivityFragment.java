package tv.estreams.estreams;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    WebView webMain;
    GridView gridMain;
    String channel="lvpes";
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

        WebSettings webSettings = webMain.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        //webMain.setWebChromeClient(new WebChromeClient());
        webMain.loadUrl("http://player.twitch.tv/?channel=\"+channel+\"&!branding&player=frontpage&deviceId=4da0a05ee8919056&!channelInfo&controls");
        return rootView;
    }
}