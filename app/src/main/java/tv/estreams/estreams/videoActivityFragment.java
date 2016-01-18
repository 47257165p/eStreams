package tv.estreams.estreams;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * A placeholder fragment containing a simple view.
 */
public class videoActivityFragment extends Fragment {

    public videoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
        String channel = getActivity().getIntent().getExtras().getString("channelName");
        WebView webMain = (WebView) rootView.findViewById(R.id.webVideo);
        WebSettings webSettings = webMain.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webMain.loadUrl("http://player.twitch.tv/?channel="+channel+"&!branding&player=frontpage&deviceId=97c6511392cbf759&!channelInfo&controls");
        return rootView;
    }
}
